package code;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

public class Home {
	
	@FXML
	Tab verwalten;
	
	@FXML
	AnchorPane verwaltenAnchorPane;
	
	@FXML
	Tab erstellenTab;
	
	@FXML
	AnchorPane erstellenAnchor;
	
	@FXML
	Tab homeTab;
	
	@FXML
	Tab statistikTab;
	
	@FXML
	AnchorPane statistikAnchor;
	
	private SelectedTab selectedTab;
	@FXML
	public void initialize() {
		selectedTab = new SelectedTab();
		selectedTab.selected = homeTab;
		
	}
	
	@FXML
	public void erstellenTabChanged() throws IOException {
		if(selectedTab.selected.getId().equals("erstellenTab") == false) {
			AnchorPane newPane = loadPaneFromFile("/src/erstellen.fxml");
			erstellenAnchor.getChildren().setAll(newPane);
			
			selectedTab.selected = erstellenTab;
		}
	}
	
	@FXML
	public void statistikTabChanged() throws IOException {
		if(selectedTab.selected.getId().equals("statistikTab") == false) {
			AnchorPane newPane = loadPaneFromFile("/src/statistik.fxml");
			statistikAnchor.getChildren().setAll(newPane);
			
			selectedTab.selected = statistikTab;
		}
	}
	
	@FXML
	public void homeTabChanged() throws IOException {
		
	}
	
	
	
	@FXML
	public void verwaltenTab() throws IOException {
		if(selectedTab.selected.getId().equals("verwalten") == false) {
			AnchorPane newPane = loadPaneFromFile("/src/verwalten.fxml");
			verwaltenAnchorPane.getChildren().setAll(newPane);
			
			selectedTab.selected = verwalten;
		}
	}
	
	public AnchorPane loadPaneFromFile(String name) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		
		String fxmlDocPath = System.getProperty("user.dir") + name;
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		
		return loader.load(fxmlStream);
	}
}

class SelectedTab {
	@FXML
	public Tab selected;
	
	
	
}
