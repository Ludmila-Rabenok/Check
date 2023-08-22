package model;

import java.util.List;

public class BasketBuilder {
    Order order;
    List<Position> positions;
    Integer price;
    Integer discountByCard;
    Integer totalPrice;

    public BasketBuilder(Order order) {
        this.order = order;
    }

    public BasketBuilder setOrder(Order order) {
        this.order = order;
        return this;
    }

    public BasketBuilder setPositions(List<Position> positions) {
        this.positions = positions;
        return this;
    }

    public BasketBuilder setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public BasketBuilder setDiscountByCard(Integer discountByCard) {
        this.discountByCard = discountByCard;
        return this;
    }

    public BasketBuilder setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public Basket build() {
        return new Basket(this);
    }
}
