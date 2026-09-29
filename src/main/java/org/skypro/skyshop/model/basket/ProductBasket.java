package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Component
@SessionScope
public class ProductBasket {
    private final Map<UUID, Integer> productBasket = new HashMap<>();





    public void addProduct(UUID id) {
        productBasket.compute(id,(Key, count)-> count == null? 1:count + 1);//?????
    }

    public Map<UUID, Integer> getProductBasket() {
        return Collections.unmodifiableMap(productBasket);   }

}
