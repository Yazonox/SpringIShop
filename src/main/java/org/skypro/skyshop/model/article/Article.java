package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable, Comparable<Article>{

    private final UUID id;
    private final String artName;
    private final String artText;



    public Article(UUID id, String artName, String artText) {
        this.id = id;
        this.artName = artName;
        this.artText = artText;
    }

    public String getArtName() {
        return artName;
    }

    public String getArtText() {
        return artText;
    }

    @Override
    public UUID getId() {
        return id;
    }


    //3
    @Override
    public String toString() {
        return artName + "\n" + artText;
    }
    //3
    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return artName + "\n" + artText ;
    }
    //3
    @JsonIgnore
    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    //3   ????
    @Override
    public String getObjectName() {
        return this.artName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if  (!(o instanceof Article article)) return false;
        return Objects.equals(artName, article.artName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(artName);
    }

    @Override
    public int compareTo(Article o) {
        return this.getArtName().compareTo(o.getArtName());
    }
}
