package repository.impl;

import dataSource.CheckDataSource;
import model.Check;
import repository.CheckRepository;
import util.IdGenerator;

import java.util.List;

public class CheckRepositoryImpl implements CheckRepository {

    private final CheckDataSource checkDataSource;

    public CheckRepositoryImpl(CheckDataSource checkDataSource) {
        this.checkDataSource = checkDataSource;
    }

    @Override
    public Check save(Check check) {
        check.setId(IdGenerator.generateCheckId());
        checkDataSource.getChecks().add(check);
        return check;
    }

    @Override
    public List<Check> getAll() {
        return checkDataSource.getChecks();
    }

    @Override
    public Check getById(Integer id) {
        return getAll().stream()
                .filter(x -> id.equals(x.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Check update(Check check) {
        Check checkForUpdate = getById(check.getId());
        checkForUpdate.setBasket(check.getBasket());
        checkForUpdate.setCashierNumber(check.getCashierNumber());
        checkForUpdate.setAddress(check.getAddress());
        checkForUpdate.setPhoneNumber(check.getPhoneNumber());
        checkForUpdate.setSupermarketNumber(check.getSupermarketNumber());
        checkForUpdate.setDateTime(check.getDateTime());
        return checkForUpdate;
    }

    @Override
    public boolean delete(Check check) {
        return getAll().remove(check);
    }

}
