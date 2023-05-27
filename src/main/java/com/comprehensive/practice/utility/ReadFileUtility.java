package com.comprehensive.practice.utility;

import com.comprehensive.practice.bean.People;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ReadFileUtility {

    private static final String COMMA_DELIMITER= ",";
    public static void main(String[] args) throws FileNotFoundException {
        List<List<People>> records = new ArrayList<>(1000);
        try (Scanner scanner = new Scanner(new File("/Users/nitingupta2/13/testingData/people-1000.csv"));) {
            Objects.requireNonNull(scanner);
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        }
    }

    private static List<People> getRecordFromLine(String line) {
        List<People> values = new ArrayList<People>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                //values.add(rowScanner.next());
               // String valu = rowScanner.next();
                System.out.print(rowScanner.next());
            }
        }
        return values;
    }
}
