package service.impl;

import model.Basket;
import model.Check;
import repository.CheckRepository;
import service.CheckService;
import util.PropertiesHandler;

import java.time.LocalDateTime;
import java.util.List;

public class CheckServiceImpl implements CheckService {
    private final CheckRepository checkRepository;
    private static final String CHECK_SUPERMARKET = "check.supermarket";
    private static final String CHECK_PHONE = "check.phone";
    private static final String CHECK_ADDRESS = "check.address";
    private static final String CHECK_CASHIER = "check.cashier";

    public CheckServiceImpl(CheckRepository checkRepository) {
        this.checkRepository = checkRepository;
    }

    @Override
    public Check save(Check check) {
        return checkRepository.save(check);
    }

    @Override
    public List<Check> getAll() {
        return checkRepository.getAll();
    }

    @Override
    public Check getById(Integer id) {
        return checkRepository.getById(id);
    }

    @Override
    public Check update(Check check) {
        return checkRepository.update(check);
    }

    @Override
    public boolean delete(Check check) {
        return checkRepository.delete(check);
    }

    @Override
    public Check createCheck(Basket basket) {
        Check check = new Check(basket);
        check.setSupermarketNumber(PropertiesHandler.getProperty(CHECK_SUPERMARKET));
        check.setPhoneNumber(PropertiesHandler.getProperty(CHECK_PHONE));
        check.setAddress(PropertiesHandler.getProperty(CHECK_ADDRESS));
        check.setCashierNumber(PropertiesHandler.getProperty(CHECK_CASHIER));
        check.setDateTime(LocalDateTime.now());
        return save(check);
    }
}
