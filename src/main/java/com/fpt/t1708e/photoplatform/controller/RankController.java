package com.fpt.t1708e.photoplatform.controller;

import com.fpt.t1708e.photoplatform.entity.Rank;
import com.fpt.t1708e.photoplatform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/rank")
public class RankController {
    @Autowired
    RankService rankService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String list(Model model){
        model.addAttribute("ranks", rankService.getList());
        return "rank/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) {
        model.addAttribute("rank", new Rank());
        return "rank/create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String store(Model model, @Valid Rank rank, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("rank", rank);
            return "rank/create";
        }

        rankService.create(rank);
        return "redirect:/rank/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String edit(@PathVariable int id, Model model) {

        Rank rank = rankService.getById(id);
        if (rank == null) {
            return "error/404";
        }
        model.addAttribute("rank", rank);
        return "rank/edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit/{id}")
    public String update(@PathVariable int id, Model model, Rank updateRank) {
        Rank rank = rankService.getById(id);
        if (rank == null) {
            return "error/404";
        }
        rank.setName(updateRank.getName());
        rank.setDescription(updateRank.getDescription());
        rank.setDiscount(updateRank.getDiscount());
        rankService.update(rank);
        return "redirect:/rank/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(Model model, @PathVariable int id) {
        Rank rank = rankService.getById(id);
        if (rank == null) {
            return "/404";
        }
        model.addAttribute("rank", rank);
        return "rank/detail";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{id}")
    public String delete(Model model, @PathVariable int id){
        Rank rank = rankService.getById(id);
        if (rank == null){
            return "/404";
        }
        rank.setStatus(0);
        rankService.update(rank);
        return "rank/list";
    }
}
