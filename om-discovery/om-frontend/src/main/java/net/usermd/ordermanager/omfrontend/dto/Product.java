package net.usermd.ordermanager.omfrontend.dto;

import lombok.Data;

@Data
public class Product {
    private long id;
    private String name;
    private Weight weight;
}