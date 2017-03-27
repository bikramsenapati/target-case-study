package com.target.data.service;

import com.target.data.domain.Item;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Database which stores all the item data
 */
@Component
public class Database {

    /**
     * list of items.
     */
    private List<Item> items = new ArrayList<>();

    /**
     * Adds a new item to the list of items saved.
     *
     * @param item - Item object to be saved.
     */
    public void add(Item item) {
        items.add(item);
    }

    /**
     * Retrieves list of items which contains the given query.
     *
     * @param query - input query
     */
    public List<Item> findItemsByQuery(String query) {
        List<Item> result = new ArrayList<>();
        if (this.items != null && items.size() > 0) {
            for (Item item : items) {
                if (item.getValue().contains(query)) {
                    result.add(item);
                }
            }
        }
        return result;
    }
}

