/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import AppControle.FonctionsPrincipales;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Tex
 */
public class FXMLDocumentController implements Initializable {

//  Il faut un @FXML par déclaration de variable
    @FXML
    private Label label;
    @FXML
    private TreeView<String> TreeView01;
    @FXML
    private MenuItem MenuFichierFermer01;

    @FXML
    private void handleButtonAction1(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    public void MenuFichierFermerEvt(ActionEvent event) {
        System.out.println("ihm.FXMLDocumentController.MenuFichierFermerEvt(): Fermeture application");
        FonctionsPrincipales.AppicationFermeture();
    }

//  L'objet TreView contiendra des objets TreeItem'
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        TreeElements te = new TreeElements();
        TreeItem<String> rootOrigin = te.CreationItemDossier("/");
        TreeItem<String> t;
        // faire un récursif pour aller chercher les sous répertoires.
        // sortir la routine pour en faire une méthode.
        
        File cheminCible = new File("C:\\Users\\Tex\\Desktop\\img");
        File[] ContenuRepCourant = cheminCible.listFiles();
        for (File f : ContenuRepCourant) {
            if (f.isDirectory()) {
                t = te.CreationItemDossier(f.getName());
            } else {
                t = te.CreationItemFichier(f.getName());
            }
            rootOrigin.getChildren().add(t);
            
            System.out.println("ihm.FXMLDocumentController.initialize():" + f.getName() + " / folder?: " + f.isDirectory());
        }
        rootOrigin.setExpanded(true);
        TreeView01.setRoot(rootOrigin);

//        TreeItem<String> rootOrigin = te.CreationItemDossier("/");
//        TreeItem<String> nodeA = te.CreationItemDossier("NodeA");
//        TreeItem<String> nodeB = te.CreationItemFichier("fichier.jpg");
//        TreeItem<String> nodeC = te.CreationItemFichier("fichier.gif");
//
//        nodeA.getChildren().addAll(te.CreationItemFichier("fichier.gof"), te.CreationItemFichier("fichier.jog"), te.CreationItemFichier("fichierggg.guf"));
//        rootOrigin.getChildren().addAll(nodeA, nodeB, nodeC);
//        nodeA.setExpanded(true);
    }

    public void ClicTreeElement(MouseEvent me) {
        if (me.getClickCount() == 2) {
            TreeItem<String> treeElement = TreeView01.getSelectionModel().getSelectedItem();
            System.out.println("ihm.FXMLDocumentController.sourisClick(): " + treeElement.getValue());
        }
    }

}
