package models;

import java.util.Objects;

public class Users {
    private int id;
    private String title;
    private String name;
    private String position;
    private String role;
    private int departmentId;

    public Users(String title,String name, String position, String role, int departmentId) {
        this.title = title;
        this.name = name;
        this.position = position;
        this.role = role;
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return getDepartmentId() == users.getDepartmentId() &&
                getName().equals(users.getName()) &&
                getPosition().equals(users.getPosition()) &&
                getRole().equals(users.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition(), getRole(), getDepartmentId());
    }
}
