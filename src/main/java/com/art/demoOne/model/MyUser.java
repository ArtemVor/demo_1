package com.art.demoOne.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class MyUser {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @NotBlank(message = "firstName is required")
    @Size(min = 1, max = 10)
    private String firstName;

    @NotNull
    @NotBlank(message = "secondName is required")
    @Size(min = 1, max = 20)
    private String lastName;

    @NotNull
    @NotBlank(message = "email is required")
    @Email
    private String email;

    @NotNull(message = "age is required")
    @Min(18)
    @Max(100)
    private Long age;

    @NotNull
    @NotBlank(message = "phone number is required")
    @Pattern(regexp = "\\(\\d{3}\\)\\d{3}-\\d{4}", message = "must match the format of the phone number (***)***-****")
    private String phoneNumber;


    @OneToOne
    private Passport passport;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    @Valid
    private Address address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_jobs",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "job_id")}
    )
    private List<Job> jobs;


}
