package dataSource;

import model.Order;

import java.util.List;

public interface OrderDataSource {
    List<Order> getOrders();
}
