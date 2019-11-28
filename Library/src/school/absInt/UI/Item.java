package school.absInt.UI;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Item {
    @FXML
    private Label labelNameOfBook;

    @FXML
    private Label labelNameOfAuthor;

    @FXML
    private Label labelYaerOfCreation;

    public Item() {
        //labelNameOfAuthor = ;
    }

    @FXML
    private void closeApp(){
        Platform.exit();
    }
}
