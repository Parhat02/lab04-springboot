package org.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.cydeo.enums.QuantityType;

@Getter
@Setter
public class Ingredient {
    private String name;
    private int quantity;;
    private QuantityType quantityType;

}
