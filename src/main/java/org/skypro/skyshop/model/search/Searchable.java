package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {

     UUID getId();

    String getSearchTerm();

    String getContentType();

    String getObjectName();

    default String getStringRepresentation() {
        return getObjectName() + ": " + getContentType();
    }

}
