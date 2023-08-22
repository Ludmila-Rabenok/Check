import dataSource.*;
import dataSource.impl.*;
import repository.*;
import repository.impl.*;
import service.*;
import service.impl.*;

public class Main {
    public static void main(String[] args) {

        DiscountCardDataSource discountCardDataSource = new DiscountCardDataSourceImpl();
        DiscountCardRepository discountCardRepository = new DiscountCardRepositoryImpl(discountCardDataSource);
        DiscountCardService discountCardService = new DiscountCardServiceImpl(discountCardRepository);

        OrderDataSource orderDataSource = new OrderDataSourceImpl();
        OrderRepository orderRepository = new OrderRepositoryImpl(orderDataSource);
        OrderService orderService = new OrderServiceImpl(orderRepository, discountCardService);

        ProductDataSource productDataSource = new ProductDataSourceImpl();
        ProductRepository productRepository = new ProductRepositoryImpl(productDataSource);
        ProductService productService = new ProductServiceImpl(productRepository);

        PositionDataSource positionDataSource = new PositionDataSourceImpl();
        PositionRepository positionRepository = new PositionRepositoryImpl(positionDataSource);
        PositionService positionService = new PositionServiceImpl(positionRepository, productService);

        BasketDataSource basketDataSource = new BasketDataSourceImpl();
        BasketRepository basketRepository = new BasketRepositoryImpl(basketDataSource);
        BasketService basketService = new BasketServiceImpl(basketRepository, positionService);

        CheckDataSource checkDataSource = new CheckDataSourceImpl();
        CheckRepository checkRepository = new CheckRepositoryImpl(checkDataSource);
        CheckService checkService = new CheckServiceImpl(checkRepository);

        PrintCheckService printCheckService = new PrintCheckServiceImpl();

        printCheckService.exportCheckToFile(checkService.createCheck(basketService.createBasket
                (orderService.createOrderFromArgsInFile(args[0]))));
    }
}
