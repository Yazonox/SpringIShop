package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }


    public Set<SearchResult> search(String searchTerm) {

        Set<Searchable> searchables = storageService.getSearchable();

        return searchables.stream()
                .filter(searchable -> searchable != null && (searchable.getSearchTerm()).toLowerCase().contains(searchTerm.toLowerCase()) )
                .map((SearchResult::fromSearchable))
                .collect(Collectors.toCollection(HashSet::new));
    }

}
