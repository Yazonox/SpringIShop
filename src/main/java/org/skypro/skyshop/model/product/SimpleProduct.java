package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(UUID uuid, String productName, int price) {
        super(uuid, productName);
        if (price > 0) {
            this.price = price;
        } else {
            throw  new IllegalArgumentException("Неверно введена цена продукта");
        }

    }

    @Override
    public int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return super.getName() + ": " + this.price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
