package com.fpt.t1708e.photoplatform.controller.customer;

import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.rmi.RemoteException;

@Controller
@RequestMapping(value = "/customer/album")
public class CustomerAlbumController {
    @Autowired
    AlbumRepository albumRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(Model model, @PathVariable long id) throws RemoteException {
        Album album = albumRepository.findById(id).orElse(null);
        if(album != null){
            model.addAttribute("album", album);
            model.addAttribute("pictures", album.getPictureSet());
            if (album.getStudioInfo() != null){
                model.addAttribute("by", album.getStudioInfo());
            } else {
                model.addAttribute("by", album.getPhotographerInfo());
            }
            return "customer/album/detail";
        }
        return "manager/admin/error/404";
    }
}
