package repository.impl;

import dataSource.BasketDataSource;
import model.Basket;
import repository.BasketRepository;
import util.IdGenerator;

import java.util.List;

public class BasketRepositoryImpl implements BasketRepository {

    private final BasketDataSource basketDataSource;

    public BasketRepositoryImpl(BasketDataSource basketDataSource) {
        this.basketDataSource = basketDataSource;
    }

    @Override
    public Basket save(Basket basket) {
        basket.setId(IdGenerator.generateBasketId());
        basketDataSource.getBaskets().add(basket);
        return basket;
    }

    @Override
    public List<Basket> getAll() {
        return basketDataSource.getBaskets();
    }

    @Override
    public Basket getById(Integer id) {
        return getAll().stream()
                .filter(x -> id.equals(x.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Basket update(Basket basket) {
        Basket basketForUpdate = getById(basket.getId());
        basketForUpdate.setOrder(basket.getOrder());
        basketForUpdate.setPositions(basket.getPositions());
        basketForUpdate.setPrice(basket.getPrice());
        basketForUpdate.setDiscountByCard(basket.getDiscountByCard());
        basketForUpdate.setTotalPrice(basket.getTotalPrice());
        return basketForUpdate;
    }

    @Override
    public boolean delete(Basket basket) {
        return getAll().remove(basket);
    }

}
