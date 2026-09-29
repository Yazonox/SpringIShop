package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;


    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProdById(UUID id) {
        storageService.getProductById(id).orElseThrow(() -> new IllegalArgumentException("Данный продукт отсутствует"));
        productBasket.addProduct(id);
    }


    public List<BasketItem> getUserBasket() {//???????

        Map<UUID, Integer> prodBasket = productBasket.getProductBasket();

        return prodBasket.entrySet().stream()
                .map(entry -> {
                    Product product = storageService.getProductById(entry.getKey())
                            .orElseThrow(() -> new IllegalArgumentException("Данный продукт отсутствует"));
                    return new BasketItem(product, entry.getValue());
                })
                .collect(Collectors.toList());

    }
}
