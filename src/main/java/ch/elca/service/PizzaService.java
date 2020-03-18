package ch.elca.service;

import ch.elca.entity.CheckOut;
import ch.elca.entity.Pizza;
import ch.elca.enums.Base;
import ch.elca.enums.PizzaType;
import ch.elca.enums.Toppings;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

public interface PizzaService {

    Pizza orderPizza(PizzaType type, Base base, List<Toppings> toppings, int quantity) throws HttpStatusCodeException;

    CheckOut getBill(Pizza order);
}
