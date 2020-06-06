/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import app.ReApp_V2;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


/**
 *
 * @author ariel
 */
public class RepertoireViewController implements Initializable {
    ObservableList list = FXCollections.observableArrayList();
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private JFXListView<String> List_Contact;
    @FXML
    private Circle img_circle;
    Image img126 = new Image("/Image/icons8_contacts_126px_1.png");
    
    ObservableList<String> listView = FXCollections.observableArrayList("+22579707025","+22507070707","+22565656565");
    
    static class Cell extends ListCell<String>
    {
        HBox hbox = new HBox();
        Button Btn_Del = new Button("Delete");
        Label No = new Label("");
        Pane pane = new Pane();
        Image img64 = new Image("/Image/icons8_contacts_126px_1 (Personnalisé).png");
        ImageView imgTest = new ImageView(img64);
        
        public Cell(){
            super();
            hbox.getChildren().addAll(hbox,Btn_Del,No,imgTest);
            hbox.setHgrow(pane, Priority.ALWAYS);
        }
        
        public void updateItem(String name,boolean empty){
                super.updateItem(name, empty);
                setText(null);
                setGraphic(null);
                if(name != null && !empty){
                    No.setText(name);
                    setGraphic(hbox);
                }
               
            }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        

        img_circle.setFill(new ImagePattern(img126));
        
        List_Contact.setItems(listView);
        List_Contact.setCellFactory(param -> new Cell());
            
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
