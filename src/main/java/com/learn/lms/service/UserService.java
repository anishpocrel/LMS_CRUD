package com.learn.lms.service;

import com.learn.lms.dto.UserDTO;
import org.springframework.http.ResponseEntity;

/**
 * @author anish
 * @project lms
 */
public interface UserService {
    ResponseEntity<?> addUser(UserDTO dto);

    ResponseEntity<?> getUserById(Long id);

    ResponseEntity<?> getUser();

    ResponseEntity<?> updateUser(UserDTO dto);

    ResponseEntity<?> deleteuser(Long id);
}
