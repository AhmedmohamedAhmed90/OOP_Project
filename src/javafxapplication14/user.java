/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author abdelrahman
 */
public class user implements Serializable{
    private static final long serialVersionUID=1L;
     String username;
     String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public user() {
        
    }
    public user(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "user{" + "cartlist=" + cartlist + '}';
    }

    

   
    
    static ArrayList<Cart> cartlist=new ArrayList<>();
    File read=new File("clothes_list.txt");
    File readord=new File("orders.txt");
    File filecart=new File("cart.txt");
    
    void display(ArrayList<clothes>list){
        
        Scanner input = new Scanner(System.in);
        System.out.println("which item you want to display ?");
        System.out.println("1-T-shirts");
        System.out.println("2-pants");
        System.out.println("3-shoes");
        int x =input.nextInt();
     
        try{
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
        
        
         if(x==1){
             for(int f=0;f<list.size();f++){
               
                 if((list.get(f).getType()).equals("T-shirt")){
                     
                     if((list.get(f).getAmount())!=0){
                          System.out.println("_____________________________________________________________________");
                     System.out.println("the id is "+(list.get(f).getId()));
                     System.out.println("the description is "+(list.get(f).getDescription()));
                     System.out.println("the color is "+(list.get(f).getColor()));
                     System.out.println("the size is "+(list.get(f).getSize()));
                     System.out.println("the price is "+(list.get(f).getPrice()));
                     System.out.println("the amount is "+(list.get(f).getAmount()));
                     
                     System.out.println("_____________________________________________________________________");
                        }
                 }
             }
         }
          if(x==2){
             for(int f=0;f<list.size();f++){
                 if((list.get(f).getType()).equals("pant")){
                     if((list.get(f).getAmount())!=0){
                    System.out.println("_____________________________________________________________________");
                     System.out.println("the id is "+(list.get(f).getType()));
                     System.out.println("the description is "+(list.get(f).getType()));
                     System.out.println("the color is "+(list.get(f).getColor()));
                     System.out.println("the size is "+(list.get(f).getSize()));
                     System.out.println("the price is "+(list.get(f).getPrice()));
                     System.out.println("the amount is "+(list.get(f).getPrice()));
                    
                     
                     System.out.println("_____________________________________________________________________");
                     
                        }
                 }
             }
         }
           if(x==3){
             for(int f=0;f<list.size();f++){
                 if((list.get(f).getType()).equals("shoes")){
                     if((list.get(f).getAmount())!=0){
                         System.out.println("_____________________________________________________________________");
                     System.out.println("the id is "+(list.get(f).getId()));
                     System.out.println("the description is "+(list.get(f).getDescription()));
                     System.out.println("the color is "+(list.get(f).getColor()));
                     System.out.println("the size is "+(list.get(f).getSize()));
                     System.out.println("the price is "+(list.get(f).getPrice()));
                     System.out.println("the amount is "+(list.get(f).getAmount()));
                      
                     
                         System.out.println("_____________________________________________________________________");
                     }
                 }
             }
         }
         
         
         
    }

    
    
    /* public void add_review(ArrayList<clothes>list)
    {
        Scanner input = new Scanner(System.in);

        try{
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
        System.out.println("Enter the id of the item");
        int y= input.nextInt();

        for (int i =0 ; i <list.size() ; i++)
        {

            if ((list.get(i).id) ==y)
            {


                System.out.println("Rate the item out of 10 please");
                double z = input.nextDouble();
                while (z>10|| z<0){
                     System.out.println("Enter another value");
                     z=input.nextDouble();
               }
                         
                    list.get(i).reviews.add(z) ;
                    list.get(i).reviews.trimToSize();
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
        }

        }*/
        public int search(String name,String type,String color,int size,ArrayList<clothes>list)
        {
            try{
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
            int ii=-1;
            for (int i =0 ; i< list.size() ; i++)
            {
                if (list.get(i).getDescription().equals(name))
                {
                    
                    if (list.get(i).getType().equals(type))
                    {
                    
                    if (list.get(i).getColor().equals(color))
                    {
                        
                    {
                        if(list.get(i).getSize() ==size)
                        {
                            System.out.println("item has been found , id is : "+list.get(i).getId() +"  The price is : " + list.get(i).getPrice() +"  The amount is : " +list.get(i).getAmount());
                            ii=list.get(i).getId();
                            break;
                        }
                    }
                    }
                }
            }
        
    
   
    
    
            }
            return ii;
        }
        
        public void add_cart(String username,int item_id,int amount ,ArrayList<clothes>list){
            try{
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
            try{
            FileInputStream input1 = new FileInputStream(filecart);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            cartlist=(ArrayList<Cart>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
            for(int i=0;i<list.size();i++){
                if (item_id==list.get(i).getId()){
                    Cart c=new Cart(username,list.get(i).getId(),list.get(i).getPrice(),amount,list.get(i).price,list.get(i).getType(),list.get(i).getColor(),list.get(i).getDescription());
                    cartlist.add(c);
                    try{
                        FileOutputStream out=new FileOutputStream(filecart);
                        ObjectOutputStream oout=new ObjectOutputStream(out);
                        oout.writeObject(cartlist);
                        oout.close();
                        out.close();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                
               
            }
                  
            }
        }
        public int totalpri(String usernam){
            int tot=0;
            
            try{
            FileInputStream input1 = new FileInputStream(filecart);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            cartlist=(ArrayList<Cart>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
            
            for(int i=0;i<cartlist.size();i++){
                if(usernam.equals(cartlist.get(i).username)){
                    tot+=cartlist.get(i).price*cartlist.get(i).getAmount();
                }else{
                    
                }
            }
            return tot;
        }
        public void PlaceOrder(boolean in,String usernam,ArrayList<clothes>list) throws IOException{
            //readord.createNewFile();
            try{
            FileInputStream input1 = new FileInputStream(readord);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            saler.orders=(ArrayList<Cart>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
            
            try{
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
            try{
            FileInputStream input1 = new FileInputStream(filecart);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            cartlist=(ArrayList<Cart>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
            if(in){

            for(int i=0;i<cartlist.size();i++){
                if(usernam.equals(cartlist.get(i).username)){
                    int v=cartlist.get(i).getId();
                    for(int z=0;z<list.size();z++){
                        if(v==list.get(z).getId()){
                            //totalprice+=(cartlist.get(i).price);
                            if(in){
                        
                        int newamount=(list.get(z).getAmount())-(cartlist.get(i).getAmount());
                        clothes s2=new clothes(list.get(z).getId(),list.get(z).getPrice(),newamount,list.get(z).getSize(),list.get(z).getType(),list.get(z).getColor(),list.get(z).getDescription());
                        list.set(z, s2);
                        //for(int c=0;c<cartlist.size();c++){
                          //  if(cartlist.get(c).username.equals(usernam)){
                                    saler.orders.add(cartlist.get(i));
                                    cartlist.remove(i);
                            //}
                        //}
                        try{
                         FileOutputStream out=new FileOutputStream(read);
                         ObjectOutputStream oout=new ObjectOutputStream(out);
                         oout.writeObject(list);
                         oout.close();
                         out.close();
                        }catch(Exception e){
                            System.out.println(e);
                        }try{
                         FileOutputStream out=new FileOutputStream(filecart);
                         ObjectOutputStream oout=new ObjectOutputStream(out);
                         oout.writeObject(cartlist);
                         oout.close();
                         out.close();
                        }catch(Exception e){
                            System.out.println(e);
                        }}try{
                         FileOutputStream out=new FileOutputStream(readord);
                         ObjectOutputStream oout=new ObjectOutputStream(out);
                         oout.writeObject(saler.orders);
                         oout.close();
                         out.close();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                        
                        System.out.println("order successfully");
                        
                    }}}}}else{
                        for(int c=0;c<cartlist.size();c++){
                            if(cartlist.get(c).username.equals(usernam)){
                                    cartlist.remove(c);
                            }
                            
                        }
                        try{
                         FileOutputStream out=new FileOutputStream(filecart);
                         ObjectOutputStream oout=new ObjectOutputStream(out);
                         oout.writeObject(cartlist);
                         oout.close();
                         out.close();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                        System.out.println("done cancelation");
                        
                        //break;
        
                    }
        }
            
        
        
            //System.out.println(this.cartlist.get(0));
            
        
        public void restore_item(String name,ArrayList<clothes>list){
            Scanner x=new Scanner(System.in);
            System.out.println(" Enter item id :");
            int item_id=x.nextInt();
            System.out.println(" Enter item amount :");
            int amount1=x.nextInt();
            try{
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
            try{
            FileInputStream input1 = new FileInputStream(filecart);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            cartlist=(ArrayList<Cart>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
            for(int i=0;i<cartlist.size();i++){
                if(item_id==(cartlist.get(i).getId())){
                    int newamount=(list.get(i).getAmount())+amount1;
                    clothes s2=new clothes(cartlist.get(i).getId(),cartlist.get(i).getPrice(),newamount,cartlist.get(i).getSize(),cartlist.get(i).getType(),cartlist.get(i).getColor(),cartlist.get(i).getDescription());
                    list.set(i, s2);
                    Cart c=new Cart(name,cartlist.get(i).getId(),cartlist.get(i).getPrice(),newamount,cartlist.get(i).getSize(),cartlist.get(i).getType(),cartlist.get(i).getColor(),cartlist.get(i).getDescription());
                    cartlist.set(i, c);
                    try{
                        FileOutputStream out=new FileOutputStream(filecart);
                        ObjectOutputStream oout=new ObjectOutputStream(out);
                        oout.writeObject(cartlist);
                        oout.close();
                        out.close();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    try{
                        FileOutputStream out=new FileOutputStream(read);
                        ObjectOutputStream oout=new ObjectOutputStream(out);
                        oout.writeObject(list);
                        oout.close();
                        out.close();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    System.out.println("restored successfully");
                    break;
                }
            }
            
        }
}
/*
public void PlaceOrder(String usernam,ArrayList<clothes>list){
            Scanner x=new Scanner(System.in);
            try{
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
            try{
            FileInputStream input1 = new FileInputStream(filecart);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            cartlist=(ArrayList<Cart>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
            for(int i=0;i<cartlist.size();i++){
                if(usernam.equals(cartlist.get(i).username)){
                    for(int f=0;f<cartlist.size();f++){
                     if((cartlist.get(f).getAmount())!=0){
                         System.out.println("_________");
                     System.out.println("the id is "+(cartlist.get(f).getId()));
                     System.out.println("the description is "+(cartlist.get(f).getDescription()));
                     System.out.println("the color is "+(cartlist.get(f).getColor()));
                     System.out.println("the size is "+(cartlist.get(f).getSize()));
                     System.out.println("the price is "+(cartlist.get(f).getPrice()));
                     System.out.println("the amount is "+(cartlist.get(f).getAmount()));
                     
                     
                     System.out.println("_________");
                        }
                 }
                    System.out.println("enter 1 to confirm the order :");
                    System.out.println("enter 2 to cancel the order :");
                    int in=x.nextInt();
                    if(in==1){
                        
                        int newamount=(list.get(i).getAmount())-(cartlist.get(i).getAmount());
                        clothes s2=new clothes(list.get(i).getId(),list.get(i).getPrice(),newamount,list.get(i).getSize(),list.get(i).getType(),list.get(i).getColor(),list.get(i).getDescription());
                        list.set(i, s2);
                        for(int c=0;c<cartlist.size();c++){
                            if(cartlist.get(c).username.equals(usernam)){
                                    cartlist.remove(c);
                            }
                        }
                        try{
                         FileOutputStream out=new FileOutputStream(read);
                         ObjectOutputStream oout=new ObjectOutputStream(out);
                         oout.writeObject(list);
                         oout.close();
                         out.close();
                        }catch(Exception e){
                            System.out.println(e);
                        }try{
                         FileOutputStream out=new FileOutputStream(filecart);
                         ObjectOutputStream oout=new ObjectOutputStream(out);
                         oout.writeObject(cartlist);
                         oout.close();
                         out.close();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                        System.out.println("order successfully");
                        
                    }if(in==2){
                        System.out.println("done cancelation");
                        break;
                    }
                }
            }


*/