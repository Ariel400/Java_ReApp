/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXListCell;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

/**
 *
 * @author ariel
 */
public class Cell extends JFXListCell<String> {
    Pane pane = new Pane();
    HBox hbox = new HBox();
    Button btn = new Button("Sup");
    Label num1 = new Label("hjf");
    Label num2 = new Label("+22501336163");
    Label nom = new Label("Ariel Touré");
    Image profile = new Image("/Image/icon8_customer_50px.png");
    
    public Cell()
    {
        super();
        hbox.getChildren().addAll(pane,num1,btn);
        hbox.setHgrow(pane, Priority.ALWAYS);
    }
    public void updateItem(String name,boolean empty){
        super.updateItem(name, empty);
        setText(null);
        setGraphic(null);
            
        if(name != null && !empty){
            num1.setText(name);
            setGraphic(hbox);
        }
    }
}
