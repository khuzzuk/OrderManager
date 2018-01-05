package net.usermd.ordermanager.omfrontend.dto;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class Weight {
    @Min(0)
    public double value;
}

