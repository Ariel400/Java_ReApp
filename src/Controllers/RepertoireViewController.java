/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import app.MysqlConnect;
import app.ReApp_V2;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;


import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;

import javafx.fxml.FXMLLoader;

import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
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
    private JFXListView<HBox> List_Contact ;
    @FXML
    private Circle img_circle;
    Image img126 = new Image("/Image/icons8_contacts_126px_1.png");
    Image imgAlea = new Image("/Image/icons8_administrator_male_64px.png");
    HBox hb; 
    
    ObservableList<HBox> listView;
    

    @FXML
    private JFXButton BtnModifier;
    @FXML
    private JFXButton BtnNewContact;
    private Pane view;
    @FXML
    private Pane Pane_Ajout;
    @FXML
    private Circle img_circle1;
    @FXML
    private JFXButton BtnEnregistrer;
    @FXML
    private JFXButton BtnAnnuler;
    @FXML
    private JFXButton BtnNewContact1;
    
    MysqlConnect mysqlConnect = new MysqlConnect();
    Connection conn;
    Statement st;
    ResultSet res;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Label lbl = new Label("Ariel Touré");
        lbl.setFont(new Font("Arial",20));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/AffichList.fxml"));
        hb = new HBox(new ImageView(imgAlea), lbl);
        
        hb.setSpacing(30);
        
        listView  = FXCollections.observableArrayList(hb); //Exemples pour Listview
        img_circle.setFill(new ImagePattern(img126)); //Image par défaut du contact   
        List_Contact.setItems(listView);
        
//        listView = FXCollections.observableArrayList();
//        affiche(listView);
        
        
//        List_Contact.setCellFactory(param -> new Cell());
            
    }    

   

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
//    private void maximize_stage(javafx.scene.input.MouseEvent event) {
//        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        stage.setFullScreenExitHint("");
//        stage.setFullScreen(true);
//        
//    }
    
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

    private void affiche(ObservableList<String> list){
        try{
            conn = mysqlConnect.connect();         
            st = conn.createStatement();
            res = st.executeQuery("SELECT Numero1_Contact FROM contact;");
            while (res.next()){
                list.add(
                        new String(res.getString("Numero1_Contact"))
                );
            }
           
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void ChargePaneAdd(ActionEvent event) {
        Pane_Ajout.setVisible(true);
    }

    @FXML
    private void EnregistreRegistr(ActionEvent event) {
//        Ajout_ContactController.AjouterP(Email, Nom_Contact, Prenom_Contact, Num1, Num2, Notes, img126);
        Pane_Ajout.setVisible(false);
    }

    @FXML
    private void AnnulerRegistr(ActionEvent event) {
        Pane_Ajout.setVisible(false);

    } 

    
    
}
