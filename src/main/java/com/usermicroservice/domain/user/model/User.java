package com.usermicroservice.domain.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private String id;

    @Column( nullable = false)
    private String name;

    @Column( nullable = false)
    private String email;

    @Column( nullable = false)
    private String password;
}
