package net.usermd.ordermanager.omfrontend.dto;

import lombok.Data;

import java.util.List;

@Data
public class Cart {
    private long id;
    private List<OrderLine> orderLines;
}
