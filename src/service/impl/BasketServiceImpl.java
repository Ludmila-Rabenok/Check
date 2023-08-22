package service.impl;

import model.Basket;
import model.BasketBuilder;
import model.Order;
import model.Position;
import repository.BasketRepository;
import service.BasketService;
import service.PositionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;
    private final PositionService positionService;

    public BasketServiceImpl(BasketRepository basketRepository, PositionService positionService) {
        this.basketRepository = basketRepository;
        this.positionService = positionService;
    }

    @Override
    public Basket save(Basket basket) {
        return basketRepository.save(basket);
    }

    @Override
    public List<Basket> getAll() {
        return basketRepository.getAll();
    }

    @Override
    public Basket getById(Integer id) {
        return basketRepository.getById(id);
    }

    @Override
    public Basket update(Basket basket) {
        return basketRepository.update(basket);
    }

    @Override
    public boolean delete(Basket basket) {
        return basketRepository.delete(basket);
    }

    @Override
    public Basket createBasket(Order order) {
        Basket basket;
        List<Position> positions = getPositions(order);
        Integer price = countPriceBasket(positions);
        if (order.getDiscountCard() != null) {
            int discountByCard = countDiscount(order, price);
            int totalPrice = countTotalPrice(price, discountByCard);
            basket = new BasketBuilder(order).setPositions(positions).setPrice(price).setDiscountByCard(discountByCard)
                    .setTotalPrice(totalPrice).build();
        } else basket = new BasketBuilder(order).setPositions(positions).setTotalPrice(price).build();
        return save(basket);
    }

    @Override
    public List<Position> getPositions(Order order) {
        List<Position> positions = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : order.getProductAndQuantityMap().entrySet()) {
            Position position = positionService.createPosition(entry.getKey(), entry.getValue());
            positions.add(position);
        }
        return positions;
    }

    @Override
    public Integer countPriceBasket(List<Position> positions) {
        int price = 0;
        for (Position position : positions) {
            price = price + position.getPriceByPosition();
        }
        return price;
    }

    @Override
    public int countDiscount(Order order, int price) {
        int percent = order.getDiscountCard().getPercent();
        return price * percent / 100;
    }

    @Override
    public int countTotalPrice(int price, int discount) {
        return price - discount;
    }
}
