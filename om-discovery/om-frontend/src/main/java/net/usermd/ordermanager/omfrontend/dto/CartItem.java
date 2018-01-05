package net.usermd.ordermanager.omfrontend.dto;

import lombok.Data;

@Data
public class CartItem {
    private long id;
    private Product product;
    private Price price;
}
