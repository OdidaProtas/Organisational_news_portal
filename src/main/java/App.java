import com.google.gson.Gson;
import dao.Sql2oDepartments;
import dao.Sql2oNews;
import dao.Sql2oUsersDao;
import models.Departments;
import models.News;
import models.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.net.URI;

import static spark.Spark.*;

public class App {
    private static URI dbUri;
    private static String dblink = "jdbc:postgresql://localhost:5432/organisational_api";
    static Logger logger = LoggerFactory.getLogger(App.class);

    public  static void main(String[] args){

        Sql2oDepartments departmentDao;
        Sql2oUsersDao usersDao;
        Sql2oNews newsDao;
        Connection conn;
        Gson gson = new Gson();


        String connectionString = "jdbc:postgresql://localhost:5432/organisational_api";
        Sql2o sql2o = new Sql2o(connectionString, "moringaschool", "pwd");

        departmentDao = new Sql2oDepartments(sql2o);
        usersDao = new Sql2oUsersDao(sql2o);
        newsDao = new Sql2oNews(sql2o);


        ProcessBuilder process = new ProcessBuilder();
        int port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);



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


//        after((res, req)->{
//            res.type("application/json");
//        });

        post("/departments/:departmentId/news/new", "application/json", (req, res)->{
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("departmentId"));
            News news = gson.fromJson(req.body(), News.class);
            news.setDepartmentId(departmentId);
            newsDao.add(news);
            res.status(201);
            res.type("application/json");
            return  gson.toJson(news);
        });

        get("news","application/json", (req, res)->{
            res.type("application/json");
            return  gson.toJson(newsDao.getAll());
        });

        get("departments/:departmentId/news", "application/json", (req, res)->{
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("departmentId"));
            res.type("application/json");
            return gson.toJson(newsDao.getAllNewsByDepartment(departmentId));
        });

        get("departments/:departmentId/users", "application/json", (req, res)->{
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("departmentId"));
            res.type("application/json");
            return gson.toJson(usersDao.getAllUsersByDepartment(departmentId));
        });

        post("users/new", "application/json", (req, res)->{
            Users newuser = gson.fromJson(req.body(), Users.class);
            usersDao.add(newuser);
            res.status(201);
            return  gson.toJson(newuser);
        });

        post("departments/:departmentId/users/new", "application/json", (req, res) ->{
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("departmentId"));
            Users newUser = gson.fromJson(req.body(), Users.class);
            newUser.setDepartmentId(departmentId);
            usersDao.add(newUser);
            res.status(201);
            res.type("application/json");
            return gson.toJson(newUser);
        });

        get("/departments/:id/usersbyDept", "application/json", (req, res)->{
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("id"));
            Departments departmentToFind = departmentDao.findById(departmentId);
            if (departmentToFind == null){
                throw new  Exception();
            }
            else if(departmentDao.findById(departmentId).getId()== 0){

                return "{\"message\":\"I'm sorry, but no users listed in this department.\"}";

            }
            else{
                return  gson.toJson(departmentDao.getAllUsersForDepartments(departmentId));
            }
        });

    }
}
