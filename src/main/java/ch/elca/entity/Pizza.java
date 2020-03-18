package ch.elca.entity;

import ch.elca.enums.Base;
import ch.elca.enums.PizzaType;
import ch.elca.enums.Toppings;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Pizza {

    private PizzaType type;

    private Base base;

    private List<Toppings> toppings;

    private int quantity;
}
