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
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
//import static javafxapplication14.payment.lp;
import static javafxapplication14.user.cartlist;


/**
 *
 * @author dell
 */
public class userGUI {
    static BorderPane gg=new BorderPane();
    userGUI(){
    }
    
    
    public static Scene user() throws Exception{
        Scene scene1;
        
        a1 n=new a1();
        gg=n.dis(clothes.list);
        
         scene1 = new Scene(gg, 1500, 1000);
         
         return scene1;
    }}
class a1{
   //Alert dd=new Alert();
   
    File read=new File("clothes_list.txt");
    File filecart=new File("cart.txt");
    payment pt=new payment();
    Button b4;
    Button b5;
    Label l8;
    int counter=0;
    int ii;
    BorderPane p;
    public ArrayList<clothes> read(ArrayList<clothes>list) throws IOException, ClassNotFoundException{
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            return list;
    }
    public void read1() throws IOException, ClassNotFoundException{
            FileInputStream input1 = new FileInputStream(filecart);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            cartlist=(ArrayList<Cart>)oinput.readObject();
            //return cartlist;
            //System.out.println(list);
            //return list;
    }
    public GridPane change(ArrayList<clothes>list) throws FileNotFoundException{
        GridPane g=new GridPane();
        for(int i=0;i< list.size();i++){
            if(list.get(i).getId()==ii){
                    GridPane g1=new GridPane();
                    Label l1=new Label("ID="+list.get(i).getId());
                    Label l2=new Label(list.get(i).getDescription());
                    Label l3=new Label(list.get(i).getType());
                    Label l4=new Label("amount available ="+list.get(i).getAmount());
                    Label l5=new Label(list.get(i).getColor());
                    Label l7=new Label("size :"+list.get(i).getSize());
            
            Button b=new Button();
            b.setText(Integer.toString(i+1));
            Image image1 = new Image(new FileInputStream("cart.png"));
            ImageView iv2=new ImageView(image1);
            iv2.setFitHeight(150);
            iv2.setFitWidth(150);
            b.setGraphic(iv2);
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    int x=0;
                    TextInputDialog d=new TextInputDialog();
                    d.setTitle("Add to Cart");
                    d.setHeaderText(null);
                    d.setContentText("please enter amount :");
                    Optional <String> res=d.showAndWait();
                    x=Integer.parseInt(res.get());
                    user u1=new user();
                    u1.add_cart(GUI.f1.getText(),Integer.parseInt(((Button) e.getSource()).getText()), x, list);
                    System.out.println("amount ="+x);
                    System.out.println("item " + ((Button) e.getSource()).getText() + "is clicked");
                    System.out.println(GUI.f1.getText());
                    //u1.PlaceOrder(GUI.f1.getText(), clothes.list);
                    //u1.display(list);
                }
            });
            System.out.println(i);
            GridPane g4=new GridPane();
            g4.getChildren().add(b);
            g4.setStyle("-fx-border-color: blue");
            g4.setAlignment(Pos.CENTER);
            
            GridPane g2=new GridPane();
            Label l6=new Label("price ="+list.get(i).getPrice());
            g2.setAlignment(Pos.CENTER);
            
            VBox h1=new VBox();
            
            GridPane g3=new GridPane();
            
            System.out.println(list.get(i).getType()+list.get(i).getDescription()+Integer.toString(list.get(i).getId()));
            //try{
            String Filename=list.get(i).getType()+list.get(i).getDescription()+Integer.toString(list.get(i).getId())+".jpg";
            Image image = new Image(new FileInputStream(Filename));
            
            ImageView iv1=new ImageView(image);
            iv1.setFitHeight(150);
            iv1.setFitWidth(150);
            Label L7 = new Label(" ",iv1);
            
            g3.getChildren().add(L7);
            //}catch(Exception e ){
              //  System.out.println("no photo for this item");
            //}
            g3.setStyle("-fx-border-color: blue");
            g3.setAlignment(Pos.CENTER);
            
            GridPane g5=new GridPane();
            g5.setStyle("-fx-border-color: blue");
            VBox v2=new VBox();
            v2.setAlignment(Pos.CENTER);
            HBox h=new HBox();
            h.setAlignment(Pos.CENTER);
            l8=new Label("0");
            b4=new Button("Add");
            
            ActionEvent e=new ActionEvent();
            //b4.setOnAction(handle(e));
            
            
            
            b5=new Button ("sub");
            h.getChildren().addAll(b4,b5);
            v2.getChildren().addAll(l8,h);
            g5.add(v2, 0,0);
            
            
            
