package calculador;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class CalculadorMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("CalculadoraFXRSV.fxml"));
			Scene scene = new Scene(root,300,460);
			scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
			primaryStage.setTitle("CalculadoraFXRSV");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
