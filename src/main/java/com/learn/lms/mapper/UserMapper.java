package com.learn.lms.mapper;

import com.learn.lms.dto.UserDTO;
import com.learn.lms.entity.User;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author anish
 * @project lms
 */
public class UserMapper {

    public static User toEntity(UserDTO dto){
        return new User.UserBuilder()
                .setAddress(dto.getAddress())
                .setAge(dto.getAge())
                .setEmail(dto.getEmail())
                .setFullName(dto.getFullName())
                .setUserName(dto.getUserName())
                .build();
    }

    public static UserDTO toDTO(User entity){
        return new UserDTO.UserDTOBuilder()
                .setAddress(entity.getAddress())
                .setAge(entity.getAge())
                .setEmail(entity.getEmail())
                .setFullName(entity.getFullName())
                .setUserName(entity.getUserName())
                .build();
    }

    public static List<User> toEntityList(List<UserDTO> dtos){
        return dtos.stream()
                .map(UserMapper::toEntity)
                .collect(Collectors.toList());
    }

    public static List<UserDTO> toDTOList(List<User> entities){
        return entities.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }
}
