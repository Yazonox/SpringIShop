package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable, Comparable<Product> {

    private final UUID id;
    private final String name;


    public Product(UUID uuid, String productName) {
        this.id = uuid;
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Невеврное наименование продукта");
        } else {
            this.name = productName;
        }
    }
    //UUID uuid = getId();


    public String getName() {
        return name;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public abstract int getPrice();

    @Override
    public String toString() {
        return name;
    }

    public abstract boolean isSpecial();


    //3
    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return getName();
    }

    //3
    @JsonIgnore
    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    //3  ????
    @Override
    public String getObjectName() {
        return this.name;
    }

    @Override
    public String getStringRepresentation() {
        return Searchable.super.getStringRepresentation();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);//Map переопределить
    }

    @Override
    public boolean equals(Object obj) {//Map переопределить
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product product = (Product) obj;

        return Objects.equals(name, product.name);
    }

    @Override
    public int compareTo(Product o) {
        return this.getName().compareTo(o.getName());
    }
}
