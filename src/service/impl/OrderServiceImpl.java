package service.impl;

import model.DiscountCard;
import model.Order;
import model.OrderBuilder;
import repository.OrderRepository;
import service.DiscountCardService;
import service.OrderService;
import util.ParsingFile;

import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final DiscountCardService discountCardService;
    private final ParsingFile parsingFile = new ParsingFile();

    public OrderServiceImpl(OrderRepository orderRepository, DiscountCardService discountCardService) {
        this.orderRepository = orderRepository;
        this.discountCardService = discountCardService;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public Order getById(Integer id) {
        return orderRepository.getById(id);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.update(order);
    }

    @Override
    public boolean delete(Order order) {
        return orderRepository.delete(order);
    }

    @Override
    public Order createOrderFromArgsInFile(String fileName) {
        return createOrder(importArgsFromFile(fileName));
    }

    @Override
    public Map<Integer, Integer> importArgsFromFile(String fileName) {
        String args = parsingFile.readAll(fileName);
        return parsingFile.prepareAfterImport(args);
    }

    @Override
    public Order createOrder(Map<Integer, Integer> map) {
        Order order;
        if (map.containsKey(null)) {
            DiscountCard card = discountCardService.getByNumber(map.get(null));
            map.remove(null);
            order = new OrderBuilder().setDiscountCard(card).setProductAndQuantityMap(map).build();
        } else order = new OrderBuilder().setProductAndQuantityMap(map).build();
        return save(order);
    }
}
