/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Quang
 */
public class Products {
    private int product_id;
    private String product_name;
    private String img;
    private String description;
    private double price;
    private int stock_quantity;
    private int category_id;

    public Products() {
    }

    public Products(int product_id, String product_name, String img, String description, double price, int stock_quantity, int category_id) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.img = img;
        this.description = description;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.category_id = category_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Products{" + "product_id=" + product_id + ", product_name=" + product_name + ", img=" + img + ", description=" + description + ", price=" + price + ", stock_quantity=" + stock_quantity + ", category_id=" + category_id + '}';
    }
    
}

