package sylvie.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import sylvie.Sylvie;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Sylvie sylvie;

    private final Image userImage = new Image(this.getClass().getResourceAsStream("/images/User.png"));
    private final Image sylvieImage = new Image(this.getClass().getResourceAsStream("/images/Sylvie.png"));

    /**
     * Initializes the main window, setting up the scroll pane and displaying the greeting message.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().add(
                DialogBox.getSylvieDialog(Sylvie.greet(), sylvieImage)
        );
    }

    /**
     * Injects the Sylvie instance
     */
    public void setSylvie(Sylvie s) {
        sylvie = s;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Sylvie's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = sylvie.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getSylvieDialog(response, sylvieImage)
        );
        userInput.clear();
    }
}
