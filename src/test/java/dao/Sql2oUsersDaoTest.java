package dao;


import models.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;

public class Sql2oUsersDaoTest {


    private Connection conn;
    private  Sql2oUsersDao usersDao;
    private Sql2oDepartments departmentsDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/organisational_api_test";
        Sql2o  sql2o = new Sql2o(connectionString, "moringaschool", "pwd");
        usersDao = new Sql2oUsersDao(sql2o);
        departmentsDao = new Sql2oDepartments(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        usersDao.clearAll();
        departmentsDao.clearAll();
        conn.close();
    }

    @Test
    public void addingUserSetsId() throws Exception {
            Users newUser = newUsers();
            assertEquals(1, newUser.getId());
    }

    //helpers
    public Users newUsers(){
        Users newUser = new Users("Mr", "Dreamer", "Dre", "Dreams", 1);
        usersDao.add(newUser);
        return newUser;
    }

}