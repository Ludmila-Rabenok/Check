package model;

import java.util.Map;
import java.util.Objects;

public class Order {
    private int id;
    private Map<Integer, Integer> productAndQuantityMap;
    private DiscountCard discountCard;

    public Order(OrderBuilder orderBuilder) {
        this.productAndQuantityMap = orderBuilder.productAndQuantityMap;
        this.discountCard = orderBuilder.discountCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DiscountCard getDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(DiscountCard discountCard) {
        this.discountCard = discountCard;
    }

    public Map<Integer, Integer> getProductAndQuantityMap() {
        return productAndQuantityMap;
    }

    public void setProductAndQuantityMap(Map<Integer, Integer> productAndQuantityMap) {
        this.productAndQuantityMap = productAndQuantityMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order1 = (Order) o;
        return getId() == order1.getId() &&
                Objects.equals(getProductAndQuantityMap(), order1.getProductAndQuantityMap()) &&
                Objects.equals(getDiscountCard(), order1.getDiscountCard());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProductAndQuantityMap(), getDiscountCard());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order=" + productAndQuantityMap +
                ", discountCard=" + discountCard +
                '}';
    }
}
