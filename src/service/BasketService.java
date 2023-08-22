package service;

import model.Basket;
import model.Order;
import model.Position;

import java.util.List;

public interface BasketService {

    Basket save(Basket basket);

    List<Basket> getAll();

    Basket getById(Integer id);

    Basket update(Basket basket);

    boolean delete(Basket basket);

    Basket createBasket(Order order);

    Integer countPriceBasket(List<Position> positions);

    int countDiscount(Order order, int price);

    int countTotalPrice(int price, int discount);

    List<Position> getPositions(Order order);

}
