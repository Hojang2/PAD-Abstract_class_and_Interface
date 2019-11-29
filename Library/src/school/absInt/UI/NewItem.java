package school.absInt.UI;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.event.*;

public class NewItem {


    @FXML
    private void closeApp(){
        Platform.exit();
    }
}
