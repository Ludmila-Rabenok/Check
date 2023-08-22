package service.impl;

import model.Position;
import model.Product;
import repository.PositionRepository;
import service.PositionService;
import service.ProductService;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;
    private final ProductService productService;
    private static final int AUCTION_DISCOUNT_10_PERCENT = 10;
    private static final int PERCENT_100 = 100;

    public PositionServiceImpl(PositionRepository positionRepository, ProductService productService) {
        this.positionRepository = positionRepository;
        this.productService = productService;
    }

    @Override
    public Position save(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public List<Position> getAll() {
        return positionRepository.getAll();
    }

    @Override
    public Position getById(Integer id) {
        return positionRepository.getById(id);
    }

    @Override
    public Position update(Position position) {
        return positionRepository.update(position);
    }

    @Override
    public boolean delete(Position position) {
        return positionRepository.delete(position);
    }

    @Override
    public Position createPosition(Integer productId, Integer quantity) {
        Product product = productService.getById(productId);
        Position position = new Position(product, quantity);
        position.setDiscountByPosition(countDiscount(product, quantity));
        position.setPriceByPosition(product.getPrice() * quantity - position.getDiscountByPosition());
        return save(position);
    }

    @Override
    public Integer countDiscount(Product product, Integer quantity) {
        if (product.getAuction()) {
            if (quantity > 5) {
                return (product.getPrice() * quantity) * AUCTION_DISCOUNT_10_PERCENT / PERCENT_100;
            }
        }
        return 0;
    }
}
