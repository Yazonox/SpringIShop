package org.skypro.skyshop.service;

public class NoSuchProductException  extends RuntimeException{

    public NoSuchProductException() {
        super("Товар не найден");
    }
}
