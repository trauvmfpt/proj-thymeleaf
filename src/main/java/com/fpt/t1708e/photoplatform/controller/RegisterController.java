package com.fpt.t1708e.photoplatform.controller;

import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.CustomerInfo;
import com.fpt.t1708e.photoplatform.entity.PhotographerInfo;
import com.fpt.t1708e.photoplatform.entity.StudioInfo;
import com.fpt.t1708e.photoplatform.repository.AccountRepository;
import com.fpt.t1708e.photoplatform.repository.CustomerInfoRepository;
import com.fpt.t1708e.photoplatform.repository.PhotographerInfoRepository;
import com.fpt.t1708e.photoplatform.repository.StudioInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServlet;
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

    // test view login account
    @RequestMapping(method = RequestMethod.GET,value = "/account/login")
    public String loginAccount(){
        return "login/login";
    }

    // tao account
    @RequestMapping(method = RequestMethod.GET, value = "/register/account")
    public String registerAccount(Model model){
        model.addAttribute("account", new Account());
        return "register/account";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register/account")
    public String storeAccount(Model model, @Valid Account account, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws RemoteException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("account", account);
            return "register/account";
        }
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        Account createdAccount = accountRepository.save(account);
        if(createdAccount != null) {
            if (account.getRole() == 1) {
                redirectAttributes.addAttribute("accountId", createdAccount.getId());
                return "redirect:/register/customerInfo";
            }
            if (account.getRole() == 2) {
                redirectAttributes.addAttribute("accountId", createdAccount.getId());
                return "redirect:/register/photographerInfo";
            }
            if (account.getRole() == 3) {
                redirectAttributes.addAttribute("accountId", createdAccount.getId());
                return "redirect:/register/studioInfo";
            }
            return "redirect:/account/login";
        }
        return "error";
    }
    // tao account

    // tao customerInfo
    @RequestMapping(method = RequestMethod.GET, value = "/register/customerInfo")
    public String registerCustomerInfo(Model model, @RequestParam("accountId") long accountId){
        CustomerInfo customerInfo = new CustomerInfo();
        model.addAttribute("accountId", accountId);
        model.addAttribute("customerInfo", customerInfo);
        return "register/customerInfo";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register/customerInfo")
    public String storeUserInfo(Model model, @Valid CustomerInfo customerInfo, long accountId) throws RemoteException {
        Account account = accountRepository.findById(accountId).orElse(null);
        if(account != null){
            customerInfo.setAccount(account);
            customerInfoRepository.save(customerInfo);
            return "redirect:/account/login";
        }
        return "error";
    }

    // tao customerInfo


    //tao photographerInfo
    @RequestMapping(method = RequestMethod.GET, value = "/register/photographerInfo")
    public String registerPhotographerInfo(Model model, @RequestParam("accountId") long accountId){
        PhotographerInfo photographerInfo = new PhotographerInfo();
        model.addAttribute("accountId", accountId);
        model.addAttribute("photographerInfo", photographerInfo);
        return "register/photographerInfo";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register/photographerInfo")
    public String storePhotographerInfo(Model model, @Valid PhotographerInfo photographerInfo, BindingResult bindingResult, long accountId) throws RemoteException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("photographerInfo", photographerInfo);
            return "register/photographerInfo";
        }
        Account account = accountRepository.findById(accountId).orElse(null);
        if(account != null){
            photographerInfo.setAccount(account);
            photographerInfoRepository.save(photographerInfo);
            return "redirect:/account/login";
        }
        return "error";
    }
    //tao photographerInfo


    //tao studioInfo
    @RequestMapping(method = RequestMethod.GET, value = "/register/studioInfo")
    public String registerStudioInfo(Model model, @RequestParam("accountId") long accountId){
        StudioInfo studioInfo = new StudioInfo();
        model.addAttribute("accountId", accountId);
        model.addAttribute("studioInfo", studioInfo);
        return "register/studioInfo";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register/studioInfo")
    public String storeStudioInfo(Model model, @Valid StudioInfo studioInfo, BindingResult bindingResult, long accountId) throws RemoteException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("photographerInfo", studioInfo);
            return "register/studioInfo";
        }
        Account account = accountRepository.findById(accountId).orElse(null);
        if(account != null){
            studioInfo.setAccount(account);
            studioInfoRepository.save(studioInfo);
            return "redirect:/account/login";
        }
        return "error";
    }
    //tao studioInfo
}
