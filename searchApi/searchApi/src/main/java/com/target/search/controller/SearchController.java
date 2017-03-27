package com.target.search.controller;

import com.target.data.domain.Item;
import com.target.search.service.SearchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Handles requests related to search.
 */
@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;


    /**
     * finds all items containing the given query.
     *
     * @param query input query
     * @return List of items with the given query.
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Item> findItems(
            @RequestParam("query") String query) {
        return searchService.findItemsByQuery(query);
    }
}

