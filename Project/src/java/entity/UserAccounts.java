/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Quang
 */
public class UserAccounts {
    private int user_id;
    private String username;
    private String password;
    private String address;
    private int phone;
    private int isUser;
    private int isAdmin;

    public UserAccounts() {
    }

    public UserAccounts(int user_id, String username, String password, String address, int phone, int isUser, int isAdmin) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.isUser = isUser;
        this.isAdmin = isAdmin;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getIsUser() {
        return isUser;
    }

    public void setIsUser(int isUser) {
        this.isUser = isUser;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "UserAccounts{" + "user_id=" + user_id + ", username=" + username + ", password=" + password + ", address=" + address + ", phone=" + phone + ", isUser=" + isUser + ", isAdmin=" + isAdmin + '}';
    }
    
}