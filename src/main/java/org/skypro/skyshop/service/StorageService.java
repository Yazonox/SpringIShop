package org.skypro.skyshop.service;


import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {


    private final Map<UUID, Product> productM;
    private final Map<UUID, Article> articleM;

    //Конструктор
    public StorageService() {

        this.productM = new HashMap<>();
        this.articleM = new HashMap<>();

        getSearchableMaps();
    }

    //Map<UUID, Product> productM, Map<UUID, Article> articleM

    //Геттеры
    public Map<UUID, Product> getProductM() {
        return productM;
    }

    public Map<UUID, Article> getArticleM() {
        return articleM;
    }


    //Метод заполнения коллекций полей значениями
    private void getSearchableMaps() {

        UUID uuid = UUID.randomUUID();
        this.productM.put(uuid, new DiscountedProduct(uuid, "морковь", 50, 10));
        uuid = UUID.randomUUID();
        this.productM.put(uuid, new FixPriceProduct(uuid, "рис"));
        uuid = UUID.randomUUID();
        this.productM.put(uuid, new SimpleProduct(uuid, "хлеб", 45));
        uuid = UUID.randomUUID();
        this.productM.put(uuid, new SimpleProduct(uuid, "лук", 40));
        uuid = UUID.randomUUID();
        this.productM.put(uuid, new DiscountedProduct(uuid, "сахар", 70, 20));
        uuid = UUID.randomUUID();
        this.productM.put(uuid, new SimpleProduct(uuid, "картофель", 65));
        uuid = UUID.randomUUID();
        this.productM.put(uuid, new DiscountedProduct(uuid, "картофель", 65, 20));

        uuid = UUID.randomUUID();
        this.articleM.put(uuid, (new Article(uuid, "хлеб", "История хлеба началась задолго до письменности")));
        uuid = UUID.randomUUID();
        this.articleM.put(uuid, (new Article(uuid, "рис", "В китайской культуре рис часто сравнивают с хлебом ")));
        uuid = UUID.randomUUID();
        this.articleM.put(uuid, (new Article(uuid, "сахар", "Пищевой продукт со сладким вкусом")));
        uuid = UUID.randomUUID();
        this.articleM.put(uuid, (new Article(uuid, "морковь", "Широко распространённая овощная культура")));
        uuid = UUID.randomUUID();
        this.articleM.put(uuid, (new Article(uuid, "картофель", "По пищевой ценности картофель  близок к хлебу")));
        uuid = UUID.randomUUID();
        this.articleM.put(uuid, (new Article(uuid, "фасоль", "Как источник растительного белка фасоль сравнивают с хлебом")));
    }




    public Set<Searchable> getSearchable() {
        //getSearchableMaps();
        Set<Searchable> searchables = new HashSet<>();

        searchables.addAll(this.getArticleM().values());
        searchables.addAll(this.getProductM().values());

        return searchables;
    }


}
