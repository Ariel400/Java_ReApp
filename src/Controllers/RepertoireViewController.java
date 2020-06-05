/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import app.ReApp_V2;
import com.jfoenix.controls.JFXListView;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;


/**
 *
 * @author ariel
 */
public class RepertoireViewController implements Initializable {
    
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private JFXListView<?> List_Contact;

    
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    
//    private void moveFenetre(){
//        AnchorPane.setOnMousePressed((event) ->{
//            xOffset = event.getScreenX();
//            yOffset = event.getScreenY();
//
//        });
//        AnchorPane.setOnMouseDragged((event) ->{
//            ReApp_V2.stage.setX(event.getScreenX() - xOffset);
//            ReApp_V2.stage.setY(event.getScreenY() - xOffset);
//            ReApp_V2.stage.setOpacity(0.8f);
//        });
//        AnchorPane.setOnDragDone((event) ->{
//            ReApp_V2.stage.setOpacity(1.0f);
//        });
//        
//        AnchorPane.setOnMouseReleased((event) ->{
//            ReApp_V2.stage.setOpacity(1.0f);
//        });
//    }
   

    @FXML
    private void minimize_stage(javafx.scene.input.MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        ReApp_V2.stage.setIconified(true);
    }

    @FXML
    private void close_app(javafx.scene.input.MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        System.exit(0);
    }

    
   
    @FXML
    private void maximize_stage(javafx.scene.input.MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        
    }

    @FXML
    private void pressed(javafx.scene.input.MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    

    @FXML
    private void btn(javafx.scene.input.MouseEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX()- xOffset);
        stage.setY(event.getScreenY()- yOffset);
                
        
    }
}
