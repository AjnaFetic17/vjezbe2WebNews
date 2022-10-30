/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author XY
 */
public class User {

  
    protected int userID;
    protected String username;
    protected String password;
    protected String email;
    protected String status;
    protected int roleID;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public User(int userID, String username, String password, String email, String status, int roleID) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.status = status;
        this.roleID = roleID;
    }

    public User(int userID, String username) {
        this.userID = userID;
        this.username = username;
    }

}
