package com.helloIftekhar.springJwt.model;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "roleName")
    private String roleName;

    @OneToOne(mappedBy = "role")
    private User user;
}

