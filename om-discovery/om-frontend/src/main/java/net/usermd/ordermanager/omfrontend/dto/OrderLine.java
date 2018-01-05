package net.usermd.ordermanager.omfrontend.dto;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class OrderLine {
    private long id;
    private CartItem cartItem;
    @Min(0)
    private int quantity;
}
