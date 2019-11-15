package com.fpt.t1708e.photoplatform.controller;

import com.fpt.t1708e.photoplatform.entity.Level;
import com.fpt.t1708e.photoplatform.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/level")
public class LevelController {
    @Autowired
    LevelService levelService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String list(Model model){
        model.addAttribute("levels", levelService.getList());
        return "level/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) {
        model.addAttribute("level", new Level());
        return "level/create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String store(Model model, @Valid Level level, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("level", level);
            return "level/create";
        }

        levelService.create(level);
        return "redirect:/level/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String edit(@PathVariable int id, Model model) {

        Level level = levelService.getById(id);
        if (level == null) {
            return "error/404";
        }
        model.addAttribute("level", level);
        return "level/edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit/{id}")
    public String update(@PathVariable int id, Model model, Level updateLevel) {
        Level level = levelService.getById(id);
        if (level == null) {
            return "error/404";
        }
        level.setName(updateLevel.getName());
        level.setDescription(updateLevel.getDescription());
        level.setPrice(updateLevel.getPrice());
        level.setDurationInDay((updateLevel.getDurationInDay()));
        level.setStatus(updateLevel.getStatus());
        levelService.update(level);
        return "redirect:/level/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(Model model, @PathVariable int id) {
        Level level = levelService.getById(id);
        if (level == null) {
            return "/404";
        }
        model.addAttribute("level", level);
        return "level/detail";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{id}")
    public String delete(Model model, @PathVariable int id){
        Level level = levelService.getById(id);
        if (level == null){
            return "/404";
        }
        level.setStatus(0);
        levelService.update(level);
        return "level/list";
    }
}
