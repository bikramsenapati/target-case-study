package com.target.data.service;

import com.target.data.domain.Item;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataReader {


    private static final String TITLE = "TITLE";
    private static final String BRAND = "BRAND";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String COLOR = "COLOR";


    @Autowired
    private Database database;

    @PostConstruct
    public void init() throws URISyntaxException, IOException {
        List<String> lines = Files.lines(Paths.get(ClassLoader.getSystemResource("data.csv").toURI()),
                StandardCharsets.ISO_8859_1).collect(Collectors.toList());
        if (lines != null && lines.size() != 0) {
            List<String> headers = getHeaders(lines);
            for (int i = 1; i < lines.size(); i++) {
                List<String> values = getValues(lines.get(i));
                Item item = constructItem(headers, values);
                database.add(item);
            }
        }
    }

    private Item constructItem(List<String> headers, List<String> values) {
        Map<String, String> propertyMap = new HashMap<>();
        for (int i = 0; i < headers.size(); i++) {
            propertyMap.put(headers.get(i), values.get(i));
        }
        String title = propertyMap.get(TITLE);
        String brand = propertyMap.get(BRAND);
        String color = propertyMap.get(COLOR);
        String description = propertyMap.get(DESCRIPTION);
        return new Item(title, description, brand, color);
    }

    private List<String> getHeaders(List<String> lines) {
        String line = lines.get(0);
        return getValues(line);
    }

    private List<String> getValues(String line) {
        String[] headers = line.split(",");
        return Arrays.asList(headers);
    }

}

