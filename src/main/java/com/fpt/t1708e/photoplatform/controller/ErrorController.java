package com.fpt.t1708e.photoplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.rmi.RemoteException;
@Controller
public class ErrorController {
    @RequestMapping(method = RequestMethod.GET, value = "/error/404")
    public String error1(Model model) throws RemoteException {
        return "manager/admin/error/404";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/error/500")
    public String error2(Model model) throws RemoteException {
        return "manager/admin/error/500";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/error/other")
    public String error3(Model model) throws RemoteException {
        return "manager/admin/error/other";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/error/customer/404")
    public String errorCustomer1(Model model) throws RemoteException {
        return "manager/error/404";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/error/customer/500")
    public String errorCustomer2(Model model) throws RemoteException {
        return "manager/error/500";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/error/customer/other")
    public String errorCustomer3(Model model) throws RemoteException {
        return "manager/error/other";
    }
}
