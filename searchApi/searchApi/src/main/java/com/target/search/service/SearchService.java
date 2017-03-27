package com.target.search.service;

import com.target.data.domain.Item;
import com.target.data.service.Database;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Autowired
    private Database database;

    /**
     * Finds all items with the the given query.
     *
     * @param query - input query
     * @return - list of items with the given city.
     */
    public List<Item> findItemsByQuery(String query) {
        return database.findItemsByQuery(query);
    }
}

