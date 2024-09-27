package com.helloIftekhar.springJwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cart")
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcart")
    private int idCart;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idUser")
    private User user;

    @OneToMany(mappedBy = "cart")
    @JsonIgnore
    private List<Cart_Product> cartProducts;


}
