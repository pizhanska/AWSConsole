package com.aws.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DataProv {
    private static Logger log = Logger.getLogger("AD");

    @DataProvider(name = "createInstance")
    public static Object[][] addEvent() {
        return readData("src/test/resources/createInstance.csv");
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
