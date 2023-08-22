package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParsingFile {

    public String readAll(String fileName) {
        String str = null;
        try (FileReader fileReader = new FileReader(
                "c:\\Users\\User\\IdeaProjects\\checkFactory\\src\\" + fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            str = bufferedReader.readLine();

        } catch (IOException e) {
            System.err.println("Error during import data from csv file ");
            e.getStackTrace();
        }
        return str;
    }

    public boolean writeAll(List<String> list) {
        try (FileWriter fw = new FileWriter(
                "c:\\Users\\User\\IdeaProjects\\checkFactory\\src\\checkExport")) {
            for (String str : list) {
                fw.write(str);
                fw.flush();
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error during export data to csv file ");
            e.getStackTrace();
        }
        return false;
    }

    public List<String> prepareForExport(List<String> list) {
        return list.stream().map(s -> s + "\n").collect(Collectors.toList());
    }

    public Map<Integer, Integer> prepareAfterImport(String args) {
        String[] allArgs = args.split(" ");
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (String arg : allArgs) {
            String[] array = arg.split("-");
            if (array[0].equals("card")) {
                Integer numberCard = Integer.parseInt(array[1]);
                map.put(null, numberCard);
            } else {
                map.put(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
            }
        }
        return map;
    }
}
