package net.usermd.omdata.db;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.Min;

@Data
@Embeddable
public class Weight {
    @Min(0)
    public double value;
}

