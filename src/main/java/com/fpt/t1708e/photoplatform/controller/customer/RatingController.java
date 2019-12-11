package com.fpt.t1708e.photoplatform.controller.customer;

import com.fpt.t1708e.photoplatform.dto.RatingDTO;
import com.fpt.t1708e.photoplatform.entity.*;
import com.fpt.t1708e.photoplatform.entity.rest.RESTResponse;
import com.fpt.t1708e.photoplatform.repository.*;
import com.fpt.t1708e.photoplatform.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/rating")
public class RatingController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerInfoRepository customerInfoRepository;

    @Autowired
    PhotographerInfoRepository photographerInfoRepository;

    @Autowired
    StudioInfoRepository studioInfoRepository;

    @Autowired
    AccountService accountService;

    @PostMapping(value = "/save")
    public ResponseEntity<Object> save(@RequestBody RatingDTO ratingDTO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        Account account = accountService.findByUserName(userName);
        if (account != null) {
            if (account.getRole() == 1) {
                long postId = 0;
                boolean isAlbum = false;
                boolean isProduct = false;
                boolean isStudio = false;
                boolean isPhotographer = false;

                try {
                    if (ratingDTO.getAlbumId() != 0) {
                        postId = ratingDTO.getAlbumId();
                        isAlbum = true;
                    }
                    if (ratingDTO.getProductId() != 0) {
                        postId = ratingDTO.getProductId();
                        isProduct = true;
                    }
                    if (ratingDTO.getPhotographerId() != 0) {
                        postId = ratingDTO.getPhotographerId();
                        isPhotographer = true;
                    }
                    if (ratingDTO.getStudioId() != 0) {
                        postId = ratingDTO.getStudioId();
                        isStudio = true;
                    }

                    if (isAlbum) {
                        Album album = albumRepository.findById(postId).orElse(null);
                        if (album != null) {
                            album.setAverageRate(album.getAverageRate() + ratingDTO.getValue());
                            album.setNumberOfRate(album.getNumberOfRate() + 1);
                            albumRepository.save(album);
                        }
                    }
                    if (isProduct) {
                        Product product = productRepository.findById(postId).orElse(null);
                        if (product != null) {
                            product.setAverageRate(product.getAverageRate() + ratingDTO.getValue());
                            product.setNumberOfRate(product.getNumberOfRate() + 1);
                            productRepository.save(product);
                        }
                    }
                    if (isPhotographer) {
                        PhotographerInfo photographerInfo = photographerInfoRepository.findById(postId).orElse(null);
                        if (photographerInfo != null) {
                            photographerInfo.setAverageRate(photographerInfo.getAverageRate() + ratingDTO.getValue());
                            photographerInfo.setNumberOfRate(photographerInfo.getNumberOfRate() + 1);
                            photographerInfoRepository.save(photographerInfo);
                        }
                    }
                    if (isStudio) {
                        StudioInfo studioInfo = studioInfoRepository.findById(postId).orElse(null);
                        if (studioInfo != null) {
                            studioInfo.setAverageRate(studioInfo.getAverageRate() + ratingDTO.getValue());
                            studioInfo.setNumberOfRate(studioInfo.getNumberOfRate() + 1);
                            studioInfoRepository.save(studioInfo);
                        }
                    }
                    return new ResponseEntity<>(new RESTResponse.Success()
                            .setStatus(HttpStatus.CREATED.value())
                            .setMessage("Action Success")
                            .build(),
                            HttpStatus.CREATED);
                } catch (Exception ex) {
                    return new ResponseEntity<>(new RESTResponse.Error()
                            .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .setMessage("Error")
                            .build(),
                            HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }
        return new ResponseEntity<>(new RESTResponse.Error()
                .setStatus(HttpStatus.UNAUTHORIZED.value())
                .setMessage("UNAUTHORIZED")
                .build(),
                HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(value = "/getRatingByPostId")
    public ResponseEntity<Object> getRatingByPostId(@RequestParam(value = "postId") long postId, @RequestParam(value = "postType") String postType) {
        if (postId > 0) {
            double rating = 0;
            if (postType.equals("album")) {
                Album album = albumRepository.findById(postId).orElse(null);
                rating = Math.round((album.getAverageRate() / album.getNumberOfRate()) * 100) / 100;
            }
            if (postType.equals("product")) {
                Product product = productRepository.findById(postId).orElse(null);
                rating = Math.round(product.getAverageRate() / product.getNumberOfRate());
            }
            if (postType.equals("photographer")) {
                PhotographerInfo photographerInfo = photographerInfoRepository.findById(postId).orElse(null);
                rating = Math.round(photographerInfo.getAverageRate() / photographerInfo.getNumberOfRate());
            }
            if (postType.equals("studio")) {
                StudioInfo studioInfo = studioInfoRepository.findById(postId).orElse(null);
                rating =(double) Math.round((studioInfo.getAverageRate() / studioInfo.getNumberOfRate()) * 100) / 100;
            }
            if (rating > 0) {
                return new ResponseEntity<>(new RESTResponse.Success()
                        .setStatus(HttpStatus.OK.value())
                        .setMessage("Action success!")
                        .addData(rating)
                        .build(),
                        HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new RESTResponse.Error()
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setMessage("Error")
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
