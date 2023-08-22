package model;

import java.util.List;
import java.util.Objects;

public class Basket {

    private int id;
    private Order order;
    private List<Position> positions;
    private Integer price;
    private Integer discountByCard;
    private Integer totalPrice;

    public Basket(BasketBuilder basketBuilder) {
        this.order = basketBuilder.order;
        this.positions = basketBuilder.positions;
        this.price = basketBuilder.price;
        this.discountByCard = basketBuilder.discountByCard;
        this.totalPrice = basketBuilder.totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscountByCard() {
        return discountByCard;
    }

    public void setDiscountByCard(Integer discountByCard) {
        this.discountByCard = discountByCard;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return getId() == basket.getId() &&
                Objects.equals(getOrder(), basket.getOrder()) &&
                Objects.equals(getPositions(), basket.getPositions()) &&
                Objects.equals(getPrice(), basket.getPrice()) &&
                Objects.equals(getDiscountByCard(), basket.getDiscountByCard()) &&
                Objects.equals(getTotalPrice(), basket.getTotalPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOrder(), getPositions(), getPrice(), getDiscountByCard(), getTotalPrice());
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", order=" + order +
                ", positions=" + positions +
                ", price=" + price +
                ", discountByCard=" + discountByCard +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
