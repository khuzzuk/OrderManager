package net.usermd.omdata.db;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Product product;
    @OneToOne
    private Price price;
}
