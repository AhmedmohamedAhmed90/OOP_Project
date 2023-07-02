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

/**
 *
 * @author dell
 */
public class login implements Serializable{
    private static final long serialVersionUID= 1L;
    File re=new File("relist.txt");
    
    
    public int log(String Filename,String uname,String pass) {
        final String empname="admin";
        final String password="admin";
        int result=0;
        boolean found1 = false;
        Scanner input=new Scanner(System.in);
        try{
       while(found1==false){
           if(uname.equals(empname)&& pass.equals(password)){
                found1 = true;
                result = 1;
                System.out.println("Login successfully");
           }
           
        ArrayList<user> list= new ArrayList<>();
        FileInputStream input1=new FileInputStream(re);
        ObjectInputStream oinput=new ObjectInputStream(input1);
        list=(ArrayList<user>)oinput.readObject();
        
       for(int i=0;i<list.size();i++){
           
            if (list.get(i).getUsername().equals(uname)&&(list.get(i).getPassword().equals(pass)))
            {
                found1 = true;
                oinput.close();
                result=2;
                System.out.println("Login successfully");
            }
            }
            if(!found1) {
            System.out.println("Wrong ID and password please enter again");
            oinput.close();
            result =-1;
            break;
            }
        }}catch(Exception e){
            System.out.println(e);
        }
       return result;
    }
    
    
    
    public  void register(String uname,String pass) throws IOException, ClassNotFoundException{
        File re=new File("relist.txt");
        ArrayList<user> relist=new ArrayList<>();
        user s=new user(uname,pass);
        try{
        FileInputStream input1=new FileInputStream(re);
        ObjectInputStream oinput=new ObjectInputStream(input1);
        relist=(ArrayList<user>)oinput.readObject();
        }catch(Exception e){
            System.out.println(e);
        }
        relist.add(s);
        try{
        FileOutputStream out=new FileOutputStream(re);
        ObjectOutputStream oout=new ObjectOutputStream(out);
        oout.writeObject(relist);
        oout.close();
        out.close();
        }catch(Exception e){
            System.out.println(e);
           
        }
        
    }
    /*
    public  void Delete_Item(){
        ArrayList<user> relist=new ArrayList<>();
        Scanner x=new Scanner(System.in);
        System.out.println("enter id :");
        String key=x.next();
        try{
            FileInputStream input1 = new FileInputStream(re);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            relist=(ArrayList<user>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
        for(int i=0;i<relist.size();i++){
            if((relist.get(i).getUsername()).equals(key)){
                relist.remove(i);
                    try{
                        FileOutputStream out=new FileOutputStream(re);
                        ObjectOutputStream oout=new ObjectOutputStream(out);
                        oout.writeObject(relist);
                        oout.close();
                        out.close();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                break;
            }
        }
        
         
    }
*/
    @Override
    public String toString() {
        return "login{" + "re=" + re + '}';
    }
}
