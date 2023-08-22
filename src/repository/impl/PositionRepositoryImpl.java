package repository.impl;

import dataSource.PositionDataSource;
import model.Position;
import repository.PositionRepository;
import util.IdGenerator;

import java.util.List;

public class PositionRepositoryImpl implements PositionRepository {
    private final PositionDataSource positionDataSource;

    public PositionRepositoryImpl(PositionDataSource positionDataSource) {
        this.positionDataSource = positionDataSource;
    }

    @Override
    public Position save(Position position) {
        position.setId(IdGenerator.generatePositionId());
        positionDataSource.getPositions().add(position);
        return position;
    }

    @Override
    public List<Position> getAll() {
        return positionDataSource.getPositions();
    }

    @Override
    public Position getById(Integer id) {
        return getAll().stream()
                .filter(x -> id.equals(x.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Position update(Position position) {
        Position positionForUpdate = getById(position.getId());
        positionForUpdate.setDiscountByPosition(position.getDiscountByPosition());
        positionForUpdate.setPriceByPosition(position.getPriceByPosition());
        positionForUpdate.setProduct(position.getProduct());
        positionForUpdate.setQuantity(position.getQuantity());
        return positionForUpdate;
    }

    @Override
    public boolean delete(Position position) {
        return getAll().remove(position);
    }

}
