package com.art.demo_1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MyUser {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "firstName is required")
    @Size(min = 1, max = 10)
    private String firstName;

    @NotBlank(message = "secondName is required")
    @Size(min = 1, max = 20)
    private String lastName;

    @NotBlank(message = "email is required")
    @Email
    private String email;

    @NotNull(message = "age is required")
    private Long age;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
