package com.art.demoOne.batch.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

//@Entity
@Data
@RequiredArgsConstructor
public class Coffee {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand;
    private String origin;
    private String characteristics;


    public Coffee(String brand, String origin, String characteristics) {
        this.brand = brand;
        this.origin = origin;
        this.characteristics = characteristics;
    }

}
