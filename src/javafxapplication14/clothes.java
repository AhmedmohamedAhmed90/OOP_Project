/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication14;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class clothes implements Serializable{
    private static final long serialVersionUID=1L;
     private int id;
     int price;
     private int amount;
     private int size;
     private String color;
     private String description;
     String type;
     
    static ArrayList<clothes>list=new ArrayList<>();
    
    public clothes(int id, int price, int amount, int size, String type, String color, String description) {
        this.id = id;
        this.price = price;
        this.amount = amount;
        this.size = size;
        this.type = type;
        this.color = color;
        this.description = description;
        
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setSize(int size) {
        this.size = size;
    }

  

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public int getSize() {
        return size;
    }
/*
    public double getReview() {
        Scanner x=new Scanner(System.in);
        System.out.println("enter review :");
        double newreview=x.nextDouble();
        newreview=
        /*double sum =0;
        int counter=0;
        for (int i =0 ; i<reviews.size(); i++)
        {
            
            sum+= reviews.get(i);
            counter++;
            
        }
        review = sum / counter;
        return review;
        
        
    }*/

    @Override
    public String toString() {
        return "clothes{" + "id=" + id + ", price=" + price + ", amount=" + amount + ", size=" + size + ", color=" + color + ", description=" + description +  ", type=" + type + '}';
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }
    
    
   
 
    
    
}