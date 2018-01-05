package net.usermd.ordermanager.omfrontend.dto;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class Price {
    private long id;
    @Min(0)
    public double value;
}
