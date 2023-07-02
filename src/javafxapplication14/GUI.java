/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication14;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI {
    public static Scene scene2;
    public static TextField f1;
    GUI(){  
        }
    
    public static Scene Reg(){
        Button btn = new Button();
        btn.setText("register");
        Label l1=new Label("username :");
        Label l2=new Label("password");
        TextField f1=new TextField();
        f1.setPromptText("example: mohamed");
        TextField f2=new TextField();
         f2.setPromptText("password");
        btn.setOnAction(e->{
           String x,y;
                x=f1.getText();
                y=f2.getText();
                if(x.isEmpty()||y.isEmpty()){
                    Alert a=new Alert(AlertType.ERROR);
                    a.setTitle("error");
                    a.setHeaderText(null);
                    a.setContentText("invalid username or password");
                    System.out.println("not found");
                    a.showAndWait();
                }else{
                   login l=new login();
                try {
                    l.register(x, y);
                    Alert aa=new Alert(AlertType.CONFIRMATION);
                    aa.setHeaderText(null);
                    aa.setContentText("* done regestration * ");
                    Optional<ButtonType> res=aa.showAndWait();
                    if(res.get()==ButtonType.OK){
                        
                        JavaFXApplication14.window.setScene(Login());
                        JavaFXApplication14.window.setTitle(" Login ");
                    }else
                      System.exit(0);
                    
                } catch (IOException ex) {
                    Logger.getLogger(JavaFXApplication14.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JavaFXApplication14.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
                System.out.println("registration done"); 
                 
                 }
        });
                
        GridPane root = new GridPane();
        root.add(l1,0,0);
        root.add(l2,0,1);
        root.add(f1,1,0);
        root.add(f2,1,1);
        root.add(btn,3,3);
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root, 500, 350);
        return scene;
    }
        
     public static Scene Login()throws Exception,IOException, ClassNotFoundException{
        Button btn = new Button();
        btn.setText("Login");
        Label l1=new Label("username :");
        Label l2=new Label("password :");
        f1=new TextField();
        f1.setPromptText("example: mohamed");
        TextField f2=new TextField();
        f2.setPromptText("password");
        
        GridPane root = new GridPane();
        root.add(l1,0,0);
        root.add(l2,0,1);
        root.add(f1,1,0);
        root.add(f2,1,1);
        root.add(btn,3,3);
         root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 500, 350);
        
        btn.setOnAction(e->{
                String x,y;
                int w;
                x=f1.getText();
                y=f2.getText();
                login l=new login();
                w=l.log("relist",f1.getText(),f2.getText());
                saler s1=new saler();
                //s1.additem(100, 400, 15, 40, "shoes", "red", "sneaker", clothes.list);
                //s1.Delete_Item(5,clothes.list);
                //s1.edit_item(clothes.list);
                //user u=new user();
                //u.display(clothes.list);
                
              if(w==1){
                  try {
                JavaFXApplication14.window.setScene(salerGUI.saler());
                 } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                 }
                JavaFXApplication14.window.show();
              }  else if(w==2){
                  try {
                JavaFXApplication14.window.setScene(userGUI.user());
                 } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                 }
                JavaFXApplication14.window.show();
              }
              else{
                  Alert a=new Alert(AlertType.ERROR);
                  a.setTitle("error");
                  a.setHeaderText(null);
                  a.setContentText("invalid username or password");
                  System.out.println("not found");
                  a.showAndWait();
              }
            
                
                
                
                });
        
       
        return scene;
    }    
}
