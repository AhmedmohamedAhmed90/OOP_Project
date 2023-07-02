/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication14;

import java.util.ArrayList;


public class Cart extends clothes{
  String username;

    @Override
    public String toString() {
        return "Cart{" + "username=" + username + super.toString()+'}';
    }

    

    public Cart(String username, int id, int price , int amount, int size, String type, String color, String description) {
        super(id,price, amount, size, type, color, description);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }
    

}
