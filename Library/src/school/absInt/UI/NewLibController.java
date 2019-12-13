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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import school.absInt.Library;

import java.io.IOException;

public class NewLibController {
    @FXML
    private TextField textNameOfLib;

    public NewLibController() {

    }

    @FXML
    private void createNewLib(ActionEvent event) throws Exception{
        Library lib = new Library(textNameOfLib.toString());

        try{
            showInvnetory(lib, event);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private Stage showInvnetory(Library lib, ActionEvent event) throws IOException {

        InventoryController invController = new InventoryController(lib);

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "Inventory.fxml"
                )
        );

        loader.setController(invController);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(
                new Scene(
                        (Pane) loader.load()
                )
        );

        stage.show();

        invController.init();

        return stage;

    }

    @FXML
    private void closeApp(){
        Platform.exit();
    }
}
