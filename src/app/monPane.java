/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author ariel
 */
public class monPane extends Pane {
    private ImageView imgCont = new ImageView("/Image/icons8_administrator_male_64px.png");
    private Label lbl = new Label("Ariel Touré");
    private JFXButton bt = new JFXButton("Del");
    
    monPane(ImageView img,Label lbl, JFXButton but) 
    {
        super();      
    }
    
}
