package dao;

import models.Departments;
import models.Users;

import java.util.List;

public interface UsersDao {

    void add(Users users);

    List<Users> getAll();

    void deleteById(int id);

    void clearAll();

    List<Users> getAllUsersByDepartment(int departmentId);
}
