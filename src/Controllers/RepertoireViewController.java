/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import app.MysqlConnect;
import app.ReApp_V2;
import app.monPane;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



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
    private JFXListView<String> List_Contact ;
    @FXML
    private Circle img_circle;
    Image img126 = new Image("/Image/icons8_contacts_126px_1.png");
    Image imgAlea = new Image("/Image/icons8_administrator_male_64px.png");
    HBox hb; 
    
    private ObservableList<String> listView;
    

    

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
    ResultSet res1;
    @FXML
    private JFXTextField Nom_contact;
    @FXML
    private JFXTextField prenom_contact;
    @FXML
    private JFXTextField numero1;
    @FXML
    private JFXTextField numero11;
    @FXML
    private JFXTextField email_contact;
    @FXML
    private JFXButton choix_img;
    
    private Image image;
    private String pathImg;
    byte[] imgData;
    private ImageIcon imgList;
    
    @FXML
    private JFXTextArea note_descr;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
//        List_Contact.setCellFactory(new Callback<JFXListView<monPane>, JFXListCell<monPane>>(){
//            @Override
//            public JFXListCell<monPane> call(JFXListView<monPane> arg0){
//                JFXListCell<monPane> cell = new JFXListCell<monPane>(){
//                    
//                    @Override
//                    protected void updateItem(monPane photo, boolean bll){
//                        super.updateItem(photo, bll);
//                        if(photo != null){
//                            Image img4 = new Image(getClass().getResource("Image/"+photo.getimg()).toExternalForm());
//                            ImageView imgview = new ImageView(img4);
//                            setGraphic(imgview);
//                            setText(photo.getLibelle());
//                        }
//                    }
//                };
//                return null;
//            }
//        });
        img_circle.setFill(new ImagePattern(img126));
//      Image par défaut du contact   

        listView = FXCollections.observableArrayList();
        try {
            affiche(listView);
        } catch (IOException ex) {
            Logger.getLogger(RepertoireViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        List_Contact.setItems(listView);
        
        
        
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
    private static Image convertToJavaFXImage(byte[] raw, final int width, final int height) {
        WritableImage image = new WritableImage(width, height);
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(raw);
            BufferedImage read = ImageIO.read(bis);
            image = SwingFXUtils.toFXImage(read, null);
        } catch (IOException ex) {
            Logger.getLogger(RepertoireViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }

    private void affiche(ObservableList<String> list) throws IOException{
        try{
            conn = mysqlConnect.connect();         
            st = conn.createStatement();
            res = st.executeQuery("SELECT Numero1_Contact FROM contact;");
            res1 = st.executeQuery("SELECT Photo FROM contact WHERE idContact=3");
            
//            res1 = st.executeQuery("SELECT Photo FROM contact;");
            
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
    
    public void createContact() throws FileNotFoundException, SQLException{
        app.MysqlConnect connect = new app.MysqlConnect();
        Connection connectDB = connect.connect();
        String nom = Nom_contact.getText();
        String prenom = prenom_contact.getText();
        String num1 = numero1.getText();
        String num2 = numero11.getText();
        String email = email_contact.getText();
        String note = note_descr.getText();
        Image img_Re = image;
        InputStream photo = new FileInputStream(new File(pathImg));

        PreparedStatement sta = connectDB.prepareStatement("INSERT INTO contact(Photo,Nom_Contact,Prenom_Contact,Numero1_Contact,Numero2_Contact,Email,Notes) VALUES(?,?,?,?,?,?,?)");
        sta.setBlob(1, photo);
        sta.setString(6, email);
        sta.setString(2, nom);
        sta.setString(3, prenom);
        sta.setString(4, num1);
        sta.setString(5, num2);
        sta.setString(7, note);
        sta.execute();
    }   
    
    @FXML
    private void EnregistreRegistr(ActionEvent event) throws FileNotFoundException, SQLException {
//        Ajout_ContactController.AjouterP(Email, Nom_Contact, Prenom_Contact, Num1, Num2, Notes, img126);
        createContact();
        Pane_Ajout.setVisible(false);
    }

    @FXML
    private void AnnulerRegistr(ActionEvent event) {
        Pane_Ajout.setVisible(false);
    }  

    @FXML
    private void chooseImg(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
            
            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
             
            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);
            pathImg = file.getAbsolutePath();
                      
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                image = SwingFXUtils.toFXImage(bufferedImage, null);
                img_circle1.setFill(new ImagePattern(image));
            } catch (IOException ex) {
                Logger.getLogger(RepertoireViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
}
