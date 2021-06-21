package com.art.demoOne.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Passport {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String series;

    private Long number;

    @OneToOne
    private MyUser user;
}
