package school.absInt.UI;

import javafx.application.Application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import school.absInt.Library;

public class NewLib {
    @FXML
    private TextField textNameOfLib;

    public NewLib() {
    }

    @FXML
    private void createNewLib(ActionEvent event) throws Exception{
        Library lib = new Library(textNameOfLib.toString());

        Parent newSceneFXML = FXMLLoader.load(getClass().getResource("Inventory.fxml"));
        Scene newScene = new Scene(newSceneFXML);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }


    @FXML
    private void closeApp(){
        Platform.exit();
    }
}
