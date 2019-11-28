package school.absInt.UI;

import javafx.application.Application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import school.absInt.Library;

import java.awt.event.ActionEvent;
import java.io.File;

public class Inventory {
    @FXML
    private void saveLib(ActionEvent event) throws Exception{
        DirectoryChooser dirChooserSave = new DirectoryChooser();

        File selectedDirectory = dirChooserSave.showDialog(null);

        if(selectedDirectory == null){
            System.out.println("You haven't selected any dir.");
        }else{
            String path = selectedDirectory.getAbsolutePath();
            System.out.println(path);

            lib.serialization(path);
        }
    }


    @FXML
    private void closeApp(){
        Platform.exit();
    }
}
