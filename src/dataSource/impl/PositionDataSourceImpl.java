package dataSource.impl;

import dataSource.PositionDataSource;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class PositionDataSourceImpl implements PositionDataSource {
    private static List<Position> positions=new ArrayList<>();

    @Override
    public List<Position> getPositions() {
        return positions;
    }
}
