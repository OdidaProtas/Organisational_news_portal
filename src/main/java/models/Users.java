package models;

import java.util.Objects;

public class Users {
    private int id;
    private String title;
    private String userName;
    private String position;
    private String userRole;
    private int departmentId;

    public Users(String title,String name, String position, String userRole, int departmentId) {
        this.title = title;
        this.userName = userRole;
        this.position = position;
        this.userRole = userRole;
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return getDepartmentId() == users.getDepartmentId() &&
                getTitle().equals(users.getTitle()) &&
                getUserName().equals(users.getUserName()) &&
                getPosition().equals(users.getPosition()) &&
                getUserRole().equals(users.getUserRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getUserName(), getPosition(), getUserRole(), getDepartmentId());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRole() {
        return userRole;
    }

    public void setRole(String role) {
        this.userRole = role;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

}
