package org.skypro.skyshop.model.basket;


import java.util.List;

public class UserBasket {
    private final List<BasketItem> basketItems;
    private final int  total;

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public int getTotal() {
        return total;
    }

    public UserBasket(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
        this.total = basketItems.stream()
                .mapToInt(m -> m.getProduct().getPrice() * m.getQuantity())
                .sum();
    }

    @Override
    public String toString() {
        return "UserBasket{" +
                "basketItems=" + basketItems +
                ", total=" + total +
                '}';
    }
}
