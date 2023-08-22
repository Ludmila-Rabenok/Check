package service;

import model.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    Order save(Order order);

    List<Order> getAll();

    Order getById(Integer id);

    Order update(Order order);

    boolean delete(Order order);

    Map<Integer, Integer> importArgsFromFile(String fileName);

    Order createOrderFromArgsInFile(String fileName);

    Order createOrder(Map<Integer, Integer> map);

}
