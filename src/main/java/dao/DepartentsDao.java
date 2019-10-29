package dao;

import models.Departments;

import java.util.List;

public interface DepartentsDao {

    void add (Departments departments);

    List<Departments> getAll();

    void update(int id, String name, String description, int numberOfEmployees);

    void deleteById(int id);

    void clearAll();

}
