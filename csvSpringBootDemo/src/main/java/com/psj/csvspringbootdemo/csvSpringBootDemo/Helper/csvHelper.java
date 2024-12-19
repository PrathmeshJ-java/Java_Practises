package com.psj.csvspringbootdemo.csvSpringBootDemo.Helper;

import com.psj.csvspringbootdemo.csvSpringBootDemo.Entity.Product;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class csvHelper {

    public static boolean hasCSVFormat(MultipartFile file) {
        return "text/csv".equals(file.getContentType());
    }

    public static List<Product> csvDataEntities(InputStream is){
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            CSVParser csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            List<Product> dataEntities = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                Product dataEntity = new Product(
                        csvRecord.get("productName"),
                        csvRecord.get("Description"),
                        Integer.parseInt(csvRecord.get("price")),
                        csvRecord.get("manufacturedBy"),
                        Date.from(Instant.parse("manufacturedDate")),
                        Date.from(Instant.parse("expiryDate"))
                );
                dataEntities.add(dataEntity);
            }

            return dataEntities;
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException("Failed to parse CSV file: " + e.getMessage());
        }
    }

}
