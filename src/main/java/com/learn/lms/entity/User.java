package com.learn.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author anish
 * @project lms
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "LMS_USER")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<BookRecord> bookRecords = new ArrayList<>();

    public User(UserBuilder builder) {
        this.id = builder.id;
        this.userName = builder.userName;
        this.email = builder.email;
        this.fullName = builder.fullName;
        this.age = builder.age;
        this.address = builder.address;
    }

    public static class UserBuilder{


        private long id;

        private String userName;

        private String email;

        private String fullName;

        private int age;

        private String address;

        public UserBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public UserBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public User build(){return new User(this);}
    }
}
