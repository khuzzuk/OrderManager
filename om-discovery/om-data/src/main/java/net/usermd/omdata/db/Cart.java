package net.usermd.omdata.db;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(mappedBy = "id")
    private List<OrderLine> orderLines;
}
