package com.hasan.thymeleaf.example.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Length(max = 64)
    @Column(name = "display_name")
    private String displayName;

    @Length(max = 16)
    @Column(name = "first_name")
    private String firstName;

    @Length(max = 16)
    @Column(name = "last_name")
    private String lastName;

    @Length(max = 64)
    @Column(name = "email")
    private String email;

}
