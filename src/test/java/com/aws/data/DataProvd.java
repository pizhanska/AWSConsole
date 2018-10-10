package com.aws.data;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class DataProvd {

    private static Logger log = Logger.getLogger("");

    @DataProvider(name = "testData")
    public static Object[][] invalidLogin() {
        return readData("src/main/resources/TestData.csv");
    }


    private static Object[][] readData(String path){
        String[][] data = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            List<String[]> list = bufferedReader.lines()
                    .map(line -> line.split(";"))
                    .collect(Collectors.toList());
            data = list.toArray(new String[list.size()][]);

        }
        catch (FileNotFoundException e){
            log.info("Oops, fle is not found");
        }
        return data;
    }
}
