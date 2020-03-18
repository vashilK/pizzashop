package ch.elca.controller;


import ch.elca.entity.CheckOut;
import ch.elca.entity.Pizza;
import ch.elca.enums.Base;
import ch.elca.enums.PizzaType;
import ch.elca.enums.Toppings;
import ch.elca.service.impl.PizzaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/pizza")
public class PizzaController {

    @Autowired
    PizzaServiceImpl pizzaService;

    /*
     *
     *       TOPPINGS WERE SET AS NOT REQUIRED AS THERE MIGHT BE PEOPLE WHO DO NOT WANT TOPPINGS &
     *               IT ALSO A LIST BECAUSE PEOPLE MIGHT WANT MORE THAN ONE TOPPING
     *
     *      RESPONSESTATUS HERE DOES NOT SERVE MUCH AS ENUMS ARE USED ANYTHING NOT EXPECTED IN THE QUERY
     *              WILL BE DEEMED AS BAD REQUEST
     *
     * */
    @GetMapping("/order")
    @ResponseBody
    public Pizza getOrder(@RequestParam(name = "type", required = true) PizzaType type,
                          @RequestParam(name = "base", required = true) Base base,
                          @RequestParam(name = "toppings", required = false) List<Toppings> toppings,
                          @RequestParam(name = "quantity", required = true) int quantity) {
        try {
            return pizzaService.orderPizza(type, base, toppings, quantity);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hello please make use of enums. (^_^)");
        }

    }

    /*
    *          FOLLOWS SAME LOGIC SA THE ORDER MAPPING ONLY DIFFERENCE IS THAT THE
    *
    * */
    @GetMapping("/bill")
    @ResponseBody
    public CheckOut getBill(@RequestParam(name = "type", required = true) PizzaType type,
                            @RequestParam(name = "base", required = true) Base base,
                            @RequestParam(name = "toppings", required = false) List<Toppings> toppings,
                            @RequestParam(name = "quantity", required = true) int quantity) {

        return pizzaService.getBill(Pizza.builder().type(type).base(base).toppings(toppings).quantity(quantity).build());
    }
}
