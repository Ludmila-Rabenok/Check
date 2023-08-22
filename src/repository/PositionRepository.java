package repository;

import model.Position;

import java.util.List;

public interface PositionRepository {
    Position save(Position position);

    List<Position> getAll();

    Position getById(Integer id);

    Position update(Position position);

    boolean delete(Position position);
}
