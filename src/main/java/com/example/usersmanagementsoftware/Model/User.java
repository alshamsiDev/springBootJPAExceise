package com.example.usersmanagementsoftware.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Integer id;

    @NotEmpty
    @Size(min = 4)
    @Column(nullable = false)
    private String name;

    @NotEmpty
    @Size(min = 4)
    @Column(nullable = false, unique = true)
    private String username;

    @NotEmpty
    @Size(min = 8, max = 16)
    @Column(nullable = false)
    private String password;

    @Email
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated
    private Roles role;


    @NotNull
    @Column(nullable = false)

    private Integer age;


    public enum Roles {
        USER, ADMIN;
    }
}
