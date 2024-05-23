package com.learn.lms.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author anish
 * @project lms
 */

@Data
@NoArgsConstructor
public class UserDTO {

    private long id;

    private String userName;

    private String email;

    private String fullName;

    private int age;

    private String address;

    public UserDTO(UserDTOBuilder builder) {
        this.id = builder.id;
        this.userName = builder.userName;
        this.email = builder.email;
        this.fullName = builder.fullName;
        this.age = builder.age;
        this.address = builder.address;
    }

    public static class UserDTOBuilder{

        private long id;

        private String userName;

        private String email;

        private String fullName;

        private int age;

        private String address;

        public UserDTOBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public UserDTOBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserDTOBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserDTOBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public UserDTOBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserDTOBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public UserDTO build(){return new UserDTO(this);}
    }
}
