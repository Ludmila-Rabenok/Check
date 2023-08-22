package service;

import model.Basket;
import model.Check;

import java.util.List;

public interface CheckService {
    Check save(Check check);

    List<Check> getAll();

    Check getById(Integer id);

    Check update(Check check);

    boolean delete(Check check);

    Check createCheck(Basket basket);

   // void printCheck(Check check);
}