            h1.getChildren().addAll(l1,l2,l3,l4,l5,l7);
            h1.setAlignment(Pos.CENTER);
            g1.add(h1, 1, 1);
            g2.add(l6, 2, 1);
            g1.setStyle("-fx-border-color: blue");
            g2.setStyle("-fx-border-color: blue");
            g1.setPadding(new Insets(10));
            g.add(g1, 1, i);
            g.add(g2, 2, i);
            g.add(g3, 0, i);
            g.add(g4, 4, i);
            g.add(g5, 3, i);
                   break; 
    }}
        return g;
    }
    public ScrollPane  change1(ArrayList<Cart>list) throws FileNotFoundException,Exception,IOException, ClassNotFoundException{
        GridPane g=new GridPane();
        ScrollPane sp=new ScrollPane();
        System.out.println(cartlist);
        for(int i=0;i< list.size();i++){
            if(list.get(i).getUsername().equals(GUI.f1.getText())){
                    GridPane g1=new GridPane();
                    Label l1=new Label("ID="+list.get(i).getId());
                    Label l2=new Label(list.get(i).getDescription());
                    Label l3=new Label(list.get(i).getType());
                    Label l4=new Label("amount available ="+list.get(i).getAmount());
                    Label l5=new Label(list.get(i).getColor());
                    Label l7=new Label("size :"+list.get(i).getSize());
            
            
            //System.out.println(i);
            
            
            GridPane g2=new GridPane();
            Label l6=new Label("price ="+list.get(i).getPrice());
            g2.setAlignment(Pos.CENTER);
            
            VBox h1=new VBox();
            
            GridPane g3=new GridPane();
            
            System.out.println(list.get(i).getType()+list.get(i).getDescription()+Integer.toString(list.get(i).getId()));
            try{
            String Filename=list.get(i).getType()+list.get(i).getDescription()+Integer.toString(list.get(i).getId())+".jpg";
            Image image = new Image(new FileInputStream(Filename));
            
            ImageView iv1=new ImageView(image);
            iv1.setFitHeight(150);
            iv1.setFitWidth(150);
            Label L7 = new Label(" ",iv1);
            
            g3.getChildren().add(L7);
            }catch(Exception e ){
               System.out.println("no photo for this item");
            }
            g3.setStyle("-fx-border-color: blue");
            g3.setAlignment(Pos.CENTER);
            
            
            h1.getChildren().addAll(l1,l2,l3,l4,l5,l7);
            h1.setAlignment(Pos.CENTER);
            g1.add(h1, 1, 1);
            g2.add(l6, 2, 1);
            g1.setStyle("-fx-border-color: blue");
            g2.setStyle("-fx-border-color: blue");
            g1.setPadding(new Insets(10));
            g.add(g1, 1, i);
            g.add(g2, 2, i);
            g.add(g3, 0, i);
            sp.setContent(g);
            
                    
    }}
   
       
        System.out.println(GUI.f1.getText());
        user u=new user();
        Button b1=new Button("confirm");
        Button b2=new Button("Delete an item");
        Label l22=new Label("Total Price :"+Integer.toString(u.totalpri(GUI.f1.getText())));
        l22.setTextFill(Color.color(1,0,0));
       
       // hhj.getChildren().add(l23,l22);
        System.out.println(payment.lp);
        
        
        VBox v1=new VBox();
        v1.setAlignment(Pos.CENTER);
        v1.setPadding(new Insets(15, 12, 15, 12));
        v1.setSpacing(10);
        v1.setStyle("-fx-background-color: #336699;");
        //v1.getChildren().addAll(l23,l22,b1,b2);
        v1.getChildren().addAll(l22,b1,b2);
        p.setRight(v1);
        //g.setAlignment(Pos.CENTER);
        final ArrayList<clothes>list1= read(clothes.list);
        //user u1=new user();
           // u1.PlaceOrder(false,GUI.f1.getText(),list1);
        System.out.println("aaaaaaaaa");
        //pt.addtowallet(GUI.f1.getText(),200,payment.lp);
       // System.out.println(pt.getUserwallet(GUI.f1.getText(),payment.lp));
        //Boolean t;
        //pt.lp.add(pt);
            
            
        b2.setOnAction(e->{
            user u1=new user();
            try {
                u1.PlaceOrder(false,GUI.f1.getText(),list1);
            } catch (IOException ex) {
                Logger.getLogger(a1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        );
        b1.setOnAction(e->{
            try {
                //user u1=new user();
                u.PlaceOrder(true, GUI.f1.getText(), list1);
            } catch (IOException ex) {
                Logger.getLogger(a1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //pt.addtowallet(GUI.f1.getText(),200);
           // System.out.println(pt.getUserwallet());
            Boolean t;
            //payment.lp.add(pt);
            
//            try {
//                t=pt.paywithwallet(GUI.f1.getText(),Integer.parseInt(l22.getText()),payment.lp);
//                if(t==true){
//                   System.out.println("successfully transaction");
//                }else{
//                   System.out.println("you do not have a balance ");
//                }
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(a1.class.getName()).log(Level.SEVERE, null, ex);
//            
//            
//            }
        });
       
                 return sp;
    }
        
       
    
    
    public BorderPane dis(ArrayList<clothes>list) throws Exception,IOException, ClassNotFoundException{
        
            list=read(clothes.list);
            System.out.println(list);
            ArrayList<Cart>list2= new ArrayList<>();
            read1();
            //System.out.println(cartlist);
            
    
            final ArrayList<clothes>list1=read(clothes.list);
            //list1=list;
        GridPane g=new GridPane();
        ScrollPane sp=new ScrollPane();
        p=new BorderPane();
        ArrayList<Button> btn=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            GridPane g1=new GridPane();
            Label l1=new Label("ID="+list.get(i).getId());
            Label l2=new Label(list.get(i).getDescription());
            Label l3=new Label(list.get(i).getType());
            Label l4=new Label("amount available ="+list.get(i).getAmount());
            Label l5=new Label(list.get(i).getColor());
            Label l7=new Label("size :"+list.get(i).getSize());
            
            Button b=new Button();
            b.setText(Integer.toString(list.get(i).getId()));
            Image image1 = new Image(new FileInputStream("cart.png"));
            ImageView iv2=new ImageView(image1);
            iv2.setFitHeight(150);
            iv2.setFitWidth(150);
            b.setGraphic(iv2);
            btn.add(b);
            btn.get(i).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    int x=0;
                    TextInputDialog d=new TextInputDialog();
                    d.setTitle("Add to Cart");
                    d.setHeaderText(null);
                    d.setContentText("please enter amount :");
                    Optional <String> res=d.showAndWait();
                    x=Integer.parseInt(res.get());
                    user u1=new user();
                    u1.add_cart(GUI.f1.getText(),Integer.parseInt(((Button) e.getSource()).getText()), x, list1);
                    System.out.println("amount ="+x);
                    System.out.println("item " + ((Button) e.getSource()).getText() + "is clicked");
                    System.out.println(GUI.f1.getText());
                    //u1.PlaceOrder(GUI.f1.getText(), clothes.list);
                    //u1.display(list);
                    
                }
            });
            System.out.println(i);
            GridPane g4=new GridPane();
            g4.getChildren().add(b);
            g4.setStyle("-fx-border-color: blue");
            g4.setAlignment(Pos.CENTER);
            
            GridPane g2=new GridPane();
            Label l6=new Label("price ="+list.get(i).getPrice());
            g2.setAlignment(Pos.CENTER);
            
            VBox h1=new VBox();
            
            GridPane g3=new GridPane();
            
            System.out.println(list.get(i).getType()+list.get(i).getDescription()+Integer.toString(list.get(i).getId()));
            try{
            String Filename=list.get(i).getType()+list.get(i).getDescription()+Integer.toString(list.get(i).getId())+".jpg";
            Image image = new Image(new FileInputStream(Filename));
            
            ImageView iv1=new ImageView(image);
            iv1.setFitHeight(150);
            iv1.setFitWidth(150);
            Label L7 = new Label(" ",iv1);
            
            g3.getChildren().add(L7);
            }catch(Exception e ){
                System.out.println("no photo for this item");
            }
            g3.setStyle("-fx-border-color: blue");
            g3.setAlignment(Pos.CENTER);
            
            GridPane g5=new GridPane();
            g5.setStyle("-fx-border-color: blue");
            VBox v2=new VBox();
            v2.setAlignment(Pos.CENTER);
            HBox h=new HBox();
            h.setAlignment(Pos.CENTER);
            l8=new Label("0");
            b4=new Button("Add");
            
            ActionEvent e=new ActionEvent();
            //b4.setOnAction(handle(e));
            
            
            
            b5=new Button ("sub");
            h.getChildren().addAll(b4,b5);
           // v2.getChildren().addAll(l8,h);
            g5.add(v2, 0,0);
            
            
            
            h1.getChildren().addAll(l1,l2,l3,l4,l5,l7);
            h1.setAlignment(Pos.CENTER);
            g1.add(h1, 1, 1);
            g2.add(l6, 2, 1);
            g1.setStyle("-fx-border-color: blue");
            g2.setStyle("-fx-border-color: blue");
            g1.setPadding(new Insets(10));
            g.add(g1, 1, i);
            g.add(g2, 2, i);
            g.add(g3, 0, i);
            g.add(g4, 4, i);
            //g.add(g5, 3, i);
            sp.setContent(g);
            
        }
        
        HBox h=new HBox();
        Button b6=new Button();
        //b6.setMaxHeight(20);
        h.setPadding(new Insets(15, 12, 15, 12));
        h.setSpacing(10);
        h.setStyle("-fx-background-color: #336699;");
        Button b7=new Button();
        Image image111 = new Image(new FileInputStream("cart.png"));
        ImageView iv1=new ImageView(image111);
        iv1.setFitHeight(50);
        iv1.setFitWidth(50);
        b7.setGraphic(iv1);
        b7.setOnAction(e->{
            
             ScrollPane g12=new ScrollPane();
             
                try {
                    g12=change1(cartlist);
                    System.out.println(cartlist);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
                }
                p.setCenter(g12);
        }             
        );
        
        
        
        Image image11 = new Image(new FileInputStream("search.jpg"));
        ImageView iv=new ImageView(image11);
        iv.setFitHeight(50);
        iv.setFitWidth(50);
        b6.setGraphic(iv);
        b6.setOnAction(e->{
            VBox v10=new VBox();
            Label l=new Label("name :");
            TextField t=new TextField();
            HBox h1=new HBox();
            h1.getChildren().addAll(l,t);
            Label l1=new Label("color :");
            TextField t1=new TextField();
            HBox h2=new HBox();
            h2.getChildren().addAll(l1,t1);
            Label l2=new Label(" size :");
            TextField t2=new TextField();
            HBox h3=new HBox();
            h3.getChildren().addAll(l2,t2);
            Label l3=new Label("type :");
            TextField t3=new TextField();
            HBox h4=new HBox();
            h4.getChildren().addAll(l3,t3);
            Button b=new Button(" search ");
            v10.getChildren().addAll(h1,h2,h3,h4,b);
            v10.setAlignment(Pos.CENTER);
            v10.setPadding(new Insets(15, 12, 15, 12));
            v10.setSpacing(10);
            v10.setStyle("-fx-background-color: #336699;");
            b.setOnAction(ex->{
                user u=new user();
                
                ii=u.search(t.getText(),t3.getText(), t1.getText(), Integer.parseInt(t2.getText()), list1);
                if(ii==-1){
                    System.out.println("item not found");
                }else{
                    GridPane g10=new GridPane();
                    try {
                        g10=change(list1);
                    } catch (FileNotFoundException ex1) {
                        Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    p.setCenter(g10);
                   }
                
            });
            

            p.setLeft(v10);
        });
        
       
        h.getChildren().add(b6);
        h.getChildren().add(b7);
        h.setAlignment(Pos.CENTER_RIGHT);
        p.setTop(h);
        
        Button b10=new Button(" Display All ");
                    h.getChildren().add(b10);
                    b10.setOnAction(event->{
                        p.setCenter(sp);
                        Label l=new Label();
                        p.setLeft(l);
                        p.setRight(l);
                    }
                   );
        Button b21=new Button ("add balance");  
        h.getChildren().add(b21);
        b21.setOnAction(e->{
            System.out.println();
            TextInputDialog d=new TextInputDialog();
            d.setTitle("Add to Balance");
            d.setHeaderText(null);
            d.setContentText("please enter amount :");
            Optional <String> res=d.showAndWait();
            int xx=Integer.parseInt(res.get());
            //pt.addtowallet(GUI.f1.getText(), xx, payment.lp);
           
        }
        );
        
        g.setAlignment(Pos.CENTER);
        p.setCenter(sp);
        Image image1 = new Image(new FileInputStream("hala.jpg"));
        ImageView v=new ImageView(image1);
        BackgroundImage bgImage=new BackgroundImage(
                image1,
                 BackgroundRepeat.NO_REPEAT,
                 BackgroundRepeat.NO_REPEAT,
                 BackgroundPosition.CENTER,
                 new BackgroundSize(500,500,true,true,true,true)    
         );
          
          //System.out.println("number ="+ btt(this.btt(e, btn)));
          
         
        //Background bg=new Background(bgImage);
        //p.setBackground(bg);
        return p;
    }
    
    /*public int btt(ActionEvent e, ArrayList<Button>btn){
              int x=-1;
              for(int i=0;i<btn.size();i++){
                  if(e.getSource()==btn.get(i)){
                      System.out.println("we click on button :"+i);
                      x=i;
                  }else 
                      x=-1;
         }
              return x;}*/
    
    
    public void handle(ActionEvent e){
             if (e.getSource()==b4)   {
                 counter++;
             }
             else{
                 if(e.getSource()==b5){
                     counter--;
                 }
                 }
             l8.setText(Integer.toString(counter));
            
    }
}




