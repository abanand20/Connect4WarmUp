package sample;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {

private Controller controller;

@Override
public void start(Stage primaryStage) throws Exception {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
    GridPane rootGridPane = loader.load();
    controller = loader.getController();
    controller.createPlayground();
    MenuBar menuBar=    createMenu();
    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
    Pane menuPane=(Pane)rootGridPane.getChildren().get(0);
    menuPane.getChildren().add(menuBar);
    Scene scene = new Scene(rootGridPane);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Game");
    primaryStage.show();
}

private MenuBar createMenu(){
	Menu FileMenu=new Menu("File");
	MenuItem newGame=new MenuItem("NewGame");
	newGame.setOnAction(event -> controller.resetGame());
	MenuItem resetGame=new MenuItem("ResetGame");
	resetGame.setOnAction(event ->controller.resetGame());
	SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
	MenuItem exitGame=new MenuItem("ExitGame");
	exitGame.setOnAction(event -> exitGame());
	FileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);
	Menu HelpMenu=new Menu("Help");
	MenuItem aboutGame=new MenuItem("About Game");
	aboutGame.setOnAction(event -> aboutGame());
	MenuItem aboutMe=new MenuItem("About Me");
	aboutMe.setOnAction(event -> aboutMe());
	HelpMenu.getItems().addAll(aboutGame,aboutMe);
	MenuBar menubar=new MenuBar();
	menubar.getMenus().addAll(FileMenu);
	menubar.getMenus().addAll(HelpMenu);
return menubar;
}

	private void aboutMe() {
	     Alert alert=new Alert(Alert.AlertType.INFORMATION);
	     alert.setTitle("About Me");
	     alert.setHeaderText("Abhinav Anand");
	     alert.setContentText("He is an awesome programmer");
	     alert.show();
	}

	private void aboutGame() {
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Game");
		alert.setHeaderText("Connect Four");
		alert.setContentText("This is a very Nice Game , It is played everywhere around the world");
		alert.show();
	}


	private void exitGame() {
	Platform.exit();
	System.exit(0);
	}

	public static void main(String args[]){
launch(args);

    }
}