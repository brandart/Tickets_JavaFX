package code;
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		// Path to the FXML File
		String fxmlDocPath = System.getProperty("user.dir") + "/src/home.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		 
		TabPane root = (TabPane) loader.load(fxmlStream); 
		
		Scene scene = new Scene(root);
		// Set the Scene to the Stage
		stage.setScene(scene);
		// Set the Title to the Stage
		stage.setTitle("A simple FXML Example");
		// Display the Stage
		stage.show();
	}

}
