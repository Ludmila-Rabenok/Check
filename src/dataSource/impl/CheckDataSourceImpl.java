package dataSource.impl;

import dataSource.CheckDataSource;
import model.Check;

import java.util.ArrayList;
import java.util.List;

public class CheckDataSourceImpl implements CheckDataSource {
    List<Check> checks = new ArrayList<>();

    @Override
    public List<Check> getChecks() {
        return checks;
    }
}
