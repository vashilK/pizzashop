package ch.elca.service.impl;

import ch.elca.entity.CheckOut;
import ch.elca.entity.Pizza;
import ch.elca.enums.Base;
import ch.elca.enums.PizzaType;
import ch.elca.enums.Price;
import ch.elca.enums.Toppings;
import ch.elca.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaServiceImpl implements PizzaService {


    @Override
    public Pizza orderPizza(PizzaType type, Base base, List<Toppings> toppings, int quantity) {
        return Pizza.builder().type(type).base(base).toppings(toppings).quantity(quantity).build();
    }

    @Override
    public CheckOut getBill(Pizza order) {
        int price = 0;

        for (String x : Arrays.stream(Price.values()).map(Enum::name).collect(Collectors.toList())) {
            if (String.valueOf((order.getToppings())).contains(x)) {
                price += 10;
            }
        }

        price += Arrays.stream(Price.values()).anyMatch(t -> t.name().equals(order.getType().toString())) ?
                Price.valueOf(order.getType().toString()).getValue() : 0;

        price += Arrays.stream(Price.values()).anyMatch(t -> t.name().equals(order.getBase().toString())) ?
                Price.valueOf(order.getBase().toString()).getValue() : 0;

        price = price *  order.getQuantity();

        return CheckOut.builder().pizza(order).price(price).build();
    }
}