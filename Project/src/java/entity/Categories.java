/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Quang
 */
public class Categories {
    private int category_id;
    private String category_name;

    public Categories() {
    }

    public Categories(int category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
    }
    
    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Categories{" + "category_id=" + category_id + ", category_name=" + category_name + '}';
    }
    
}
