package net.usermd.omdata.db;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Data
@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private CartItem cartItem;
    @Min(0)
    private int quantity;
}
