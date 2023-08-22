package model;

public class Product {

    int id;
    String name;
    Integer price;
    Boolean auction;

    public Product(String name, Integer price, Boolean auction) {
        this.name = name;
        this.price = price;
        this.auction = auction;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getAuction() {
        return auction;
    }

    public void setAuction(Boolean auction) {
        this.auction = auction;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", auction=" + auction +
                '}';
    }
}
