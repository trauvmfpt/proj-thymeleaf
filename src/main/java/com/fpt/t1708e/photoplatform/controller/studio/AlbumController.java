package com.fpt.t1708e.photoplatform.controller.studio;

import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.PhotographerInfo;
import com.fpt.t1708e.photoplatform.entity.Picture;
import com.fpt.t1708e.photoplatform.entity.StudioInfo;
import com.fpt.t1708e.photoplatform.repository.AlbumRepository;
import com.fpt.t1708e.photoplatform.repository.PhotographerInfoRepository;
import com.fpt.t1708e.photoplatform.repository.StudioInfoRepository;
import com.fpt.t1708e.photoplatform.util.ImageUltil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.*;

@Controller
@RequestMapping(value = "/album")
public class AlbumController {

    @Autowired
    StudioInfoRepository studioInfoRepository;

    @Autowired
    PhotographerInfoRepository photographerInfoRepository;

    @Autowired
    AlbumRepository albumRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) throws RemoteException {
        List<StudioInfo> studioInfos = studioInfoRepository.findAll();
        List<PhotographerInfo> photographerInfos = photographerInfoRepository.findAll();
        model.addAttribute("studios", studioInfos);
        model.addAttribute("photographers", photographerInfos);
        model.addAttribute("album", new Album());
        return "manager/studio/album/create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String store(Model model, @Valid Album album, BindingResult bindingResult, HttpServletRequest req, @RequestParam("imgUrls") String[] imgUrls) throws IOException, ServletException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("album", album);
            return "manager/studio/album/create";
        }
        Set<Picture> imageList = new HashSet<>();

        if (imgUrls != null){
            for (String imgUrl: imgUrls) {
                Picture picture = new Picture();
                picture.setUrl(imgUrl);
                picture.setStatus(1);
                picture.setAlbum(album);
                imageList.add(picture);
            }
            album.setPictureSet(imageList);
        }
        albumRepository.save(album);
        return "redirect:/album/create";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String list(Model model) throws RemoteException {
        List<Album> albums = albumRepository.findAllByStatus(1);
        model.addAttribute("albums", albums);
        return "manager/studio/album/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String edit(Model model, @PathVariable long id) throws RemoteException {
        List<StudioInfo> studioInfos = studioInfoRepository.findAll();
        List<PhotographerInfo> photographerInfos = photographerInfoRepository.findAll();
        model.addAttribute("studios", studioInfos);
        model.addAttribute("photographers", photographerInfos);
        Album album = albumRepository.findById(id).orElse(null);
        if(album != null){
            model.addAttribute("album", album);
            return "manager/studio/album/edit";
        }
        return "manager/studio/album/list";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public String update(Model model, @Valid Album album, BindingResult bindingResult) throws RemoteException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("album", album);
            return "manager/studio/album/edit";
        }
        albumRepository.save(album);
        return "redirect:/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
    public String update(Model model, @PathVariable long id) throws RemoteException {
        Album album = albumRepository.findById(id).orElse(null);
        if(album != null){
            album.setStatus(0);
            albumRepository.save(album);
        }
        return "redirect:album/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(Model model, @PathVariable long id) throws RemoteException {
        Album album = albumRepository.findById(id).orElse(null);
        if(album != null){
            model.addAttribute("album", album);
            model.addAttribute("pictures", album.getPictureSet());
            return "manager/studio/album/detail";
        }
        return "redirect:album/list";
    }
}
