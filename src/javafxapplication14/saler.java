/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class saler implements Serializable {

    private static final long serialVersionUID=1L;  
    String salername;
    String address;
    int saler_id;
    int phoneno;
    
    public saler() {
        
    }

    public saler(String salername, String address, int saler_id, int phoneno) {
        this.salername = salername;
        this.address = address;
        this.saler_id = saler_id;
        this.phoneno = phoneno;
    }

    public String getSalername() {
        return salername;
    }

    public String getAddress() {
        return address;
    }

    public int getSaler_id() {
        return saler_id;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public void setSalername(String salername) {
        this.salername = salername;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSaler_id(int saler_id) {
        this.saler_id = saler_id;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }
    
    static ArrayList<Cart> orders=new ArrayList<>();
    File read=new File("clothes_list.txt");
    File read1=new File("orders.txt");
    public void additem(int item_id,int item_priceprice,int item_amount,int item_size,String item_type,String item_color,String item_description,ArrayList<clothes>list){
        
            try{
                
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
            clothes c=new clothes(item_id,item_priceprice,item_amount,item_size,item_type,item_color,item_description);
            list.add(c);
            list.trimToSize();
            System.out.println("added successfuly");
            try{
            FileOutputStream out=new FileOutputStream(read);
            ObjectOutputStream oout=new ObjectOutputStream(out);
            oout.writeObject(list);
            oout.close();
            out.close();
            }catch(Exception e){
                System.out.println(e);
            }
        
               }
     
    public void get_amount(ArrayList<clothes>list){
        Scanner x=new Scanner(System.in);
        System.out.println("enter item id :");
        int item_id=x.nextInt();
        try{
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId()==item_id){
                System.out.println("amount ="+list.get(i).getAmount());
            }
        }  
        
    }
   
    public void edit_id(int y,int z,ArrayList<clothes>list){
        try{
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
        for (int i =0 ; i< list.size() ; i++)
            {
                if ((list.get(i).getId()) == y )
                {
                    clothes s2=new clothes(z,list.get(i).getPrice(),list.get(i).getAmount(),list.get(i).getSize(),list.get(i).getType(),list.get(i).getColor(),list.get(i).getDescription());
                    list.set(i, s2);
                    System.out.println("edited successfuly");
                    try{
                        FileOutputStream out=new FileOutputStream(read);
                        ObjectOutputStream oout=new ObjectOutputStream(out);
                        oout.writeObject(list);
                        oout.close();
                        out.close();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    break;
                }
            }
    }
    public void edit_price(int y,int z,ArrayList<clothes>list){
        try{
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
        for (int i =0 ; i< list.size() ; i++)
            {
                if ((list.get(i).getId())==y)
                {
                    
                    clothes s2=new clothes(list.get(i).getId(),z,list.get(i).getAmount(),list.get(i).getSize(),list.get(i).getType(),list.get(i).getColor(),list.get(i).getDescription());
                    list.set(i,s2);
                    System.out.println("edited successfuly");
                    try{
                        FileOutputStream out=new FileOutputStream(read);
                        ObjectOutputStream oout=new ObjectOutputStream(out);
                        oout.writeObject(list);
                        oout.close();
                        out.close();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    break;
                    
                }
            }
    }
    public void edit_type(int y,String z,ArrayList<clothes>list){
        try{
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
        for (int i =0 ; i< list.size() ; i++)
            {
                if ((list.get(i).getId())==y )
                {
                    
                    clothes s2=new clothes(list.get(i).getId(),list.get(i).getPrice(),list.get(i).getAmount(),list.get(i).getSize(),z,list.get(i).getColor(),list.get(i).getDescription());
                    list.set(i, s2);
                    System.out.println("edited successfuly");
                    try{
                        FileOutputStream out=new FileOutputStream(read);
                        ObjectOutputStream oout=new ObjectOutputStream(out);
                        oout.writeObject(list);
                        oout.close();
                        out.close();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    break;
                }
            }
    }
    public void edit_amount(int y,int z,ArrayList<clothes>list){
        try{
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
        for (int i =0 ; i< list.size() ; i++)
            {
                if ( (list.get(i).getId())== y )
                {
                    clothes s2=new clothes(list.get(i).getId(),list.get(i).getPrice(),z,list.get(i).getSize(),list.get(i).getType(),list.get(i).getColor(),list.get(i).getDescription());
                    list.set(i,s2);
                    System.out.println("edited successfuly");
                    try{
                        FileOutputStream out=new FileOutputStream(read);
                        ObjectOutputStream oout=new ObjectOutputStream(out);
                        oout.writeObject(list);
                        oout.close();
                        out.close();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    break;
                }
            }
        
    }
    /*public void edit_item(ArrayList<clothes>list)
    {
        try{
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
        Scanner input = new Scanner(System.in);
        System.out.println("which detail you want to edit ?");
        
        System.out.println("1-id");
        System.out.println("2-price");
        System.out.println("3-amount");
        System.out.println("4-type");
        
        int x =input.nextInt();
         if (x==4)
        {
        System.out.println("Enter id of the item");
        int y = input.nextInt();
        System.out.println("Enter the new type");
        String z = input.next();
        for (int i =0 ; i< list.size() ; i++)
            {
                if ((list.get(i).getId())==y )
                {
                    
                    clothes s2=new clothes(list.get(i).getId(),list.get(i).getPrice(),list.get(i).getAmount(),list.get(i).getSize(),z,list.get(i).getColor(),list.get(i).getDescription());
                    list.set(i, s2);
                    System.out.println("edited successfuly");
                    try{
                        FileOutputStream out=new FileOutputStream(read);
                        ObjectOutputStream oout=new ObjectOutputStream(out);
                        oout.writeObject(list);
                        oout.close();
                        out.close();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    break;
                }
            }
        }
        
        if (x==1)
        {
        System.out.println("Enter the current id");
        int y = input.nextInt();
        System.out.println("Enter the new id");
        int z = input.nextInt();
        for (int i =0 ; i< list.size() ; i++)
            {
                if ((list.get(i).getId()) == y )
                {
                    clothes s2=new clothes(z,list.get(i).getPrice(),list.get(i).getAmount(),list.get(i).getSize(),list.get(i).getType(),list.get(i).getColor(),list.get(i).getDescription());
                    list.set(i, s2);
                    System.out.println("edited successfuly");
                    try{
                        FileOutputStream out=new FileOutputStream(read);
                        ObjectOutputStream oout=new ObjectOutputStream(out);
                        oout.writeObject(list);
                        oout.close();
                        out.close();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    break;
                }
            }
        }
        
        if (x==2)
        {
            System.out.println("Enter the id of the item");
            int a= input.nextInt();
        System.out.println("Enter the new price");
        int z = input.nextInt();
        for (int i =0 ; i< list.size() ; i++)
            {
                if ((list.get(i).getId())==a)
                {
                    
                    clothes s2=new clothes(list.get(i).getId(),z,list.get(i).getAmount(),list.get(i).getSize(),list.get(i).getType(),list.get(i).getColor(),list.get(i).getDescription());
                    list.set(i,s2);
                    System.out.println("edited successfuly");
                    try{
                        FileOutputStream out=new FileOutputStream(read);
                        ObjectOutputStream oout=new ObjectOutputStream(out);
                        oout.writeObject(list);
                        oout.close();
                        out.close();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    break;
                    
                }
            }
        
        }
        
        if (x==3)
        {
         System.out.println("Enter the id of the item");
            int a= input.nextInt();
        System.out.println("Enter the new amount");
        int z = input.nextInt();
        for (int i =0 ; i< list.size() ; i++)
            {
                if ( (list.get(i).getId())== a )
                {
                    clothes s2=new clothes(list.get(i).getId(),list.get(i).getPrice(),z,list.get(i).getSize(),list.get(i).getType(),list.get(i).getColor(),list.get(i).getDescription());
                    list.set(i,s2);
                    System.out.println("edited successfuly");
                    try{
                        FileOutputStream out=new FileOutputStream(read);
                        ObjectOutputStream oout=new ObjectOutputStream(out);
                        oout.writeObject(list);
                        oout.close();
                        out.close();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    break;
                }
            }
        }

        
        
    }*/

    public  void Delete_Item(int key,ArrayList<clothes>list){
        try{
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
        for(int i=0;i<list.size();i++){
            if((list.get(i).getId())==key){
                list.remove(i);
                System.out.println("Deleted successfuly");
                    try{
                        FileOutputStream out=new FileOutputStream(read);
                        ObjectOutputStream oout=new ObjectOutputStream(out);
                        oout.writeObject(list);
                        oout.close();
                        out.close();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                break;
            }
        }
        
         
    }

    public  void sell (ArrayList<clothes>list){
        Scanner x=new Scanner(System.in);
        System.out.println("enter item id :");
        int item_id=x.nextInt();
        System.out.println("enter amount :");
        int item_amount=x.nextInt();
        try{
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
        for(int i=0;i<list.size();i++){
            if (list.get(i).getId()==item_id){
               
                int newamount=(list.get(i).getAmount())-item_amount;
                clothes s2=new clothes(list.get(i).getId(),list.get(i).getPrice(),newamount,list.get(i).getSize(),list.get(i).getType(),list.get(i).getColor(),list.get(i).getDescription());
                list.set(i, s2);
                try{
                        FileOutputStream out=new FileOutputStream(read);
                        ObjectOutputStream oout=new ObjectOutputStream(out);
                        oout.writeObject(list);
                        oout.close();
                        out.close();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                break;
                
            }
           
        }
    }
    public double  co(int price,double per) {
    double nw = (double)price;
    nw = nw - (nw * (per/100));
    return nw;
}
    public  void discount(int item_id,double discount,ArrayList<clothes>list){
        
         try{
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
         for(int i=0;i<list.size();i++){
           if (list.get(i).getId()==item_id){
               double nw=co(list.get(i).getPrice(),discount);
               //int newprice=(list.get(i).getPrice())-((discount/100)*list.get(i).getPrice());
              clothes s2=new clothes(list.get(i).getId(),(int)nw,list.get(i).getAmount(),list.get(i).getSize(),list.get(i).getType(),list.get(i).getColor(),list.get(i).getDescription());
              list.set(i, s2);
              System.out.println("discount added successfuly ");
              try{
                        FileOutputStream out=new FileOutputStream(read);
                        ObjectOutputStream oout=new ObjectOutputStream(out);
                        oout.writeObject(list);
                        oout.close();
                        out.close();
                    }catch(Exception e){
                        System.out.println(e);
                    }
              break;
                   }
         }
        
        
}
}