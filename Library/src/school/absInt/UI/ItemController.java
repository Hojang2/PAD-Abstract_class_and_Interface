package school.absInt.UI;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.event.*;
import javafx.scene.control.Label;

public class ItemController {
    @FXML
    private Label labelNameOfBook;

    @FXML
    private Label labelNameOfAuthor;

    @FXML
    private Label labelYaerOfCreation;

    public ItemController() {
        //labelNameOfAuthor = ;
    }

    @FXML
    private void closeApp(){
        Platform.exit();
    }
}
