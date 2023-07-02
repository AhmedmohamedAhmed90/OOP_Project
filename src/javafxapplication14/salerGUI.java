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
import javafx.scene.control.Alert;
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
import static javafxapplication14.user.cartlist;

/**
 *
 * @author dell
 */
public class salerGUI {
    static BorderPane gg=new BorderPane();
    
    salerGUI(){
    }
    
    
    public static Scene saler() throws Exception{
        Scene scene1;
        
        a n=new a();
        gg=n.dis(clothes.list);
        
         scene1 = new Scene(gg, 1500, 1500);
         
         return scene1;
    }}
class a{
    File read=new File("clothes_list.txt");
    File readord=new File("orders.txt");
    BorderPane p;
    Label l8;
    int counter=0;
    
    public ArrayList<clothes> read(ArrayList<clothes>list) throws IOException, ClassNotFoundException{
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            return list;
    }
    
    public int max() throws IOException, ClassNotFoundException{
        ArrayList<clothes>lis=new ArrayList<>();
        lis=read(clothes.list);
        
        int mx=lis.get(lis.size()-1).getId();
        mx+=1;
                
            return mx;
    }
    
    
        public ScrollPane  change12(ArrayList<Cart>list) throws FileNotFoundException,Exception,IOException, ClassNotFoundException{
            try{
            FileInputStream input1 = new FileInputStream(readord);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<Cart>)oinput.readObject();
            }catch(Exception e){
                System.out.println(e);
            }
        GridPane g=new GridPane();
        ScrollPane sp=new ScrollPane();
        //System.out.println(cartlist);
            System.out.println(list);
        for(int i=0;i< list.size();i++){
                    GridPane g1=new GridPane();
                    Label l1=new Label("ID="+list.get(i).getId());
                    Label l2=new Label(list.get(i).getDescription());
                    Label l3=new Label(list.get(i).getType());
                    Label l4=new Label("amount available ="+list.get(i).getAmount());
                    Label l5=new Label(list.get(i).getColor());
                    Label l7=new Label("size :"+list.get(i).getSize());
                    Label l8=new Label("user :"+list.get(i).username);
            
            
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
            
            
            h1.getChildren().addAll(l1,l2,l3,l4,l5,l7,l8);
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
            
                    
    }
   
       
        System.out.println(GUI.f1.getText());
        user u=new user();
        
        Label l22=new Label("Total Price :"+Integer.toString(u.totalpri(GUI.f1.getText())));
        l22.setTextFill(Color.color(1,0,0));
       
       // hhj.getChildren().add(l23,l22);
        //System.out.println(payment.lp);
        
        
        VBox v1=new VBox();
        
        v1.setAlignment(Pos.CENTER);
        v1.setPadding(new Insets(15, 12, 15, 12));
        v1.setSpacing(10);
        v1.getChildren().addAll(l22);
        v1.setStyle("-fx-background-color: #336699;");
        
        p.setRight(v1);
        
           
       

