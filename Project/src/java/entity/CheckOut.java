/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Quang
 */
public class CheckOut {

    private String username;
    private String address;
    private int phone;
    private String product_name;
    private int product_id;
    private String img;
    private int status;
    private double price;
    private String order_date;
    private int order_id;
    private int quantity;
    private double unit_price;
    private double Total;

    public CheckOut() {
    }

    public CheckOut(String username, String address, int phone, String product_name, int product_id, String img, int status, double price, String order_date, int order_id, int quantity, double unit_price, double Total) {
        this.username = username;
        this.address = address;
        this.phone = phone;
        this.product_name = product_name;
        this.product_id = product_id;
        this.img = img;
        this.status = status;
        this.price = price;
        this.order_date = order_date;
        this.order_id = order_id;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.Total = Total;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    @Override
    public String toString() {
        return "CheckOut{" + "username=" + username + ", address=" + address + ", phone=" + phone + ", product_name=" + product_name + ", product_id=" + product_id + ", img=" + img + ", status=" + status + ", price=" + price + ", order_date=" + order_date + ", order_id=" + order_id + ", quantity=" + quantity + ", unit_price=" + unit_price + ", Total=" + Total + '}';
    }

}
