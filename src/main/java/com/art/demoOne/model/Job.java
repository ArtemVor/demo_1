package com.art.demoOne.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Job {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String organization;

    private String position;

    @ManyToMany(mappedBy = "jobs")
    private List<MyUser> users;

}