                 return sp;
    }    
    
    
    
    public BorderPane dis(ArrayList<clothes>list) throws Exception,IOException, ClassNotFoundException{
        
            FileInputStream input1 = new FileInputStream(read);
            ObjectInputStream oinput=new ObjectInputStream(input1);
            list=(ArrayList<clothes>)oinput.readObject();
            
            final ArrayList<clothes>list1=new ArrayList<>();
            //list1=list;
        GridPane g=new GridPane();
        ScrollPane sp=new ScrollPane();
        p=new BorderPane();
        ArrayList<Button> btn=new ArrayList<>();
        ArrayList<Button> btn1=new ArrayList<>();
        ArrayList<Button> btn2=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            GridPane g1=new GridPane();
            Label l1=new Label("ID="+list.get(i).getId());
            Label l2=new Label(list.get(i).getDescription());
            Label l3=new Label(list.get(i).getType());
            Label l4=new Label("amount available ="+list.get(i).getAmount());
            Label l5=new Label(list.get(i).getColor());
            
             Button b=new Button();
             Button b1=new Button();
             Button b2=new Button();
            b.setText( Integer.toString(list.get(i).getId()));
            btn.add(b);
            Image image1 = new Image(new FileInputStream("edit.png"));
            ImageView iv2=new ImageView(image1);
            iv2.setFitHeight(120);
            iv2.setFitWidth(120);
            b.setGraphic(iv2);
            
            b2.setText( Integer.toString(list.get(i).getId()));
            btn2.add(b2);
            Image image3 = new Image(new FileInputStream("peer.png"));
            ImageView iv4=new ImageView(image3);
            iv4.setFitHeight(120);
            iv4.setFitWidth(120);
            b2.setGraphic(iv4);
            btn2.get(i).setOnAction(e->{
                saler s=new saler();
                 TextInputDialog d10=new TextInputDialog();
                    d10.setTitle("discount percentage");
                    d10.setContentText("please, enter your discount percentage ");
                    Optional <String> res=d10.showAndWait();
                    double x10=Double.parseDouble(res.get());
                s.discount(Integer.parseInt(((Button) e.getSource()).getText()), x10, list1);
            });
            
            
            
            b1.setText( Integer.toString(list.get(i).getId()));
            btn1.add(b1);
            Image image2 = new Image(new FileInputStream("trash.png"));
            ImageView iv3=new ImageView(image2);
            iv3.setFitHeight(120);
            iv3.setFitWidth(120);
            b1.setGraphic(iv3);
            btn1.get(i).setOnAction(e->{
                saler s=new saler();
                System.out.println("item " + ((Button) e.getSource()).getText() + "is clicked");
                s.Delete_Item(Integer.parseInt(b1.getText()), list1);
            });
            
             btn.get(i).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                     int x;
                     System.out.println("item " + ((Button) e.getSource()).getText() + "is clicked");
                    TextInputDialog d=new TextInputDialog();
                    d.setTitle("Edit item");
                    d.setHeaderText("1- id" +"\t" +"2- price" + "\t" + "3- amount" + "\t" +"4- type " );
                    d.setContentText("which detail you want to edit? ");
                    Optional <String> res=d.showAndWait();
                    x=Integer.parseInt(res.get());
                    saler s1=new saler();
                    if(x>4||x<1){
                         Alert a=new Alert(Alert.AlertType.ERROR);
                         a.setTitle("error");
                         a.setHeaderText(null);
                         a.setContentText("invalid Answer");
                         //System.out.println("not found");
                         a.showAndWait();
                    }else{
                           if (x==1){
                    
                     int x1;
                    TextInputDialog d2=new TextInputDialog();
                    d2.setTitle("Editing id");
                    d2.setHeaderText (null);
                    d2.setContentText("enter the new id");
                    
                    Optional <String> res1=d2.showAndWait();
                     x1=Integer.parseInt(res1.get());
            s1.edit_id(Integer.parseInt(((Button) e.getSource()).getText()), x1, list1);
            
                    }
                    if (x==2){
                    
                     int x1;
                    TextInputDialog d2=new TextInputDialog();
                    d2.setTitle("Editing price");
                    d2.setHeaderText (null);
                    d2.setContentText("enter the new price");
                    
                    Optional <String> res1=d2.showAndWait();
                     x1=Integer.parseInt(res1.get());
            s1.edit_price(Integer.parseInt(((Button) e.getSource()).getText()), x1, list1);
            
            
                    
                    }
                    if (x==3){
                    
                     int x1;
                    TextInputDialog d2=new TextInputDialog();
                    d2.setTitle("Editing amount");
                    d2.setHeaderText (null);
                    d2.setContentText("enter the new amount");
                    
                    Optional <String> res1=d2.showAndWait();
                     x1=Integer.parseInt(res1.get());
            s1.edit_amount(Integer.parseInt(((Button) e.getSource()).getText()), x1, list1);
            
                    }
                    if (x==4){
                    
                     String x1;
                    TextInputDialog d2=new TextInputDialog();
                    d2.setTitle("Editing type");
                    d2.setHeaderText (null);
                    d2.setContentText("enter the new type");
                    
                    Optional <String> res1=d2.showAndWait();
                     x1=res1.get();
            s1.edit_type(Integer.parseInt(((Button) e.getSource()).getText()), x1, list1);
            
                    }
                    
                    //u1.add_cart(GUI.f1.getText(),Integer.parseInt(((Button) e.getSource()).getText())-1, x, list);
           
                               
                    }
                   

                }});
             HBox h=new HBox();
            h.setPadding(new Insets(15, 12, 15, 12));
            h.setSpacing(10);
            h.setStyle("-fx-background-color: #336699;");
            Button b7=new Button();
            Button b8=new Button();
            Image image122 = new Image(new FileInputStream("cart.png"));
            ImageView iv22=new ImageView(image122);
            iv22.setFitHeight(50);
            iv22.setFitWidth(50);
            b8.setGraphic(iv22);
            b8.setOnAction(e->{
                
            });
            
            Button b71=new Button();
           Image imag = new Image(new FileInputStream("cart.png"));
           ImageView soo=new ImageView(imag);
           soo.setFitHeight(50);
           soo.setFitWidth(50);
           b71.setGraphic(soo);
           b71.setOnAction(e->{
            
             ScrollPane g12=new ScrollPane();
             
                try {
                    g12=change12(saler.orders);
                    System.out.println(saler.orders);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex);
                }
                p.setCenter(g12);
        }             
        );
           Button b10=new Button(" Display All ");
                    b10.setOnAction(event->{
                        p.setCenter(sp);
                        Label l=new Label();
                        p.setLeft(l);
                        p.setRight(l);
                    }
                   );
            
            Image image111 = new Image(new FileInputStream("add.png"));
            ImageView iv1=new ImageView(image111);
            iv1.setFitHeight(50);
            iv1.setFitWidth(50);
            b7.setGraphic(iv1);
            b7.setOnAction(e->{
                 VBox v10=new VBox();
                 
            Label l10=new Label("name :");
            TextField t10=new TextField();
            HBox h10=new HBox();
            h10.getChildren().addAll(l10,t10);
            Label l11=new Label("color :");
            TextField t11=new TextField();
            HBox h11=new HBox();
            h11.getChildren().addAll(l11,t11);
            Label l12=new Label(" size :");
            TextField t12=new TextField();
            HBox h12=new HBox();
            h12.getChildren().addAll(l12,t12);
            Label l13=new Label("type :");
            TextField t13=new TextField();
            HBox h13=new HBox();
            h13.getChildren().addAll(l13,t13);
            Label l14=new Label("price :");
            TextField t14=new TextField();
            HBox h14=new HBox();
            h14.getChildren().addAll(l14,t14);
            Label l15=new Label("amount :");
            TextField t15=new TextField();
            HBox h15=new HBox();
            h15.getChildren().addAll(l15,t15);
            Button b11=new Button(" Add item ");
            b11.setOnAction(ex->{
                int max1;
                     try {
                         max1 = max();
                         System.out.println(max1);
                         saler s=new saler();
                         
                     s.additem(max1, Integer.parseInt(t14.getText()), Integer.parseInt(t15.getText()), Integer.parseInt(t12.getText()), t13.getText(), t11.getText(), t10.getText(), list1);
                
                     } catch (IOException ex1) {
                         Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex1);
                     } catch (ClassNotFoundException ex1) {
                         Logger.getLogger(a.class.getName()).log(Level.SEVERE, null, ex1);
                     }
                     //System.out.println(max1);
                     
                
                
                
            });
            
            
            v10.getChildren().addAll(h10,h11,h12,h13,h14,h15,b11);
            
            v10.setAlignment(Pos.CENTER);
            v10.setPadding(new Insets(15, 12, 15, 12));
            v10.setSpacing(10);
            v10.setStyle("-fx-background-color: #336699;");
            p.setLeft(v10);
            });
            
            
                     
             
             h.getChildren().addAll(b7,b71,b10);
             h.setAlignment(Pos.CENTER_RIGHT);
             p.setTop(h);
                     
            GridPane g2=new GridPane();
            GridPane g4=new GridPane();
            GridPane g5=new GridPane();
            GridPane g6=new GridPane();
            
            g6.getChildren().add(b2);
            g6.setStyle("-fx-border-color: blue");
            g6.setAlignment(Pos.CENTER);
            g5.getChildren().add(b1);
            g5.setStyle("-fx-border-color: blue");
            g5.setAlignment(Pos.CENTER);
            g4.getChildren().add(b);
            g4.setStyle("-fx-border-color: blue");
            g4.setAlignment(Pos.CENTER);
            Label l6=new Label("price ="+list.get(i).getPrice());
            g2.setAlignment(Pos.CENTER);
            
            VBox h1=new VBox();
            
            GridPane g3=new GridPane();
            
            System.out.println(list.get(i).getType()+list.get(i).getDescription()+Integer.toString(list.get(i).getId()));
            try{
            String Filename=list.get(i).getType()+list.get(i).getDescription()+Integer.toString(list.get(i).getId())+".jpg";
            Image image = new Image(new FileInputStream(Filename));
            
            ImageView v=new ImageView(image);
            v.setFitHeight(100);
            v.setFitWidth(150);
            Label L7 = new Label(" ",v);
            
            g3.getChildren().add(L7);
            }catch(Exception e ){
                System.out.println("no photo for this item");
            }
            g3.setStyle("-fx-border-color: blue");
            g3.setAlignment(Pos.CENTER);
            
            
            
            ActionEvent e=new ActionEvent();
            //b4.setOnAction(handle(e));
            
            
            
           
            
            
            h1.getChildren().addAll(l1,l2,l3,l4,l5);
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
            g.add(g5, 5, i);
            g.add(g6, 6, i);
            //ScrollPane sp=new ScrollPane();
            sp.setContent(g);
            

            
        }
        
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
    
    
    
}