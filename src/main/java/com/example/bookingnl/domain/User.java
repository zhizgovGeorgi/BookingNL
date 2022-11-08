package com.example.bookingnl.domain;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String adress;
    @Column(columnDefinition = "varchar(255) default 'Customer'")
    private String role;
}
