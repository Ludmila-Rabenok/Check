package repository;

import model.Order;

import java.util.List;

public interface OrderRepository {
    Order save(Order order);

    List<Order> getAll();

    Order getById(Integer id);

    Order update(Order order);

    boolean delete(Order order);
}
