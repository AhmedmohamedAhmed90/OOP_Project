/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import static javafxapplication14.user.cartlist;


public class payment implements Serializable {
private static final long serialVersionUID=1L;

    private String username;
    private int userwallet;
    static ArrayList<payment> lp=new ArrayList<>();
    public payment(){}
    public payment(String usernam) {
        this.username = usernam;
        this.userwallet=0;
    }
    public payment(String usname,int wa){
        this.username=usname;
        this.userwallet=wa;
    }
    
    public void addtowallet(String us,int amount,ArrayList<payment>llp)
    {
        try{
            FileInputStream input1 = new FileInputStream("walletamount.txt");
            ObjectInputStream oinput=new ObjectInputStream(input1);
            llp=(ArrayList<payment>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
        for(int i=0;i<llp.size();i++){
            if(llp.get(i).username.equals(us)){
                int nw=llp.get(i).userwallet + amount;
                payment c=new payment(us,nw);
                llp.set(i, c);
               // llp.get(i).userwallet=llp.get(i).userwallet+amount;
            }
        }
        try{
            FileOutputStream out=new FileOutputStream("walletamount.txt");
            ObjectOutputStream oout=new ObjectOutputStream(out);
            oout.writeObject(llp);
            oout.close();
            out.close();
           }catch(Exception e){
               System.out.println(e);
           }
    }
    public  boolean paywithwallet (String us,int total,ArrayList<payment>llp) throws FileNotFoundException
    {
        try{
            FileInputStream input1 = new FileInputStream("walletamount.txt");
            ObjectInputStream oinput=new ObjectInputStream(input1);
            llp=(ArrayList<payment>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
        Boolean r=false;
        for(int i=0;i<llp.size();i++){
            if(llp.get(i).username.equals(us)){
                int h=llp.get(i).userwallet;
                if(h>total){
                    int nw=llp.get(i).userwallet-total;
                    payment c=new payment(us,nw);
                    llp.set(i, c);
                    r= true;
                }
                else{
                    r= false;
                }
            }
        }
        try{
            FileOutputStream out=new FileOutputStream("walletamount.txt");
            ObjectOutputStream oout=new ObjectOutputStream(out);
            oout.writeObject(llp);
            oout.close();
            out.close();
           }catch(Exception e){
               System.out.println(e);
           }
        return r;
    }
    /*public void wirtetofile () throws FileNotFoundException, IOException
    {
        try{
            FileOutputStream out=new FileOutputStream("walletamount.txt");
            ObjectOutputStream oout=new ObjectOutputStream(out);
            oout.writeObject(lp);
            oout.close();
            out.close();
           }catch(Exception e){
               System.out.println(e);
           }
        
    }
    public void readformfile() throws FileNotFoundException
    {
        try{
            FileInputStream input1 = new FileInputStream("walletamount.txt");
            ObjectInputStream oinput=new ObjectInputStream(input1);
            lp=(ArrayList<payment>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
    }*/

    public int getUserwallet(String us,ArrayList<payment>llp) {
        try{
            FileInputStream input1 = new FileInputStream("walletamount.txt");
            ObjectInputStream oinput=new ObjectInputStream(input1);
            llp=(ArrayList<payment>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
        int userwa=0;
       for(int i=0;i<llp.size();i++){
            if(llp.get(i).username.equals(us)){
                userwa=llp.get(i).userwallet;
                break;
            }}
        
        return userwa;
    }
    
}