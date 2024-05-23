package com.learn.lms.controller;

import com.learn.lms.dto.UserDTO;
import com.learn.lms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anish
 * @project lms
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> addUser(@RequestBody UserDTO dto) {
        return userService.addUser(dto);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<?> getUserById(@RequestParam Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getUser() {
        return userService.getUser();
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> updateUser(@RequestBody UserDTO dto) {
        return userService.updateUser(dto);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> deleteUser(@RequestParam Long id) {
        return userService.deleteuser(id);
    }


}
