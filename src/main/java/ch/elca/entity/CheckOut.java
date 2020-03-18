package ch.elca.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CheckOut {

    private int price;

    private Pizza pizza;
}
