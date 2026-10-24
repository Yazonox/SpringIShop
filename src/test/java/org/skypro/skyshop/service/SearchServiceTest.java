package org.skypro.skyshop.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;


@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    private StorageService storageService;

    @InjectMocks
    private SearchService searchService;

    @Test
    public void testSearchService_WhenStorageIsEmpty() {
        Mockito.when(storageService.getSearchable()).thenReturn(Collections.emptySet());
        Set<SearchResult> results = searchService.search("");
        assertTrue(results.isEmpty());
    }

    @Test
    public  void testSearchService_WhenNoSuitableObject() {
        Product product = new SimpleProduct(UUID.randomUUID(),"хлеб", 56);
        Mockito.when(storageService.getSearchable()).thenReturn(Collections.singleton(product));
        Set<SearchResult> results = searchService.search("соль");
        assertTrue(results.isEmpty());
    }

    @Test
    public void testSearchService_whenObjectIsFound() {
        String sTerm = "Test";
        Product testProduct = new SimpleProduct(UUID.randomUUID(),"Test", 56);
        Mockito.when(storageService.getSearchable()).thenReturn(Collections.singleton(testProduct));
        Set<SearchResult> results = searchService.search(sTerm);
        SearchResult Key = results.stream().filter(u -> Objects.equals(u.getName(),sTerm )).findFirst().orElse(null);
        assert Key != null;
        assertEquals("Test",Key.getName());
    }


}
