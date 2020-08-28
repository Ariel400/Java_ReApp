/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javafx.scene.layout.Pane;

/**
 *
 * @author ariel
 */
public class monPane {
    private String imgCont;
    private String lbl;
    
    
    public monPane(String img,String lbl) 
    {
        this.lbl = lbl;
        this.imgCont = img;
    }
    
    public String getimg(){
        return this.imgCont;
    }
    public String getLibelle(){
        return this.lbl;
    }
}
