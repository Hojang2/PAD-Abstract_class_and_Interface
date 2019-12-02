package school.absInt.UI;

import javafx.application.Application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import school.absInt.Library;

import java.io.File;
import java.io.IOException;

public class InventoryController {

    private Library lib;

    InventoryController(Library LibraryClass){
        this.lib = LibraryClass;
    }

    public void InitData(Library LibraryClass){
        this.lib = LibraryClass;
    }

    @FXML
    private void saveLib(ActionEvent event) throws Exception{
        DirectoryChooser dirChooserSave = new DirectoryChooser();

        File selectedDirectory = dirChooserSave.showDialog(null);

        if(selectedDirectory == null){
            System.out.println("You haven't selected any dir.");
        }else{
            String path = selectedDirectory.getAbsolutePath();
            System.out.println(path);

            //lib.serialization(path);
        }
    }

    @FXML
    private void closeApp(){
        Platform.exit();
    }
}