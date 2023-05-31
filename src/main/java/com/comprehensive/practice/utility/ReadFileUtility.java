package com.comprehensive.practice.utility;

import com.comprehensive.practice.bean.People;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ReadFileUtility {

    private static final String COMMA_DELIMITER = ",";

    public  List<People> getRecordFromLine() {
        List<People> peopleList = new ArrayList<>();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try (InputStream inputStream = getClass().getClassLoader()
                    .getResourceAsStream("people-1000.csv")) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                String line;
                int count = 0;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(COMMA_DELIMITER);
                    if (count != 0) {
                        peopleList.add(new People(Integer.valueOf(values[0]), values[1], values[2],
                                values[3], values[4], values[5], values[6], LocalDate.parse(values[7], formatter), values[8]));
                    }
                    count = 1;
                }
            }
        }catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }
        return peopleList;
    }
}
