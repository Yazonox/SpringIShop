package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {

    private int basePrice;
    private int discount;
    private static final int KOEFF = 100;

    public DiscountedProduct(UUID uuid, String productName, int basePrice, int discountWholePercent) {
        super(uuid, productName);
        if (basePrice > 0) {
            this.basePrice = basePrice;
        } else {
            throw new IllegalArgumentException("Неверное значение базовой цены продукта");
        }
        if (discountWholePercent >= 0 && discountWholePercent <= 100) {
            this.discount = discountWholePercent;
        } else {
            throw new IllegalArgumentException("Неверное значение процента скидки");
        }
    }




    @Override
    public int getPrice() {
        return this.basePrice - (basePrice * discount / KOEFF);
    }

    @Override
    public String toString() {
        return super.getName() + ": " + this.getPrice() + " (" + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
