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
import org.springframework.security.core.parameters.P;
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
import javax.servlet.http.HttpSession;
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

    @RequestMapping(method = RequestMethod.GET,value = "/account/login")
    public String loginAccount(HttpServletRequest request, HttpSession session){
        if(session.getAttribute("previousUrl") != null){
            session.removeAttribute("previousUrl");
        }
        session.setAttribute("previousUrl", request.getHeader("Referer"));
        return "login/login";
    }

    // tao account
    @RequestMapping(method = RequestMethod.GET, value = "/register/partner/account")
    public String registerAccount(Model model){
        model.addAttribute("account", new Account());
        return "register/account";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register/partner/account")
    public String storeAccount(Model model, @Valid Account account, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws RemoteException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("account", account);
            return "register/account";
        }
        Account existedAccount = accountRepository.findAccountByUsername(account.getUsername());
        if(existedAccount != null){
            return "error/404";
        }
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        Account createdAccount = accountRepository.save(account);
        if(createdAccount != null) {
            if (account.getRole() == 2) {
                redirectAttributes.addAttribute("accountId", createdAccount.getId());
                return "redirect:/register/partner/photographerInfo";
            }
            if (account.getRole() == 3) {
                redirectAttributes.addAttribute("accountId", createdAccount.getId());
                return "redirect:/register/partner/studioInfo";
            }
            return "redirect:/account/login";
        }
        return "error/404";
    }
    // tao account

    // tao customerInfo
    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public String registerCustomerInfo(Model model){
        CustomerInfo customerInfo = new CustomerInfo();
        model.addAttribute("customerInfo", customerInfo);
        return "register/customerInfo";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String storeUserInfo(Model model, @Valid CustomerInfo customerInfo, String username, String password) throws RemoteException {
        if(username != null && password != null){
            Account existedAccount = accountRepository.findAccountByUsername(username);
            if(existedAccount != null){
                return "error/other";
            }
            Account account = new Account();
            account.setUsername(username);
            account.setPassword(passwordEncoder.encode(password));
            account.setRole(1);
            Account createdAccount = accountRepository.save(account);
            if(createdAccount != null){
                customerInfo.setAccount(createdAccount);
                customerInfoRepository.save(customerInfo);
                return "redirect:/account/login";
            }
        }
        return "error/other";
    }

    // tao customerInfo


    //tao photographerInfo
    @RequestMapping(method = RequestMethod.GET, value = "/register/partner/photographerInfo")
    public String registerPhotographerInfo(Model model, @RequestParam("accountId") long accountId){
        PhotographerInfo photographerInfo = new PhotographerInfo();
        model.addAttribute("accountId", accountId);
        model.addAttribute("photographerInfo", photographerInfo);
        return "register/photographerInfo";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register/partner/photographerInfo")
    public String storePhotographerInfo(Model model, @Valid PhotographerInfo photographerInfo, BindingResult bindingResult, long accountId) throws RemoteException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("photographerInfo", photographerInfo);
            return "register/photographerInfo";
        }
        Account account = accountRepository.findById(accountId).orElse(null);
        if(account != null){
            PhotographerInfo existedInfo = photographerInfoRepository.findByAccount_Id(account.getId());
            if(existedInfo != null){
                return "error/other";
            }
            photographerInfo.setAccount(account);
            photographerInfoRepository.save(photographerInfo);
            return "redirect:/account/login";
        }
        return "error/other";
    }
    //tao photographerInfo


    //tao studioInfo
    @RequestMapping(method = RequestMethod.GET, value = "/register/partner/studioInfo")
    public String registerStudioInfo(Model model, @RequestParam("accountId") long accountId){
        StudioInfo studioInfo = new StudioInfo();
        model.addAttribute("accountId", accountId);
        model.addAttribute("studioInfo", studioInfo);
        return "register/studioInfo";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register/partner/studioInfo")
    public String storeStudioInfo(Model model, @Valid StudioInfo studioInfo, BindingResult bindingResult, long accountId) throws RemoteException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("photographerInfo", studioInfo);
            return "register/studioInfo";
        }
        Account account = accountRepository.findById(accountId).orElse(null);
        if(account != null){
            StudioInfo existedInfo = studioInfoRepository.findByAccount_Id(account.getId());
            if(existedInfo != null){
                return "error/other";
            }
            studioInfo.setAccount(account);
            studioInfoRepository.save(studioInfo);
            return "redirect:/account/login";
        }
        return "error/other";
    }
    //tao studioInfo
}
