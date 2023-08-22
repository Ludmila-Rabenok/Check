package dataSource.impl;

import dataSource.OrderDataSource;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDataSourceImpl implements OrderDataSource {
    private static List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

}
