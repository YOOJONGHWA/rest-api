package com.example.restapi.controllor;

import com.example.restapi.model.BookRequest;
import com.example.restapi.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public BookRequest post(
            @RequestBody BookRequest bookRequest
    ) {
        System.out.println(bookRequest);
        return bookRequest;
    }
    @PostMapping("/post2")
    public UserRequest post2(
            @RequestBody UserRequest userInfo
    ) {
        return userInfo;
    }
}
