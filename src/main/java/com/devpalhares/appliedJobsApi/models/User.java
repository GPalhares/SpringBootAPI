package com.devpalhares.appliedJobsApi.models;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "username", length = 50, nullable = false)
    private String username;
    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;
    @Column(name = "password", length = 80, nullable = false)
    private String password;
}
