package com.fpt.t1708e.photoplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
    @RequestMapping(value = "/dashboard")
    public String dashboard() {
//		return "";
        return "manager/dashboard";
    }
}
