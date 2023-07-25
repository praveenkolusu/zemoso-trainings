package com.zmslabs.minet.controller;

import com.zmslabs.minet.entity.User;
import com.zmslabs.minet.model.UserDTO;
import com.zmslabs.minet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @PostMapping(path = "")
    public ResponseEntity<UserDTO> postUser(@RequestBody UserDTO userDto){
        return new ResponseEntity<>(userService.postUser(userDto), HttpStatus.CREATED);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUserDetails(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUserDetails(id), HttpStatus.OK);
    }
}
