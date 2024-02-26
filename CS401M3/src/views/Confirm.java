package views;

import java.io.File;
import java.nio.file.Paths;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Confirm {
	static boolean ans = false;
	public static boolean confirm (String message){
		Stage pop = new Stage();
		pop.initModality(Modality.APPLICATION_MODAL);		
		pop.setTitle("Alert");
		pop.setWidth(400);
		pop.setHeight(250);
		Label l1=new Label();
		l1.setText(message);
		l1.setStyle("-fx-text-fill: white;");
		Button yes = new Button("Yes");
		Button no = new Button("No");
		Media sound = new Media(new File("C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\seffects\\buttonsound.mp3").toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		yes.setOnAction(e-> {pop.close();
			mediaPlayer.play();	
			ans = true;
		});
		yes.setStyle("-fx-background-color : transparent; -fx-text-fill : white");
		yes.setOnMouseEntered(e -> {
			yes.setStyle("-fx-background-color: gray; -fx-border-color: black; -fx-border-width: 2px; -fx-text-fill: white ;");		
			});
	

		yes.setOnMouseExited(e -> {
			yes.setStyle("-fx-background-color:  transparent; -fx-text-fill : white");
		});
		
		
		no.setOnAction(e-> {pop.close();
		mediaPlayer.play();	
		ans = false;
	});
	no.setStyle("-fx-background-color : transparent; -fx-text-fill : white");
	no.setOnMouseEntered(e -> {
		no.setStyle("-fx-background-color: gray; -fx-border-color: black; -fx-border-width: 2px; -fx-text-fill: white ;");		
		});


	no.setOnMouseExited(e -> {
		no.setStyle("-fx-background-color:  transparent; -fx-text-fill : white");
	});
				VBox layout=new VBox();
		layout.getChildren().addAll(l1,yes,no);
		layout.setAlignment(Pos.CENTER);
		Image titleimg = new Image(Paths.get("C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\images\\Popup.jpg").toUri().toString());
		BackgroundImage backgroundImage = new BackgroundImage(titleimg,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundPosition.DEFAULT,
		        new BackgroundSize(1.0, 1.0, true, true, false, false));
		layout.setBackground(new Background(backgroundImage));
		Scene scene=new Scene(layout);
		pop.setScene(scene);
		pop.showAndWait();
		return ans;
	}
}
