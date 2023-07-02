/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxapplication14;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author dell
 */
public class JavaFXApplication14 extends Application {
    public static Stage window;
    @Override
    public void start(Stage primaryStage) throws IOException {
        window=primaryStage;
         HBox hbox = new HBox();
         
         
       // File read=new File("clothes_list.txt");
        //File filecart=new File("cart.txt");
        //read.createNewFile();
        //filecart.createNewFile();
       // saler s=new saler();
        //s.additem(1, 100, 50, 5,"T-shirt","red", "polo", clothes.list);
        //user w=new user();
       // w.add_cart("mohamed", 1, 3, clothes.list);
        //System.out.println("created succes");
         
        Button b1=new Button("Login");
        b1.setPrefSize(100, 20);
        Button b2=new Button("Register");
        b2.setPrefSize(100, 20);
        HBox v1=new HBox();
        v1.getChildren().addAll(b1,b2);
        v1.setPadding(new Insets(15, 12, 15, 12));
        v1.setSpacing(10);
        v1.setStyle("-fx-background-color: #336699;");
        b1.setOnAction(e->{
           window.setTitle("Login!");
            try {
                window.setScene(GUI.Login());
            } catch (Exception ex) {
                Logger.getLogger(JavaFXApplication14.class.getName()).log(Level.SEVERE, null, ex);
            }
           window.show();
           
        });
        
         b2.setOnAction(e->{
           window.setTitle("Register!");
           window.setScene(GUI.Reg());
           window.show();
        });
         
         BorderPane n=new BorderPane();
         n.setTop(v1);
         Text t=new Text("Welcome to our store");
         t.setFont(new Font("Arial Black",30));
         n.setCenter(t);
         
        Scene scene = new Scene(n, 500, 500);
        
        
        window.setTitle("welcome window!");
        window.setScene(scene);
        window.show();
        
        
        
       
        
    }

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
