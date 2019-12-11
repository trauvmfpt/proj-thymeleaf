package com.fpt.t1708e.photoplatform.controller.customer;

import com.fpt.t1708e.photoplatform.dto.CommentDTO;
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
@RequestMapping(value = "/api/comment")
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

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
    public ResponseEntity<Object> save(@RequestBody CommentDTO commentDTO){
        Comment comment = new Comment();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        Account account = accountService.findByUserName(userName);
        if (account != null) {
            if(account.getRole() == 1){
                try{
                    comment.setCustomerInfo(account.getCustomerInfo());
                    if(commentDTO.getAlbumId() != 0){
                        Album album = albumRepository.findById(commentDTO.getAlbumId()).orElse(null);
                        if(album != null){
                            comment.setAlbum(album);
                        }
                    }
                    if(commentDTO.getProductId() != 0){
                        Product product = productRepository.findById(commentDTO.getProductId()).orElse(null);
                        if(product != null){
                            comment.setProduct(product);
                        }
                    }
                    if(commentDTO.getPhotographerId() != 0){
                        PhotographerInfo photographerInfo = photographerInfoRepository.findById(commentDTO.getPhotographerId()).orElse(null);
                        if(photographerInfo != null){
                            comment.setPhotographerInfo(photographerInfo);
                        }
                    }
                    if(commentDTO.getStudioId() != 0){
                        StudioInfo studioInfo = studioInfoRepository.findById(commentDTO.getStudioId()).orElse(null);
                        if(studioInfo != null){
                            comment.setStudioInfo(studioInfo);
                        }
                    }
                    comment.setContent(commentDTO.getContent());
                    if(commentRepository.save(comment) != null){
                        return new ResponseEntity<>(new RESTResponse.Success()
                                .setStatus(HttpStatus.CREATED.value())
                                .setMessage("Action Success")
                                .build(),
                                HttpStatus.CREATED);
                    }
                }
                catch (Exception ex){
                    return new ResponseEntity<>(new RESTResponse.Success()
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

    @ResponseBody
    @RequestMapping(value = "/getAllByPostId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllByPostId(@PathVariable long id){
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (Comment comment: commentRepository.findByPostIdOrderByCreatedAtAsc(id)
        ) {
            CommentDTO commentDTO = new CommentDTO(comment);
            commentDTOS.add(commentDTO);
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Action success!")
                .addData(commentDTOS)
                .build(),
                HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> delete(@PathVariable long id){
        Comment comment = commentRepository.findById(id).orElse(null);
        if(comment != null){
            commentRepository.delete(comment);
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Action success!")
                .build(),
                HttpStatus.OK);
    }
}
