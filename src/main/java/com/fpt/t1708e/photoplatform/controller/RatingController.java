package com.fpt.t1708e.photoplatform.controller;

import com.fpt.t1708e.photoplatform.dto.RatingDTO;
import com.fpt.t1708e.photoplatform.entity.*;
import com.fpt.t1708e.photoplatform.entity.rest.RESTResponse;
import com.fpt.t1708e.photoplatform.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/rating")
public class RatingController {
    RatingRepository ratingRepository;

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

    @PostMapping(value = "/save")
    public ResponseEntity<Object> save(@RequestBody RatingDTO ratingDTO){
        long accountId = 0;
        long postId = 0;
        boolean isAlbum = false;
        boolean isProduct = false;
        boolean isStudio = false;
        boolean isPhotographer = false;

        if(ratingDTO.getAccountId() != 0){
            accountId = ratingDTO.getAccountId();
        }
        if(ratingDTO.getAlbumId() != 0){
            postId = ratingDTO.getAlbumId();
            isAlbum = true;
        }
        if(ratingDTO.getProductId() != 0){
            postId = ratingDTO.getProductId();
            isProduct = true;
        }
        if(ratingDTO.getPhotographerId() != 0){
            postId = ratingDTO.getPhotographerId();
            isPhotographer = true;
        }
        if(ratingDTO.getStudioId() != 0){
            postId = ratingDTO.getStudioId();
            isStudio = true;
        }

        Rating existedRating = ratingRepository.findByUserIdAndPostId(accountId, postId);
        if(existedRating != null){
            existedRating.setValue(existedRating.getValue() + ratingDTO.getValue());
            if(ratingRepository.save(existedRating) != null){
                return new ResponseEntity<>(new RESTResponse.Success()
                        .setStatus(HttpStatus.CREATED.value())
                        .setMessage("Action Success")
                        .build(),
                        HttpStatus.CREATED);
            }
        }
        else{
            Rating rating = new Rating();
            if(accountId != 0){
                CustomerInfo customerInfo = customerInfoRepository.findById(ratingDTO.getAccountId()).orElse(null);
                if(customerInfo != null){
                    rating.setCustomerInfo(customerInfo);
                }
            }
            if(isAlbum){
                Album album = albumRepository.findById(postId).orElse(null);
                if(album != null){
                    rating.setAlbum(album);
                }
            }
            if(isProduct){
                Product product = productRepository.findById(postId).orElse(null);
                if(product != null){
                    rating.setProduct(product);
                }
            }
            if(isPhotographer){
                PhotographerInfo photographerInfo = photographerInfoRepository.findById(postId).orElse(null);
                if(photographerInfo != null){
                    rating.setPhotographerInfo(photographerInfo);
                }
            }
            if(isStudio){
                StudioInfo studioInfo = studioInfoRepository.findById(postId).orElse(null);
                if(studioInfo != null){
                    rating.setStudioInfo(studioInfo);
                }
            }
            rating.setValue(ratingDTO.getValue());
            if(ratingRepository.save(rating) != null){
                return new ResponseEntity<>(new RESTResponse.Success()
                        .setStatus(HttpStatus.CREATED.value())
                        .setMessage("Action Success")
                        .build(),
                        HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(new RESTResponse.Error()
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setMessage("Error")
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/getAllByPostId/{id}")
    public ResponseEntity<Object> getAllByPostId(@PathVariable long id){
        List<RatingDTO> ratingDTOS = new ArrayList<>();
        for (Rating rating: ratingRepository.findByPostId(id)
        ) {
            RatingDTO ratingDTO = new RatingDTO(rating);
            ratingDTOS.add(ratingDTO);
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Action success!")
                .addData(ratingDTOS)
                .build(),
                HttpStatus.OK);
    }
}
