package org.skypro.skyshop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {
    private UserBasket userBasket;

    @Mock
    private ProductBasket productBasket;

    @Mock
    private  StorageService storageService;

    @InjectMocks
    private BasketService basketService;

    @Test
    public void testWhenAddedProductIsNull() {
        UUID invalidId = UUID.randomUUID();
        Mockito.when (storageService.getProductById(invalidId)).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> basketService.addProdById(invalidId));
    }

    @Test
    public void testWhenAddedProductIsPresent() {
        UUID validId = UUID.randomUUID();
        Product product = new SimpleProduct(validId, "хлеб", 45);
        Mockito.when(storageService.getProductById(validId)).thenReturn(Optional.of(product));
        basketService.addProdById(validId);
        Mockito.verify(productBasket,Mockito.times(1)).addProduct(validId);
    }

    @Test
    public void testWhenProductBasketIsEmpty() {
        Mockito.when(productBasket.getProductBasket()).thenReturn(Collections.emptyMap());
        userBasket = new UserBasket(basketService.getUserBasket());
        assertThat(userBasket.getBasketItems()).isEmpty();
        assertThat(userBasket.getTotal()).isZero();
    }

    @Test
    public void testWhenProductBasketNotEmpty() {
        UUID id1 = UUID.randomUUID();
        Product product = new SimpleProduct(id1, "хлеб", 45);

        Mockito.when(productBasket.getProductBasket()).thenReturn(Collections.singletonMap(id1,1));
        Mockito.when(storageService.getProductById(id1)).thenReturn(Optional.of(product));
        userBasket = new UserBasket(basketService.getUserBasket());

        assertThat(userBasket.getBasketItems());
        assertThat(userBasket.getTotal());

    }



}
