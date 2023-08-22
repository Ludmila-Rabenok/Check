package util;

public class IdGenerator {
    private static Integer orderId = 1;
    private static Integer basketId = 1;
    private static Integer positionId = 1;
    private static Integer productId = 1;
    private static Integer discountCardId = 1000;
    private static Integer checkId = 1;

    public static Integer generateOrderId() {
        return orderId++;
    }

    public static Integer generateBasketId() {
        return basketId++;
    }

    public static Integer generatePositionId() {
        return positionId++;
    }

    public static Integer generateProductId() {
        return productId++;
    }

    public static Integer generateDiscountCardId() {
        return discountCardId++;
    }

    public static Integer generateCheckId() {
        return checkId++;
    }

}
