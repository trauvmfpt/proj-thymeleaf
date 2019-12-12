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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    RatingRepository ratingRepository;

    @PostMapping(value = "/save")
    public ResponseEntity<Object> save(@RequestBody RatingDTO ratingDTO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        Account account = accountService.findByUserName(userName);
        if (account != null) {
            if (account.getRole() == 1) {
                CustomerInfo customerInfo = customerInfoRepository.findByAccount_Id(account.getId());
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
                            Rating rating;
                            rating = ratingRepository.findByUserIdAndPostId(customerInfo.getId(), postId);
                            if(rating != null){
                                album.setAverageRate(album.getAverageRate() - rating.getValue() + ratingDTO.getValue());
                                rating.setValue(ratingDTO.getValue());
                                rating.setUpdatedAt(LocalDate.now());
                            }
                            else {
                                rating = new Rating();
                                rating.setAlbum(album);
                                rating.setCustomerInfo(customerInfo);
                                rating.setCreatedAt(LocalDate.now());
                                rating.setUpdatedAt(LocalDate.now());
                                rating.setValue(ratingDTO.getValue());
                                album.setAverageRate(album.getAverageRate() + ratingDTO.getValue());
                                album.setNumberOfRate(album.getNumberOfRate() + 1);
                            }
                            albumRepository.save(album);
                            ratingRepository.save(rating);
                        }
                    }
                    if (isProduct) {
                        Product product = productRepository.findById(postId).orElse(null);
                        if (product != null) {
                            Rating rating;
                            rating = ratingRepository.findByUserIdAndPostId(customerInfo.getId(), postId);
                            if(rating != null){
                                product.setAverageRate(product.getAverageRate() - rating.getValue() + ratingDTO.getValue());
                                rating.setValue(ratingDTO.getValue());
                                rating.setUpdatedAt(LocalDate.now());
                            }
                            else {
                                rating = new Rating();
                                rating.setProduct(product);
                                rating.setCustomerInfo(customerInfo);
                                rating.setCreatedAt(LocalDate.now());
                                rating.setUpdatedAt(LocalDate.now());
                                rating.setValue(ratingDTO.getValue());
                                product.setAverageRate(product.getAverageRate() + ratingDTO.getValue());
                                product.setNumberOfRate(product.getNumberOfRate() + 1);
                            }
                            productRepository.save(product);
                            ratingRepository.save(rating);
                        }
                    }
                    if (isPhotographer) {
                        PhotographerInfo photographerInfo = photographerInfoRepository.findById(postId).orElse(null);
                        if (photographerInfo != null) {
                            Rating rating;
                            rating = ratingRepository.findByUserIdAndPostId(customerInfo.getId(), postId);
                            if(rating != null){
                                photographerInfo.setAverageRate(photographerInfo.getAverageRate() - rating.getValue() + ratingDTO.getValue());
                                rating.setValue(ratingDTO.getValue());
                                rating.setUpdatedAt(LocalDate.now());
                            }
                            else {
                                rating = new Rating();
                                rating.setPhotographerInfo(photographerInfo);
                                rating.setCustomerInfo(customerInfo);
                                rating.setCreatedAt(LocalDate.now());
                                rating.setUpdatedAt(LocalDate.now());
                                rating.setValue(ratingDTO.getValue());
                                photographerInfo.setAverageRate(photographerInfo.getAverageRate() + ratingDTO.getValue());
                                photographerInfo.setNumberOfRate(photographerInfo.getNumberOfRate() + 1);
                            }
                            photographerInfoRepository.save(photographerInfo);
                            ratingRepository.save(rating);
                        }
                    }
                    if (isStudio) {
                        StudioInfo studioInfo = studioInfoRepository.findById(postId).orElse(null);
                        if (studioInfo != null) {
                            Rating rating;
                            rating = ratingRepository.findByUserIdAndPostId(customerInfo.getId(), postId);
                            if(rating != null){
                                studioInfo.setAverageRate(studioInfo.getAverageRate() - rating.getValue() + ratingDTO.getValue());
                                rating.setValue(ratingDTO.getValue());
                                rating.setUpdatedAt(LocalDate.now());
                            }
                            else {
                                rating = new Rating();
                                rating.setStudioInfo(studioInfo);
                                rating.setCustomerInfo(customerInfo);
                                rating.setCreatedAt(LocalDate.now());
                                rating.setUpdatedAt(LocalDate.now());
                                rating.setValue(ratingDTO.getValue());
                                studioInfo.setAverageRate(studioInfo.getAverageRate() + ratingDTO.getValue());
                                studioInfo.setNumberOfRate(studioInfo.getNumberOfRate() + 1);
                            }
                            studioInfoRepository.save(studioInfo);
                            ratingRepository.save(rating);
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
    public ResponseEntity<Map<String, Object>> getRatingByPostId(@RequestParam(value = "postId") long postId, @RequestParam(value = "postType") String postType) {
        if (postId > 0) {
            double rating = 0;
            if (postType.equals("album")) {
                Album album = albumRepository.findById(postId).orElse(null);
                rating =(double) Math.round((album.getAverageRate() / album.getNumberOfRate()) * 100) / 100;
            }
            if (postType.equals("product")) {
                Product product = productRepository.findById(postId).orElse(null);
                rating =(double) Math.round((product.getAverageRate() / product.getNumberOfRate()) * 100) / 100;
            }
            if (postType.equals("photographer")) {
                PhotographerInfo photographerInfo = photographerInfoRepository.findById(postId).orElse(null);
                rating =(double) Math.round((photographerInfo.getAverageRate() / photographerInfo.getNumberOfRate()) * 100) / 100;
            }
            if (postType.equals("studio")) {
                StudioInfo studioInfo = studioInfoRepository.findById(postId).orElse(null);
                rating =(double) Math.round((studioInfo.getAverageRate() / studioInfo.getNumberOfRate()) * 100) / 100;
            }
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String userName = auth.getName();
            Account account = accountService.findByUserName(userName);
            Rating rating1 = null;
            if(account != null){
                CustomerInfo customerInfo = customerInfoRepository.findByAccount_Id(account.getId());
                if(customerInfo != null){
                    rating1 = ratingRepository.findByUserIdAndPostId(customerInfo.getId(), postId);
                }
            }
            if (rating > 0) {
                Map<String, Object> result = new HashMap<String,Object>();
                if(rating1 != null){
                    double userRating = rating1.getValue();
                    result.put("userRating", userRating);
                }
                result.put("rating",rating);
                return ResponseEntity.ok(result);
            }
        }
        return new ResponseEntity<>(new RESTResponse.Error()
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setMessage("Error")
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/unvote")
    public ResponseEntity<Map<String, Object>> unvote(@RequestParam(value = "postId") long postId, @RequestParam(value = "postType") String postType) {
        if (postId > 0) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String userName = auth.getName();
            Account account = accountService.findByUserName(userName);
            if(account != null){
                CustomerInfo customerInfo = customerInfoRepository.findByAccount_Id(account.getId());
                if(customerInfo != null){
                    Rating rating = ratingRepository.findByUserIdAndPostId(customerInfo.getId(), postId);
                    if(rating != null){
                        if (postType.equals("album")) {
                            Album album = albumRepository.findById(postId).orElse(null);
                            album.setAverageRate(album.getAverageRate() - rating.getValue());
                            album.setNumberOfRate(album.getNumberOfRate() - 1);
                            albumRepository.save(album);
                        }
                        if (postType.equals("product")) {
                            Product product = productRepository.findById(postId).orElse(null);
                            product.setAverageRate(product.getAverageRate() - rating.getValue());
                            product.setNumberOfRate(product.getNumberOfRate() - 1);
                            productRepository.save(product);
                        }
                        if (postType.equals("photographer")) {
                            PhotographerInfo photographerInfo = photographerInfoRepository.findById(postId).orElse(null);
                            photographerInfo.setAverageRate(photographerInfo.getAverageRate() - rating.getValue());
                            photographerInfo.setNumberOfRate(photographerInfo.getNumberOfRate() - 1);
                            photographerInfoRepository.save(photographerInfo);
                        }
                        if (postType.equals("studio")) {
                            StudioInfo studioInfo = studioInfoRepository.findById(postId).orElse(null);
                            studioInfo.setAverageRate(studioInfo.getAverageRate() - rating.getValue());
                            studioInfo.setNumberOfRate(studioInfo.getNumberOfRate() - 1);
                            studioInfoRepository.save(studioInfo);
                        }
                        ratingRepository.delete(rating);
                        return new ResponseEntity<>(new RESTResponse.Success()
                                .setStatus(HttpStatus.OK.value())
                                .setMessage("Action Success")
                                .build(),
                                HttpStatus.OK);
                    }
                }
            }
        }
        return new ResponseEntity<>(new RESTResponse.Error()
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setMessage("Error")
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
