/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Tex
 */
public class TreeElements {
    Image iconDossier = new Image( getClass().getResourceAsStream("/media/img/dossier.png") );
    Image iconFichier = new Image( getClass().getResourceAsStream("/media/img/fichier.png") );
    Image iconImage = new Image( getClass().getResourceAsStream("/media/img/image.png") );

    public TreeElements() {
    }

    public TreeItem CreationItemDossier(String nom) {
        return new TreeItem(nom, new ImageView(iconDossier));
    }

    public TreeItem CreationItemFichier(String nom) {
        if ( nom.matches("(.*)(.jpg|.gif|.jpeg|.png|.tiff|.bmp|.tif)") ) {
            System.out.println("ihm.TreeElements.CreationItemFichier(): Fichier Trouvé.");
            return new TreeItem(nom, new ImageView(iconImage));
        }
        return new TreeItem(nom, new ImageView(iconFichier));
    }

}
