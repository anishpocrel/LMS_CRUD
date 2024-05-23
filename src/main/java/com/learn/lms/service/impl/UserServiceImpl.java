package com.learn.lms.service.impl;

import com.learn.lms.dto.UserDTO;
import com.learn.lms.entity.User;
import com.learn.lms.mapper.UserMapper;
import com.learn.lms.repository.UserRepository;
import com.learn.lms.service.UserService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author anish
 * @project lms
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> addUser(UserDTO dto) {
        try {
            User user = userRepository.save(UserMapper.toEntity(dto));
            return ResponseEntity.ok(user.getId());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save user !! class : UserServiceImpl || method : addUser()");
        }
    }

    @Override
    public ResponseEntity<?> getUser() {
        try {
            return ResponseEntity.ok(userRepository.findAll());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve user !! class : UserServiceImpl || method : getUser()");
        }
    }

    @Override
    public ResponseEntity<?> getUserById(Long id) {
        try {
            Optional<User> user = userRepository.findById(id);
            if (user.isPresent()) {
                return ResponseEntity.ok(user.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id :" + id + " || class : UserServiceImpl || method getUserById().");
            }
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve user !! class : UserServiceImpl || method : getUserById()");
        }
    }

    @Override
    public ResponseEntity<?> updateUser(UserDTO dto) {
        try {
            if (userRepository.existsById(dto.getId())) {
                User user = userRepository.findById(dto.getId()).get();
                user.setUserName(dto.getUserName());
                user.setAddress(dto.getAddress());
                user.setAge(dto.getAge());
                user.setEmail(dto.getEmail());
                user.setFullName(dto.getFullName());
                userRepository.save(user);
                return ResponseEntity.ok("User with id : " + dto.getId() + " Updated Successfully !!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id :" + dto.getId() + " || class : UserServiceImpl || method getUserById().");
            }
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete user !! class : UserServiceImpl || method : deleteuser()");
        }
    }

    @Override
    public ResponseEntity<?> deleteuser(Long id) {
        try {
            if (!userRepository.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id :" + id + " || class : UserServiceImpl || method deleteuser().");
            }
            userRepository.deleteById(id);
            return ResponseEntity.ok("User with id : " + id + " Deleted Successfully !!");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete user !! class : UserServiceImpl || method : deleteuser()");
        }
    }
}
