package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Check {

    int id;
    String supermarketNumber;
    String address;
    String phoneNumber;
    String cashierNumber;
    LocalDateTime dateTime;
    Basket basket;

    public Check(Basket basket) {
        this.basket = basket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupermarketNumber() {
        return supermarketNumber;
    }

    public void setSupermarketNumber(String supermarketNumber) {
        this.supermarketNumber = supermarketNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCashierNumber() {
        return cashierNumber;
    }

    public void setCashierNumber(String cashierNumber) {
        this.cashierNumber = cashierNumber;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return getId() == check.getId() &&
                Objects.equals(getSupermarketNumber(), check.getSupermarketNumber()) &&
                Objects.equals(getAddress(), check.getAddress()) &&
                Objects.equals(getPhoneNumber(), check.getPhoneNumber()) &&
                Objects.equals(getCashierNumber(), check.getCashierNumber()) &&
                Objects.equals(getDateTime(), check.getDateTime()) &&
                Objects.equals(getBasket(), check.getBasket());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSupermarketNumber(), getAddress(), getPhoneNumber(), getCashierNumber(), getDateTime(), getBasket());
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", supermarketNumber='" + supermarketNumber + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cashierNumber='" + cashierNumber + '\'' +
                ", dateTime=" + dateTime +
                ", basket=" + basket +
                '}';
    }
}
