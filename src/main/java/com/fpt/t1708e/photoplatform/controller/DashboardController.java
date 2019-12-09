package com.fpt.t1708e.photoplatform.controller;

import com.fpt.t1708e.photoplatform.dto.PopularProduct;
import com.fpt.t1708e.photoplatform.dto.RevenueDTO;
import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.OrderDetail;
import com.fpt.t1708e.photoplatform.entity.OrderProduct;
import com.fpt.t1708e.photoplatform.entity.rest.RESTResponse;
import com.fpt.t1708e.photoplatform.repository.AdminRevenueDetailRepository;
import com.fpt.t1708e.photoplatform.repository.OrderDetailRepository;
import com.fpt.t1708e.photoplatform.repository.ProductRepository;
import com.fpt.t1708e.photoplatform.service.AccountService;
import com.fpt.t1708e.photoplatform.service.OrderDetailService;
import com.fpt.t1708e.photoplatform.service.OrderProductService;
import com.google.gson.Gson;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    ProductRepository productRepository;

    @Autowired
    AdminRevenueDetailRepository adminRevenueDetailRepository;

    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        Account account = accountService.findByUserName(userName);
        if (account != null) {
            double monthlyRevenue = 0;
            if (account.getRole() != 5) {
                monthlyRevenue = orderDetailRepository.getMonthlyRevenue(account.getId(), Calendar.getInstance().get(Calendar.MONTH));
            } else {
                monthlyRevenue = adminRevenueDetailRepository.getMonthlyRevenue(Calendar.getInstance().get(Calendar.MONTH));
            }
            List<OrderDetail> processingOrders = orderDetailRepository.getProcessingOrderDetail(account.getId());
            if (processingOrders != null && processingOrders.size() > 0) {
                List<OrderProduct> listOrders = new ArrayList<>();
                for (OrderDetail orderDetail : processingOrders
                ) {
                    OrderProduct orderProduct = orderProductService.getById(orderDetail.getOrderProduct().getId());
                    listOrders.add(orderProduct);
                }
                model.addAttribute("listOrders", listOrders);
                model.addAttribute("processingOrderDetail", processingOrders.size());
            }
            model.addAttribute("monthlyRevenue", monthlyRevenue);
            return "manager/dashboard";
        }
        return "error";
    }

    @ResponseBody
    @RequestMapping(value = "/revenue", method = RequestMethod.GET)
    public ResponseEntity<Object> getRevenue(@RequestParam(value = "startDate", required = false) String startDateString, @RequestParam(value = "endDate", required = false) String endDateString) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        Account account = accountService.findByUserName(userName);
        if (account != null) {
            List<Object[]> revenue;
            if (startDateString == null || endDateString == null) {
                if (account.getRole() != 5) {
                    revenue = orderDetailRepository.getRevenue(account.getId(), LocalDate.now().minusDays(30), LocalDate.now());
                } else {
                    revenue = adminRevenueDetailRepository.getRevenue(LocalDate.now().minusDays(30), LocalDate.now());
                }
            } else {
                LocalDate startDate = LocalDate.parse(startDateString);
                LocalDate endDate = LocalDate.parse(endDateString);
                if (account.getRole() != 5) {
                    revenue = orderDetailRepository.getRevenue(account.getId(), startDate, endDate);
                } else {
                    revenue = adminRevenueDetailRepository.getRevenue(startDate, endDate);
                }
            }
            if (revenue != null) {
                List<RevenueDTO> revenueDTOS = new ArrayList<>();
                for (Object[] r : revenue
                ) {
                    RevenueDTO revenueDTO = new RevenueDTO();
                    revenueDTO.setRevenue((double) r[0]);
                    revenueDTO.setDay((LocalDate) r[1]);
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

    @ResponseBody
    @RequestMapping(value = "/popularProduct", method = RequestMethod.GET)
    public ResponseEntity<Object> getPopularProduct(@RequestParam(value = "startDate", required = false) String startDateString, @RequestParam(value = "endDate", required = false) String endDateString) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        Account account = accountService.findByUserName(userName);
        if (account != null) {
            if (account.getRole() != 5) {
                List<Object[]> popularProduct;
                if (startDateString == null || endDateString == null) {
                    popularProduct = orderDetailRepository.getPopularProduct(account.getId(), LocalDate.now().minusYears(10), LocalDate.now());
                } else {
                    LocalDate startDate = LocalDate.parse(startDateString);
                    LocalDate endDate = LocalDate.parse(endDateString);
                    popularProduct = orderDetailRepository.getPopularProduct(account.getId(), startDate, endDate);
                }
                if (popularProduct != null) {
                    List<PopularProduct> popularProducts = new ArrayList<>();
                    for (Object[] p : popularProduct
                    ) {
                        PopularProduct popularProduct1 = new PopularProduct();
                        popularProduct1.setQuantity((double) p[0]);
                        popularProduct1.setName((String) p[1]);
                        popularProducts.add(popularProduct1);
                    }
                    return new ResponseEntity<>(new RESTResponse.Success()
                            .setStatus(HttpStatus.OK.value())
                            .setMessage("Action success!")
                            .addData(popularProducts)
                            .build(),
                            HttpStatus.OK);
                }
            }
            else{
                List<Object[]> popularStudio;
                List<Object[]> popularPhotographer;
                if (startDateString == null || endDateString == null) {
                    popularStudio = adminRevenueDetailRepository.getPopularStudio(LocalDate.now().minusYears(10), LocalDate.now(), PageRequest.of(0, 5));
                    popularPhotographer = adminRevenueDetailRepository.getPopularPhotographer(LocalDate.now().minusYears(10), LocalDate.now(), PageRequest.of(0, 5));
                }
                else {
                    LocalDate startDate = LocalDate.parse(startDateString);
                    LocalDate endDate = LocalDate.parse(endDateString);
                    popularStudio = adminRevenueDetailRepository.getPopularStudio(startDate, endDate, PageRequest.of(0, 5));
                    popularPhotographer = adminRevenueDetailRepository.getPopularPhotographer(startDate, endDate, PageRequest.of(0, 5));
                }
                if (popularStudio != null || popularPhotographer != null) {
                    List<PopularProduct> popularPartner = new ArrayList<>();
                    for (Object[] p : popularStudio
                    ) {
                        PopularProduct popularProduct1 = new PopularProduct();
                        popularProduct1.setQuantity((double) p[0]);
                        popularProduct1.setName((String) p[1]);
                        popularPartner.add(popularProduct1);
                    }

                    for (Object[] p : popularPhotographer
                    ) {
                        PopularProduct popularProduct1 = new PopularProduct();
                        popularProduct1.setQuantity((double) p[0]);
                        popularProduct1.setName((String) p[1]);
                        popularPartner.add(popularProduct1);
                    }

                    return new ResponseEntity<>(new RESTResponse.Success()
                            .setStatus(HttpStatus.OK.value())
                            .setMessage("Action success!")
                            .addData(popularPartner)
                            .build(),
                            HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setMessage("Error")
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
