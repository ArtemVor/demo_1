package com.art.demoOne.model;

import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@Entity
@Table( uniqueConstraints = {@UniqueConstraint(columnNames = {"country", "city","street","homeNumber"})})
public class Address {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank(message = "country is required")
    private String country;

    @NotNull
    @NotBlank(message = "city is required")
    private String city;

    @NotNull
    @NotBlank(message = "street is required")
    private String street;

    @Positive
    @NotNull(message = "home number is required")
    private Long homeNumber;

    @OneToMany (mappedBy = "address")
    @BatchSize(size = 10)
    private List<MyUser> users;

}
