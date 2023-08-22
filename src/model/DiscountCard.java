package model;

public class DiscountCard {

    Integer number;
    Integer percent;

    public DiscountCard(int percent) {
        this.percent = percent;
    }

    public DiscountCard() {}

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }


    @Override
    public String toString() {
        return "DiscountCard{" +
                "number=" + number +
                ", percent=" + percent +
                '}';
    }
}
