package repository.impl;

import dataSource.OrderDataSource;
import model.Order;
import repository.OrderRepository;
import util.IdGenerator;

import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private final OrderDataSource orderDataSource;

    public OrderRepositoryImpl(OrderDataSource orderDataSource) {
        this.orderDataSource = orderDataSource;
    }

    @Override
    public Order save(Order order) {
        order.setId(IdGenerator.generateOrderId());
        orderDataSource.getOrders().add(order);
        return order;
    }

    @Override
    public List<Order> getAll() {
        return orderDataSource.getOrders();
    }

    @Override
    public Order getById(Integer id) {
        return getAll().stream()
                .filter(x -> id.equals(x.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Order update(Order order) {
        Order orderForUpdate = getById(order.getId());
        orderForUpdate.setDiscountCard(order.getDiscountCard());
        orderForUpdate.setProductAndQuantityMap(order.getProductAndQuantityMap());
        return orderForUpdate;
    }

    @Override
    public boolean delete(Order order) {
        return getAll().remove(order);
    }

}
