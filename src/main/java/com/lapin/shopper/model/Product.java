package com.lapin.shopper.model;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true, exclude = {"name", "price"})
public class Product extends AbstractModel implements Serializable {
    private String name;
    private BigDecimal price;
}