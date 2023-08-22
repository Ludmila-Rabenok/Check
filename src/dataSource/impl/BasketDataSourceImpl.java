package dataSource.impl;

import dataSource.BasketDataSource;
import model.Basket;

import java.util.ArrayList;
import java.util.List;

public class BasketDataSourceImpl implements BasketDataSource {
   public static List<Basket> baskets = new ArrayList<>();

    @Override
    public List<Basket> getBaskets() {
        return baskets;
    }
}
