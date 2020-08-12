/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import app.MysqlConnect;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.sql.*;import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
/**
/**
 * FXML Controller class
 *
 * @author ariel
 */
public class Ajout_ContactController implements Initializable {

    /**
     * Initializes the controller class.
     */
    static MysqlConnect mysqlConnect = new MysqlConnect();
    @FXML
    private Pane Pane_Ajout;
    @FXML
    private Circle img_circle;
    @FXML
    private JFXTextField AD_Nom;
    @FXML
    private JFXTextField AD_Prenom;
    @FXML
    private JFXTextField AD_Num;
    @FXML
    private JFXTextField AD_Email;
    @FXML
    private JFXButton BtnEnregistrer;
    @FXML
    private JFXButton BtnAnnuler;
    @FXML
    private JFXTextArea AD_Note;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public static void AjouterP(String Email,String Nom_Contact,String Prenom_Contact,String Num1,String Num2, String Notes, Image photo){
        try{
            String query="INSERT INTO contact VALUES("+Email+","+Nom_Contact+","+Prenom_Contact+","+Num1+","+Num2+","+Notes+")";
            Connection cnx = (Connection) mysqlConnect.connect();
            Statement st = cnx.createStatement();
            st.executeUpdate(query);
            System.out.println("Bin ajouté");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        
    }

    @FXML
    private void Enreg_Contact(ActionEvent event) {
        
    }
}
