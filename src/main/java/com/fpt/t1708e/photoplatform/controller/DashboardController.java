package com.fpt.t1708e.photoplatform.controller;

import com.fpt.t1708e.photoplatform.dto.RevenueDTO;
import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.OrderDetail;
import com.fpt.t1708e.photoplatform.entity.rest.RESTResponse;
import com.fpt.t1708e.photoplatform.repository.OrderDetailRepository;
import com.fpt.t1708e.photoplatform.service.AccountService;
import com.fpt.t1708e.photoplatform.service.OrderDetailService;
import com.fpt.t1708e.photoplatform.service.OrderProductService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/manager")
public class DashboardController {
    @Autowired
    OrderProductService orderProductService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public String dashboard() {
//		return "";
        return "manager/dashboard";
    }

    @ResponseBody
    @RequestMapping(value = "/revenue", method = RequestMethod.GET)
    public ResponseEntity<Object> getRevenue(@RequestParam(value = "startDate", required = false) String startDateString, @RequestParam(value = "endDate", required = false) String endDateString) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        Account account = accountService.findByUserName(userName);
        if (account != null) {
            List<Object[]> revenue;
            if(startDateString == null || endDateString == null){
                revenue = orderDetailRepository.getRevenue(account.getId(), LocalDate.now(), LocalDate.now());
            }
            else {
                LocalDate startDate = LocalDate.parse(startDateString);
                LocalDate endDate = LocalDate.parse(endDateString);
                revenue = orderDetailRepository.getRevenue(account.getId(), startDate, endDate);
            }
            if (revenue != null) {
                List<RevenueDTO> revenueDTOS = new ArrayList<>();
                for (Object [] r: revenue
                     ) {
                    RevenueDTO revenueDTO  = new RevenueDTO();
                    revenueDTO.setRevenue((double)r[0]);
                    revenueDTO.setDay((LocalDate)r[1]);
                    revenueDTOS.add(revenueDTO);
                }
                return new ResponseEntity<>(new RESTResponse.Success()
                        .setStatus(HttpStatus.OK.value())
                        .setMessage("Action success!")
                        .addData(revenueDTOS)
                        .build(),
                        HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setMessage("Error")
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
