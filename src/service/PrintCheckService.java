package service;

import model.Check;

import java.util.List;

public interface PrintCheckService {

    List<String> prepareCheck(Check check);

    void printCheckToConsole(Check check);

    void exportCheckToFile(Check check);
}
