package com.fpt.t1708e.photoplatform.controller;

import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.CustomerInfo;
import com.fpt.t1708e.photoplatform.entity.PhotographerInfo;
import com.fpt.t1708e.photoplatform.entity.StudioInfo;
import com.fpt.t1708e.photoplatform.repository.AccountRepository;
import com.fpt.t1708e.photoplatform.repository.CustomerInfoRepository;
import com.fpt.t1708e.photoplatform.repository.PhotographerInfoRepository;
import com.fpt.t1708e.photoplatform.repository.StudioInfoRepository;
import com.fpt.t1708e.photoplatform.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.rmi.RemoteException;

@Controller
public class RegisterController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CustomerInfoRepository customerInfoRepository;

    @Autowired
    PhotographerInfoRepository photographerInfoRepository;

    @Autowired
    StudioInfoRepository studioInfoRepository;

    // test view tạo account customer
    @RequestMapping(method = RequestMethod.GET,value = "/register/customer")
    public String testRegisterCustomer(){
        return "register/customerInfo";
    }

    // test view tạo account photographer
    @RequestMapping(method = RequestMethod.GET,value = "/register/photographer")
    public String testRegisterPhotographer(){
        return "register/photographerInfo";
    }

    // test view tạo account studio
    @RequestMapping(method = RequestMethod.GET,value = "/register/studio")
    public String testRegisterStudio(){
        return "register/studioInfo";
    }

    // tao account
    @RequestMapping(method = RequestMethod.GET, value = "/register/account")
    public String registerAccount(Model model){
        model.addAttribute("account", new Account());
        return "account/register";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register/account")
    public String storeAccount(Model model, @Valid Account account, BindingResult bindingResult) throws RemoteException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("account", account);
            return "account/register";
        }
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        Account createdAccount = accountRepository.save(account);
        if(createdAccount != null) {
            if (account.getRole() == 1) {
                return "redirect:/register/customerInfo/" + createdAccount.getId();
            }
            if (account.getRole() == 2) {
                return "redirect:/register/photographerInfo/" + createdAccount.getId();
            }
            if (account.getRole() == 3) {
                return "redirect:/register/studioInfo/" + createdAccount.getId();
            }
            return "redirect:/login";
        }
        return "error";
    }
    // tao account

    // tao customerInfo
    @RequestMapping(method = RequestMethod.GET, value = "/register/customerInfo/{accountId}")
    public String registerCustomerInfo(Model model, @PathVariable long accountId){
        CustomerInfo customerInfo = new CustomerInfo();
        model.addAttribute("accountId", accountId);
        model.addAttribute("customerInfo", customerInfo);
        return "account/customerInfo";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register/customerInfo")
    public String storeUserInfo(Model model, @Valid CustomerInfo customerInfo, BindingResult bindingResult, long accountId) throws RemoteException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerInfo", customerInfo);
            return "account/customerInfo";
        }
        Account account = accountRepository.findById(accountId).orElse(null);
        if(account != null){
            customerInfo.setAccount(account);
        }
        customerInfoRepository.save(customerInfo);
        return "redirect:/login";
    }

    // tao customerInfo


    //tao photographerInfo
    @RequestMapping(method = RequestMethod.GET, value = "/register/photographerInfo/{accountId}")
    public String registerPhotographerInfo(Model model, @PathVariable long accountId){
        PhotographerInfo photographerInfo = new PhotographerInfo();
        model.addAttribute("accountId", accountId);
        model.addAttribute("photographerInfo", photographerInfo);
        return "account/photographerInfo";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register/photographerInfo")
    public String storePhotographerInfo(Model model, @Valid PhotographerInfo photographerInfo, BindingResult bindingResult, long accountId) throws RemoteException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("photographerInfo", photographerInfo);
            return "account/photographerInfo";
        }
        Account account = accountRepository.findById(accountId).orElse(null);
        if(account != null){
            photographerInfo.setAccount(account);
        }
        photographerInfoRepository.save(photographerInfo);
        return "redirect:/login";
    }
    //tao photographerInfo


    //tao studioInfo
    @RequestMapping(method = RequestMethod.GET, value = "/register/studioInfo/{accountId}")
    public String registerStudioInfo(Model model, @PathVariable long accountId){
        StudioInfo studioInfo = new StudioInfo();
        model.addAttribute("accountId", accountId);
        model.addAttribute("studioInfo", studioInfo);
        return "account/studioInfo";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register/studioInfo")
    public String storeStudioInfo(Model model, @Valid StudioInfo studioInfo, BindingResult bindingResult, long accountId) throws RemoteException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("photographerInfo", studioInfo);
            return "account/studioInfo";
        }
        Account account = accountRepository.findById(accountId).orElse(null);
        if(account != null){
            studioInfo.setAccount(account);
        }
        studioInfoRepository.save(studioInfo);
        return "redirect:/login";
    }
    //tao studioInfo
}
