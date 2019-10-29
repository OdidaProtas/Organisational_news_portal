import com.google.gson.Gson;
import dao.Sql2oDepartments;
import dao.Sql2oNews;
import dao.Sql2oUsersDao;
import models.Departments;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;

public class App {

    public  static void main(String[] args){
        Sql2oDepartments departmentDao;
        Sql2oUsersDao usersDao;
        Sql2oNews newsDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        departmentDao = new Sql2oDepartments(sql2o);
        usersDao = new Sql2oUsersDao(sql2o);
        newsDao = new Sql2oNews(sql2o);

        post("departments/new", "application/json", (req, res)->{
            Departments department = gson.fromJson(req.body(), Departments.class);
            departmentDao.add(department);
            res.status(201);
            res.type("application/json");
            return gson.toJson(department);
        });

        get("/departments", "application/json", (req, res)->{
            res.type("application/json");
            return gson.toJson(departmentDao.getAll());
        });

        get("departments/:id", "application/json", (req, res)->{
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return  gson.toJson(departmentDao.findById(departmentId));
        });
    }
}
