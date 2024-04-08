package com.patika.kredinbizdeservice.model;


import com.patika.kredinbizdeservice.model.constant.UserEntityColumnConstants;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users")
public class User extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = UserEntityColumnConstants.NAME, unique = false, nullable = false)
    private String name;
    @Column(name = UserEntityColumnConstants.SURNAME, unique = false, nullable = false)
    private String surname;
    @Column(name = UserEntityColumnConstants.BIRTH_DATE, nullable = true)
    private LocalDate birthDate;
    @Column(name = UserEntityColumnConstants.EMAIL, unique = true, nullable = false)
    private String email;
    @Column(name = UserEntityColumnConstants.PASSWORD, unique = false, nullable = false)
    private String password;
    @Column(name = UserEntityColumnConstants.PHONE_NUMBER, unique = false, nullable = true)
    private String phoneNumber;
    @Column(name = UserEntityColumnConstants.IS_ACTIVE, unique = false, nullable = true)
    private Boolean isActive;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = UserEntityColumnConstants.ADDRESS, nullable = true, unique = false)
    private Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Application> applicationList;

}
