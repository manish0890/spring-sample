package com.manish0890.spring.sample.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.util.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.manish0890.spring.sample.utils.FileUtility.getFile;


public class CsvUtility {

    private CsvUtility() {
        // For Static access
    }

    /**
     * Retrieves all rows from a CSV file
     *
     * @param path {@link String} file path from resources directory
     * @return {@link List} of Rows as String
     */
    public static List<String[]> getRowsFromCsvFile(String path) {
        Assert.notNull(path, "path cannot be null");
        List<String[]> rows = new ArrayList<>();

        try (FileReader fileReader = new FileReader(getFile(path));
             CSVReader reader = new CSVReader(fileReader)) {
            rows = reader.readAll();
        } catch (IOException | CsvException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }

        return rows;
    }
}
