package repository;

import model.Basket;

import java.util.List;

public interface BasketRepository {
    Basket save(Basket basket);

    List<Basket> getAll();

    Basket getById(Integer id);

    Basket update(Basket basket);

    boolean delete(Basket basket);
}
