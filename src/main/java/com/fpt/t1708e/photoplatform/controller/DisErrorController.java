package com.fpt.t1708e.photoplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DisErrorController{
    @RequestMapping(method = RequestMethod.GET, value = "/error/admin/404")
    public String error1(){
        return "owner/admin/error/404";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/error/admin/500")
    public String error2() {
        return "owner/admin/error/500";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/error/admin/other")
    public String error3(){
        return "owner/admin/error/other";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/error/404")
    public String errorCustomer1(){
        return "error/404";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/error/500")
    public String errorCustomer2(){
        return "error/500";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/error/other")
    public String errorCustomer3(){
        return "error/other";
    }

}
