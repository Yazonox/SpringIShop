package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.model.searchresult.SearchResult;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ShopController {
    StorageService storageService;
    SearchService searchService;

    public ShopController(StorageService storageService, SearchService searchService) {
        this.storageService = storageService;
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public Collection<SearchResult> getResSearch(@RequestParam("pattern") String pattern) {
        return searchService.search(pattern);
    }

    //????????
    @GetMapping("/store")
    public Collection<Searchable> getSearchable() {
        return storageService.getSearchable();
    }

    @GetMapping("/products")
    public Collection<Product> getAllProducts(){
        return  storageService.storageService().getProductM().values();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticles() {
        return  storageService.storageService().getArticleM().values();
    }


}
