package com.patika.kredinbizdeservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address_title")
    private String addressTitle;

    @Column(name = "address_description")
    private String addressDescription;

    @Column(name = "province")
    private String province;
}
