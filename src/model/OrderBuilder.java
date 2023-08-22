package model;

import java.util.Map;

public class OrderBuilder {
    Map<Integer, Integer> productAndQuantityMap;
    DiscountCard discountCard;

    public OrderBuilder() {
    }

    public OrderBuilder setProductAndQuantityMap(Map<Integer, Integer> productAndQuantityMap) {
        this.productAndQuantityMap = productAndQuantityMap;
        return this;
    }

    public OrderBuilder setDiscountCard(DiscountCard discountCard) {
        this.discountCard = discountCard;
        return this;
    }

    public Order build() {
        return new Order(this);
    }
}
