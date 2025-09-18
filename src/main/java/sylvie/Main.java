package sylvie;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sylvie.ui.MainWindow;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {
    private final Sylvie sylvie = new Sylvie("sylvie.txt");

    /**
     * Starts the GUI application.
     *
     * @param stage The primary stage for this application.
     */
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setResizable(false);
            fxmlLoader.<MainWindow>getController().setSylvie(sylvie);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
