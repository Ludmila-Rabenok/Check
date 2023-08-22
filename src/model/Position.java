package model;

public class Position {

    int id;
    Product product;
    int quantity;
    int discountByPosition;
    int priceByPosition;

    public Position(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Position() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getDiscountByPosition() {
        return discountByPosition;
    }

    public void setDiscountByPosition(Integer discountByPosition) {
        this.discountByPosition = discountByPosition;
    }

    public Integer getPriceByPosition() {
        return priceByPosition;
    }

    public void setPriceByPosition(Integer priceByPosition) {
        this.priceByPosition = priceByPosition;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", discount=" + discountByPosition +
                ", priceForPosition=" + priceByPosition +
                '}';
    }
}
