package service;

import model.Position;
import model.Product;

import java.util.List;

public interface PositionService {
    Position save(Position position);

    List<Position> getAll();

    Position getById(Integer id);

    Position update(Position position);

    boolean delete(Position position);

    Position createPosition(Integer productId, Integer quantity);

    Integer countDiscount(Product product, Integer quantity);

  //  void printPosition(Position positions);
}
