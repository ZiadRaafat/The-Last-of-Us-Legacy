package views;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import model.characters.Character;
import model.characters.Direction;
import model.characters.Explorer;
import model.characters.Fighter;
import model.characters.Hero;
import model.characters.Medic;
import model.characters.Zombie;
import model.collectibles.Vaccine;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;
import engine.Game;
import exceptions.GameActionException;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GUI extends Application{

	Stage window;
	Scene startp, selection,presc,h2p,load;
	Button closegame,returnmm,begin;
	static String type;
	static int count =0;
	Scene gamec;
	GridPane center;
	Hero curr;
	Character tar;
	ArrayList <Button> cells = new ArrayList<>();
	BorderPane gamemap;
	VBox sp = new VBox();
	ArrayList <VBox> VB = new ArrayList<>();
	ArrayList<Image> charac = new ArrayList<>();
	Scene vic;
	Scene gameover;
	Button win;
	Button lose;
	static boolean chc=false;
	public void init() throws IOException{
		Game.loadHeroes("C:\\Users\\ZIAD\\eclipse-workspace\\CS401M3\\Heroes.csv");
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		window=primaryStage;
		window.setOnCloseRequest(e -> {
			e.consume();
			closeGame();
		});
		
		 Image icon = new Image(getClass().getResourceAsStream("icon.jpg"));
	        window.getIcons().add(icon);
		
		String titlemusic="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\music\\titlemusic1.mp3";
		String mapmusic="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\music\\mapmusic.mp3";
		String buttonsound="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\seffects\\buttonsound.mp3";
		String howtoplay="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\images\\howtoplay.jpg";
		String titlescreen="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\images\\howtoplay.jpg";
		String winmusic="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\music\\win2.mp3";
		String losemusic="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\music\\lose.mp3";
		String border="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\map\\border.jpg";
		String pscreen="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\images\\prescreen.jpg";
		String lscreen="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\images\\loadingscreen2.jpg";
		String zombie="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\images\\zombie.gif";
		String select="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\images\\selection.jpg";
		String heroselect="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\music\\selecthero.mp3";
		String mapbg="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\map\\mapbackground.png";
		String zombiehit="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\seffects\\zombiehit.mp3";
		String zombiesnarl="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\seffects\\zombiesnarl.mp3";
		String movesound="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\seffects\\commandsound.mp3";
		String trapsound="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\seffects\\trapsound.mp3";
		
		Image zack = new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/sprites/zack.png");
		Image garnet = new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/sprites/garnet.png");
		Image rikku = new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/sprites/rikku.png");
		Image alisae = new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/sprites/alisae.png");
		Image zidane = new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/sprites/zidane.png");
		Image sora = new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/sprites/sora.png");
		Image cloud = new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/sprites/cloud.png");
		Image noct = new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/sprites/noctis.png");
		
		charac.add(zack);charac.add(garnet);charac.add(rikku);charac.add(alisae);charac.add(zidane);charac.add(sora);charac.add(cloud);charac.add(noct);
		win=new Button("You Win! Exit Game");
		lose=new Button("You Lose! Exit Game");
		setButtonStyle(win);
		setButtonStyle(lose);
		
		
		DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        dropShadow.setRadius(5); 
        dropShadow.setSpread(3);
        
        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setColor(Color.BLACK);
        dropShadow2.setRadius(2); 
        dropShadow2.setSpread(2);
        
        
		Media media = new Media(new File(titlemusic).toURI().toString());
		MediaPlayer musictitle = new MediaPlayer(media);
		musictitle.setCycleCount(MediaPlayer.INDEFINITE);
		Media medias = new Media(new File(heroselect).toURI().toString());
		MediaPlayer  selectHero= new MediaPlayer(medias);
		musictitle.setCycleCount(MediaPlayer.INDEFINITE);
		Media sound = new Media(new File(buttonsound).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		Media mediamap = new Media(new File(mapmusic).toURI().toString());
		MediaPlayer mediaMap = new MediaPlayer(mediamap);
		mediaMap.setCycleCount(MediaPlayer.INDEFINITE);
		
		Media winMusic = new Media(new File(winmusic).toURI().toString());
		MediaPlayer winM = new MediaPlayer(winMusic);
		winM.setCycleCount(MediaPlayer.INDEFINITE);
		
		Media loseMusic = new Media(new File(losemusic).toURI().toString());
		MediaPlayer loseM = new MediaPlayer(loseMusic);
		
		Media movesound1 = new Media(new File(movesound).toURI().toString());
		MediaPlayer msound = new MediaPlayer(movesound1);
		
		Media trapsound1 = new Media(new File(trapsound).toURI().toString());
		MediaPlayer tsound = new MediaPlayer(trapsound1);
		
		
		
		VBox h2=new VBox();
		h2.setSpacing(5);
		Label h2t=new Label("  Instructions: ");
	
		VBox.setMargin(h2t, new Insets(350, 350, 350, 350));
		h2t.setStyle("-fx-background-color : transparent; -fx-text-fill : white");
		h2t.setStyle("-fx-text-fill: white;");
		h2t.setEffect(dropShadow);
	     Label h3t=new Label("The Last of Us: Legacy is a single player survival game set in a zombie apocalyptic world. The game is conducted in a turn based manner, in which each player character receives a specific number of action points per turn, which they can use to move, attack or cure zombies, or use special actions. The player starts the game controlling only one hero, but can gain additional heroes by curing zombies. The objective of the game for the player is to survive as long as it takes in order to cure a sufficient number of zombies enough to build a community to survive the apocalypse.");
	  
	     h3t.setEffect(dropShadow);
		h2t.setUnderline(true);
		h2t.setTranslateY(-200);
		h3t.setTranslateY(-400);
		returnmm=new Button("Return to Main Menu");
		returnmm.setEffect(dropShadow);
		setButtonStyle(returnmm);
		
		returnmm.setOnAction(e ->{ window.setScene(startp);
		window.setFullScreenExitHint("");
		mediaPlayer.play();	
		window.setFullScreen(true);
		
		
	
		});
		Label h4t=new Label("The game takes place in a 15x15 grid. Only grids that are adjacent to a hero are visible and remain so until the end of the turn. Watch out for zombies! Throughout the game, there are collectibles called 'supplies' and 'vaccines' to be collected. Vaccines are used to be able to cure a zombie allowing it to turn into a hero and join your team. Supplies are used to let heroes execute their special actions. Each hero class has a unique action, costing 1 supply. Explorers are able to let the entirety of the map be visible for 1 turn. Medics can restore health to themselves or to an adjacent hero. Fighters can attack as many times for the duration of the turn without losing any action points. Beware of trap cells, as they are randomly placed on the map and stepping on one can damage the hero and potentially remove them from the game.");
		Label h5t=new Label("The player starts off in the 15x15 grid map with just one hero and 10 zombies. The player then keeps taking their turn trying to collect vaccines, and cure or kill zombies. The game ends when the player has collected and used all vaccines or when all heroes have been overwhelmed and defeated by the zombies. The player only wins if they have successfully collected and used all vaccines and have 5 or more heroes alive.");
		h5t.setEffect(dropShadow);
		setLabelStyle(h5t);
		setLabelStyle(h4t);
		h4t.setStyle("-fx-text-fill: white;");
		h4t.setEffect(dropShadow);
		h3t.setStyle(" -fx-text-fill: white;");
		h4t.setTranslateY(-300);
		h5t.setTranslateY(-200);
		h5t.setEffect(dropShadow);
		h2.getChildren().addAll(h2t,h3t,h4t,h5t,returnmm);
		h2.setAlignment(Pos.TOP_CENTER);
		VBox.setMargin(h3t, new Insets(0, 0, 0, 10));
		h2t.setFont(new Font(50));
		h3t.setFont(new Font(30));
		h3t.setWrapText(true);
		Image howto = new Image(Paths.get(howtoplay).toUri().toString());
		BackgroundImage backgroundImage1 = new BackgroundImage(howto,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundPosition.DEFAULT,
		        new BackgroundSize(1.0, 1.0, true, true, false, false));
		h2.setBackground(new Background(backgroundImage1));
		
		
		h2p=new Scene(h2,2000,1000);
		 closegame = new Button("Exit Game");
		
		Button start = new Button("Start Game");
		
		Button how=new Button("How to Play");
		setButtonStyle(start);
		setButtonStyle(how);
		
		returnmm.setPrefWidth(700);
		returnmm.setFont(new Font(50));
		setButtonStyle(closegame);
		
	
		
		
		
		Text text = new Text("The Last of Us: Legacy");
		text.setStyle("-fx-font-size:100");
		text.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		text.setFill(Color.WHITE);
		text.setEffect(dropShadow);
		text.setUnderline(true);
		FadeTransition ft = new FadeTransition(Duration.millis(3000), text);
		ft.setFromValue(0.0);
		ft.setToValue(2.0);
		ft.play();
                                                                    
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(5);
        grid.setHgap(0);
        GridPane.setConstraints(text,3,10);
        GridPane.setConstraints(start,3,25);
        GridPane.setConstraints(how,3,30);
        GridPane.setConstraints(closegame,3,35);
        start.setEffect(dropShadow);
        how.setEffect(dropShadow);
        closegame.setEffect(dropShadow);
        grid.getChildren().addAll(text,start,how,closegame);
        startp= new Scene(grid,2000,1000);



		start.setOnAction(e ->{ window.setScene(selection);
		mediaPlayer.play();	
		musictitle.stop();
		});
		how.setOnAction(e ->{ window.setScene(h2p);
		window.setFullScreenExitHint("");
		mediaPlayer.play();	
		window.setFullScreen(true);
		
		
	
		});
		returnmm.setOnAction(e ->{ window.setScene(startp);
		window.setFullScreenExitHint("");
		mediaPlayer.play();	
		window.setFullScreen(true);
		
		
	
		});
       
		
		
		
		
	
		
		
		ProgressBar pb=new ProgressBar();
		pb.setPrefWidth(100);
		 pb.setStyle("-fx-accent: green;");
		

        Timeline t = new Timeline(
        		 new KeyFrame(Duration.ZERO, new KeyValue(pb.progressProperty(), 0)),
        		    new KeyFrame(Duration.seconds(5), new KeyValue(pb.progressProperty(), 1))
                
        );
    	t.setOnFinished(e -> {
    		chc=true;
            window.setScene(selection);
            window.show();
            window.setFullScreenExitHint("");
			window.setFullScreen(true);
			selectHero.play();
        });
        
                     
    	
       Button leftArrowButton = new Button();
       Button rightArrowButton=new Button();
       rightArrowButton.setPrefHeight(30);
       rightArrowButton.setPrefWidth(30);
       Image arrowImage = new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/images/arrowleft.png");
       ImageView leftArrowImageView = new ImageView(arrowImage);
       leftArrowImageView.setFitWidth(200);
       leftArrowImageView.setFitHeight(200);
       leftArrowButton.setGraphic(leftArrowImageView);
       leftArrowButton.setStyle("-fx-background-color: transparent;");
       
       Image arrowImage2 = new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/images/arrowleft2.png");
       ImageView leftArrowImageView2 = new ImageView(arrowImage2);
       leftArrowImageView2.setFitWidth(200);
       leftArrowImageView2.setFitHeight(200);
       
       Image arrowImage22 = new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/images/arrowleft3.png");
       ImageView leftArrowImageView22 = new ImageView(arrowImage22);
       leftArrowImageView22.setFitWidth(200);
       leftArrowImageView22.setFitHeight(200);
       
       Image arrowImage3 = new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/images/arrowright2.png");
       ImageView rightArrowImageView3 = new ImageView(arrowImage3);
       rightArrowImageView3.setFitWidth(200);
       rightArrowImageView3.setFitHeight(200);
       
       Image arrowImage33 = new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/images/arrowright3.png");
       ImageView rightArrowImageView33 = new ImageView(arrowImage33);
       rightArrowImageView33.setFitWidth(200);
       rightArrowImageView33.setFitHeight(200);
       
       
      
       Image arrowImages = new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/images/arrowright.png");
       ImageView rightArrowImageView = new ImageView(arrowImages);
       rightArrowImageView.setFitWidth(200);
       rightArrowImageView.setFitHeight(200);
       rightArrowButton.setGraphic(rightArrowImageView);
       rightArrowButton.setStyle("-fx-background-color: transparent;");
       GridPane choose = new GridPane(); 
       ImageView characView=new ImageView(charac.get(count));
       characView.setFitWidth(150);
	   characView.setFitHeight(150);
	   Text pick=new Text("Select Your Hero!");
		 pick.setFont(Font.font("Arial", 18));
	        pick.setFill(Color.WHITE);
	        pick.setUnderline(true);
	        if(Game.availableHeroes.get(count) instanceof Fighter)
	        	type="FIGH";
	        else if(Game.availableHeroes.get(count) instanceof Medic)
	        	type="MED";
	        else
	        	type="EXP";
	        Text desc=new Text(Game.availableHeroes.get(count).getName()+"\n Class: "+type+"\n Health Points: "+Game.availableHeroes.get(count).getMaxHp()+"\n Attack Damage: "+Game.availableHeroes.get(count).getAttackDmg()+"\n Actions Per Turn: "+Game.availableHeroes.get(count).getMaxActions());
            desc.setStyle("-fx-fill: white;");
            desc.setEffect(dropShadow);
            desc.setFont(Font.font("Arial", 15));
            begin=new Button("Engage!");
            setButtonStyle(begin);
            begin.setEffect(dropShadow);
            
	   choose.getChildren().addAll(pick,leftArrowButton,rightArrowButton,characView,desc,begin);
       choose.setAlignment(Pos.CENTER);
		leftArrowButton.setPrefWidth(5);
		rightArrowButton.setPrefHeight(5);
	    GridPane.setConstraints(pick,0,0);
	    
		
		
		
		
		pick.setTranslateY(-300);
		pick.setFont(Font.font("Arial", 90));
		pick.setEffect(dropShadow);
		rightArrowButton.setTranslateX(900);
		leftArrowButton.setTranslateX(-200);
		characView.setTranslateX(350);
	    desc.setTranslateX(300);
	    desc.setTranslateY(200);
	    begin.setTranslateX(150);
	    begin.setTranslateY(300);
		
	
	    
	    begin.setOnAction(e->{
	    		Game.startGame(Game.availableHeroes.get(count));
	    		startMap();
	    		crV();
	    		createVBox();
				window.setScene(gamec);
				window.setFullScreenExitHint("");
				window.setFullScreen(true);
				selectHero.stop();
				mediaMap.play();
			});
	    
	    
	    leftArrowButton.setOnMouseEntered(e->{
		leftArrowButton.setGraphic(leftArrowImageView2);	
		});
		leftArrowButton.setOnMouseExited(e -> {
			 leftArrowButton.setGraphic(leftArrowImageView);
			
		});
		
		rightArrowButton.setOnMouseEntered(e->{
			rightArrowButton.setGraphic(rightArrowImageView3);	
			});
		rightArrowButton.setOnMouseExited(e -> {
			 rightArrowButton.setGraphic(rightArrowImageView);
			
		});
		PauseTransition leftTransition = new PauseTransition(Duration.seconds(0.1));
        leftTransition.setOnFinished(e -> leftArrowButton.setGraphic(leftArrowImageView2));
        leftArrowButton.setOnMouseClicked(e -> {                     
            leftArrowButton.setGraphic(leftArrowImageView22);
            leftTransition.play();
            count--;
            if(count==-1)
            	count=7;
            if(Game.availableHeroes.get(count) instanceof Fighter)
	        	type="FIGH";
	        else if(Game.availableHeroes.get(count) instanceof Medic)
	        	type="MED";
	        else
	        	type="EXP";
            characView.setImage(charac.get(count));
            desc.setText(Game.availableHeroes.get(count).getName()+"\n Class: "+type+"\n Health Points: "+Game.availableHeroes.get(count).getMaxHp()+"\n Attack Damage: "+Game.availableHeroes.get(count).getAttackDmg()+"\n Actions Per Turn: "+Game.availableHeroes.get(count).getMaxActions());
        });

        PauseTransition rightTransition = new PauseTransition(Duration.seconds(0.1));
        rightTransition.setOnFinished(e -> rightArrowButton.setGraphic(rightArrowImageView3));
        rightArrowButton.setOnMouseClicked(e -> {
            rightArrowButton.setGraphic(rightArrowImageView33);
            rightTransition.play();
            count++;
            if(count==8)
            	count=0;
            if(Game.availableHeroes.get(count) instanceof Fighter)
	        	type="FIGH";
	        else if(Game.availableHeroes.get(count) instanceof Medic)
	        	type="MED";
	        else
	        	type="EXP";
            characView.setImage(charac.get(count));   
            desc.setText(Game.availableHeroes.get(count).getName()+"\n Class: "+type+"\n Health Points: "+Game.availableHeroes.get(count).getMaxHp()+"\n Attack Damage: "+Game.availableHeroes.get(count).getAttackDmg()+"\n Actions Per Turn: "+Game.availableHeroes.get(count).getMaxActions());
        });
		
	
        
        
        
		
		
		
		 Image selecs = new Image(Paths.get(select).toUri().toString());
		BackgroundImage backgroundImagess = new BackgroundImage(selecs,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundPosition.DEFAULT,
		        new BackgroundSize(1.0, 1.0, true, true, false, false));
		choose.setBackground(new Background(backgroundImagess));
		selection = new Scene (choose,1400,700);
	
		                //--------------MAP---------------\\

		  gamemap = new BorderPane();
			 Image mapbackg= new Image(Paths.get(mapbg).toUri().toString());
				BackgroundImage mbg = new BackgroundImage(mapbackg,
				        BackgroundRepeat.NO_REPEAT,
				        BackgroundRepeat.NO_REPEAT,
				        BackgroundPosition.DEFAULT,
				        new BackgroundSize(1.0, 1.0, true, true, false, false));
				
				 Image borderimg= new Image(Paths.get(border).toUri().toString());
					BackgroundImage bimg = new BackgroundImage(borderimg,
					        BackgroundRepeat.NO_REPEAT,
					        BackgroundRepeat.NO_REPEAT,
					        BackgroundPosition.DEFAULT,
					        new BackgroundSize(1.0, 1.0, true, true, false, false));	
				
				
				
		 center = new GridPane(); 
		 center.setPadding(new Insets(5));
		 center.setHgap(5);
		 center.setVgap(5);
		 center.setBackground(new Background(mbg));
		 Label tt = new Label("Game Start!");
		 tt.setStyle("-fx-text-fill : white");
		 tt.setEffect(dropShadow);
		win.setOnAction(e ->window.close());
		lose.setOnAction(e ->window.close());
		 VBox vict = new VBox();
         Image victory = new Image(Paths.get("C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\images\\victory.png").toUri().toString());
        BackgroundImage tory = new BackgroundImage(victory,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        vict.setBackground(new Background(tory));
         vic = new Scene(vict);
         win.setStyle("-fx-background-color:black");
         lose.setStyle("-fx-background-color:gray");
         vict.getChildren().add(win);
         
    VBox go = new VBox();
    Text gos=new Text("Game Over");
    gos.setFont(Font.font("Impact",FontWeight.BOLD,FontPosture.REGULAR,50));
    Image over = new Image(Paths.get("C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\images\\MenuScreen1.jpg").toUri().toString());
    BackgroundImage gover = new BackgroundImage(over,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(1.0, 1.0, true, true, false, false));
    go.setBackground(new Background(gover));
    go.getChildren().addAll(lose,gos);
     gameover = new Scene(go);
		   
		    
		 Button attack = new Button("Attack");
		 attack.setOnAction(e -> {
			 if(curr != null){
					 curr.setTarget(tar);
					 try{
						 attack.setStyle("-fx-background-color: #004d00;-fx-text-fill : white");
						 curr.attack();
						 tar=null;
						 Media zhit = new Media(new File(zombiehit).toURI().toString());
							MediaPlayer zhit2 = new MediaPlayer(zhit);
							zhit2.play();
					 }catch(GameActionException v){
						 Popup.pop(v.getMessage());
					 }
					 tt.setText("You attacked a zombie");
					 updateVBox();
					 update();
					 javafx.concurrent.Task<Void> task = new javafx.concurrent.Task<>() {
				            @Override
				            protected Void call() {
				                try {
				                    Thread.sleep(50);
				                } catch (InterruptedException e) {
				                    e.printStackTrace();
				                }
				                return null;
				            }
				        };

				        task.setOnSucceeded(event -> {
				           
				            attack.setStyle("-fx-background-color: green; -fx-text-fill: white");
				        });

				        new Thread(task).start();
					 if(Game.checkWin()) {
							window.setScene(vic);
							mediaMap.stop();
							winM.play();
							 window.setFullScreenExitHint("");
								window.setFullScreen(true);
						 }
					 else    if(Game.checkGameOver()) {
			            	
			                 window.setScene(gameover);
			                 mediaMap.stop();
			                 loseM.play();
			                 window.setFullScreenExitHint("");
								window.setFullScreen(true);
			             }
				 }
		 });
		
		 
		 Button move = new Button("Move");
		 move.setOnAction(e ->{
			
			 if(curr != null){
				 gamec.setOnKeyPressed(event -> {
					 event.consume();
					 int tx = 0;
					 int ty = 0;
					 boolean bool = false;
					 tt.setText("You can move now");
					    if (event.getCode() == KeyCode.W) {
					        try{
					        	 tx = curr.getLocation().x+1;
								  ty = curr.getLocation().y;
					        if(Game.map[tx][ty] instanceof TrapCell)
					        	bool=true;
					    	curr.move(Direction.UP);
					    	
					        }catch(GameActionException v){
					        	Popup.pop(v.getMessage());
					        }catch(Exception v) {
					        	Popup.pop("Out of bounds!");
					        }
					        if(bool) {
					    		tt.setText("You walked into a trap!");
					    		 tsound.stop();
						    	 tsound.seek(Duration.ZERO);
						         tsound.play();
					    	}
					        updateVBox();
					        update();
					        if(Game.checkWin()) {
								window.setScene(vic);
								mediaMap.stop();
								winM.play();
								 window.setFullScreenExitHint("");
									window.setFullScreen(true);
							 }
						 else    if(Game.checkGameOver()) {
				            	
				                 window.setScene(gameover);
				                 mediaMap.stop();
				                 loseM.play();
				                 window.setFullScreenExitHint("");
									window.setFullScreen(true);
				             }
					 }
					    if (event.getCode() == KeyCode.A) {
					    	try{
					    		tx = curr.getLocation().x;
								  ty = curr.getLocation().y-1;
					    		if(Game.map[tx][ty] instanceof TrapCell)
						        	bool=true;
						    	curr.move(Direction.LEFT);
						        }catch(GameActionException v){
						        	Popup.pop(v.getMessage());
						        }catch(Exception v) {
						        	Popup.pop("Out of bounds");
						        }
					    	if(bool) {
					    		tt.setText("You walked into a trap!");
					    		 tsound.stop();
						    	 tsound.seek(Duration.ZERO);
						         tsound.play();
					    	}
					    	updateVBox();
					    	update();
					    	 if(Game.checkWin()) {
									window.setScene(vic);
									mediaMap.stop();
									winM.play();
									 window.setFullScreenExitHint("");
										window.setFullScreen(true);
								 }
							 else    if(Game.checkGameOver()) {
					            	
					                 window.setScene(gameover);
					                 mediaMap.stop();
					                 loseM.play();
					                 window.setFullScreenExitHint("");
										window.setFullScreen(true);
					             }
					 }
					    if (event.getCode() == KeyCode.S) {
					    	try{
					    		tx = curr.getLocation().x-1;
								  ty = curr.getLocation().y;
					    		if(Game.map[tx][ty] instanceof TrapCell)
						        	bool=true;
						    	curr.move(Direction.DOWN);
						        }catch(GameActionException v){
						        	Popup.pop(v.getMessage());
						        }catch(Exception v) {
						        	Popup.pop("Out of bounds");
						        }
					    	if(bool) {
					    		tt.setText("You walked into a trap!");
					    		 tsound.stop();
						    	 tsound.seek(Duration.ZERO);
						         tsound.play();
					    	}
					    	updateVBox();
					    	update();
					    	 if(Game.checkWin()) {
									window.setScene(vic);
									mediaMap.stop();
									winM.play();
									 window.setFullScreenExitHint("");
										window.setFullScreen(true);
								 }
							 else    if(Game.checkGameOver()) {
					            	
					                 window.setScene(gameover);
					                 mediaMap.stop();
					                 loseM.play();
					                 window.setFullScreenExitHint("");
										window.setFullScreen(true);
					             }
					 }
					    if (event.getCode() == KeyCode.D) {
					    	try {
					    		tx = curr.getLocation().x;
								  ty = curr.getLocation().y+1;
					    		if(Game.map[tx][ty] instanceof TrapCell)
						        	bool=true;
						    	curr.move(Direction.RIGHT);
						        }catch(GameActionException v){
						        	Popup.pop(v.getMessage());
						        }catch(Exception v) {
						        	Popup.pop("Out of bounds");
						        }
					    	if(bool) {
					    		tt.setText("You walked into a trap!");
					    		 tsound.stop();
						    	 tsound.seek(Duration.ZERO);
						         tsound.play();
					    	}
					    	updateVBox();
							 update();
							 if(Game.checkWin()) {
									window.setScene(vic);
									mediaMap.stop();
									winM.play();
									 window.setFullScreenExitHint("");
										window.setFullScreen(true);
								 }
							 else    if(Game.checkGameOver()) {
					            	
					                 window.setScene(gameover);
					                 mediaMap.stop();
					                 loseM.play();
					                 window.setFullScreenExitHint("");
										window.setFullScreen(true);
					             }
					 }
			  });
				 
				 
			 }
		 });
				 
		 
		 Button cure = new Button ("Cure");
		 Media cures = new Media(new File("C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\seffects\\cure.mp3").toURI().toString());
			MediaPlayer cures2 = new MediaPlayer(cures);
		 cure.setOnAction(e -> {
			 
			 if(curr != null){
				 curr.setTarget(tar);
				 try{
					
					 curr.cure();
					 tar= null;
					 cures2.stop();
			    	    cures2.seek(Duration.ZERO);
			          
					 cures2.play();
				 }catch(GameActionException v){
					 Popup.pop(v.getMessage());
				 }
				 tt.setText("You cured a zombie");
				updateVBox();
				 update();
				 if(Game.checkWin()) {
						window.setScene(vic);
						mediaMap.stop();
						winM.play();
						 window.setFullScreenExitHint("");
							window.setFullScreen(true);
					 }
				 else    if(Game.checkGameOver()) {
		            	
		                 window.setScene(gameover);
		                 mediaMap.stop();
		                 loseM.play();
		                 window.setFullScreenExitHint("");
							window.setFullScreen(true);
		             }
			 }
		 });
		 Button special = new Button ("Special Move");
		 special.setOnAction(e ->{
			if(curr != null){
				if(curr instanceof Fighter){
					try{
						curr.useSpecial();
					}catch(GameActionException v){
						Popup.pop(v.getMessage());
					}
					tt.setText("Special move has been activated");
					updateVBox();
					update();
					 if(Game.checkWin()) {
							window.setScene(vic);
							mediaMap.stop();
							winM.play();
							 window.setFullScreenExitHint("");
								window.setFullScreen(true);
						 }
					 else    if(Game.checkGameOver()) {
			            	
			                 window.setScene(gameover);
			                 mediaMap.stop();
			                 loseM.play();
			                 window.setFullScreenExitHint("");
								window.setFullScreen(true);
			             }
				}
				else if(curr instanceof Explorer){
					try{
						curr.useSpecial();
					}catch(GameActionException v){
						Popup.pop(v.getMessage());
					}
					tt.setText("Special move has been activated");
					updateVBox();
					update();
					 if(Game.checkWin()) {
							window.setScene(vic);
							mediaMap.stop();
							winM.play();
							 window.setFullScreenExitHint("");
								window.setFullScreen(true);
						 }
					 else    if(Game.checkGameOver()) {
			            	
			                 window.setScene(gameover);
			                 mediaMap.stop();
			                 loseM.play();
			                 window.setFullScreenExitHint("");
								window.setFullScreen(true);
			             }
				}
				else{
					curr.setTarget(tar);
					try{
						 curr.useSpecial();
					 }catch(GameActionException v){
						 Popup.pop(v.getMessage());
					 }
					tt.setText("Special move has been activated");
					updateVBox();
					 update();
					 if(Game.checkWin()) {
							window.setScene(vic);
							mediaMap.stop();
							winM.play();
							 window.setFullScreenExitHint("");
								window.setFullScreen(true);
						 }
					 else    if(Game.checkGameOver()) {
			            	
			                 window.setScene(gameover);
			                 mediaMap.stop();
			                 loseM.play();
			                 window.setFullScreenExitHint("");
								window.setFullScreen(true);
			             }
				}
			}
		 });
		 Button end = new Button ("End Turn");
		 end.setOnAction(e ->{
			 try{
			 Game.endTurn();
			 Media zsnarl = new Media(new File(zombiesnarl).toURI().toString());    
				MediaPlayer zsnarl2 = new MediaPlayer(zsnarl);
				 zsnarl2.play();
			 
			 }catch(GameActionException v){
				 Popup.pop(v.getMessage());
			 }
			
			 tt.setText("Turn Ended");
			 updateVBox();
			 update();
			 if(Game.checkWin()) {
					window.setScene(vic);
					mediaMap.stop();
					winM.play();
					 window.setFullScreenExitHint("");
						window.setFullScreen(true);
				 }
			 else    if(Game.checkGameOver()) {
	            	
	                 window.setScene(gameover);
	                 mediaMap.stop();
	                 loseM.play();
	                 window.setFullScreenExitHint("");
						window.setFullScreen(true);
	             }
		 });
		 
		
		 
		 center.setAlignment(Pos.CENTER);
		 
		 VBox opt = new VBox();
		 opt.setSpacing(10);
		 move.setStyle("-fx-background-color: green; -fx-text-fill : white");
		 attack.setStyle("-fx-background-color: green; -fx-text-fill : white");           ///////////////////////////////////////////////////////////////
		 cure.setStyle("-fx-background-color: green; -fx-text-fill : white");
		 special.setStyle("-fx-background-color: green; -fx-text-fill : white");
		 end.setStyle("-fx-background-color: green; -fx-text-fill : white");
		
		 opt.getChildren().addAll(move,attack,cure,special,end);
		
	
		 gamemap.setBottom(tt);
	     
		 gamemap.setCenter(center);	  
		 gamemap.setRight(opt); 
		 gamemap.setLeft(sp);
		 gamec = new Scene(gamemap);
		 gamemap.setBackground(new Background(bimg));
		
		
		
	
       Text loadingtext=new Text("Loading...");
       loadingtext.setFont(Font.font("Arial", 100));
       loadingtext.setFill(Color.WHITE);
       loadingtext.setEffect(dropShadow);
       pb.setPrefWidth(1000);
       pb.setPrefHeight(60);
       ImageView gifImageView = new ImageView();
       Image gifImage = new Image((Paths.get(zombie ).toUri().toString()));
       gifImageView.setFitWidth(400);
       gifImageView.setFitHeight(500);
       gifImageView.setPreserveRatio(true);
       gifImageView.setImage(gifImage);
		VBox loading=new VBox();                                     
		loading.getChildren().addAll(gifImageView,loadingtext,pb);
		loading.setAlignment(Pos.CENTER);
	    
		load=new Scene(loading);
		Image loadingscreen = new Image(Paths.get(lscreen).toUri().toString());
		BackgroundImage backgroundImages = new BackgroundImage(loadingscreen,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundPosition.DEFAULT,
		        new BackgroundSize(1.0, 1.0, true, true, false, false));
		loading.setBackground(new Background(backgroundImages));
		
		start.setOnAction(e -> {
			window.setScene(load);
			 window.setFullScreenExitHint("");
			window.setFullScreen(true);
			musictitle.stop();
			 t.setCycleCount(1);
		        t.play();
		       	
			
		        
		
		});  
	
		
		
		Image titleimg = new Image(Paths.get(titlescreen).toUri().toString());
		BackgroundImage backgroundImage = new BackgroundImage(titleimg,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundRepeat.NO_REPEAT,
		        BackgroundPosition.DEFAULT,
		        new BackgroundSize(1.0, 1.0, true, true, false, false));
		grid.setBackground(new Background(backgroundImage));
		
		
		
		 VBox prescreen = new VBox(20);
	     presc = new Scene(prescreen, 1400,700); 
	     Image titleimg2 = new Image(Paths.get(pscreen).toUri().toString());
			BackgroundImage backgroundImage2 = new BackgroundImage(titleimg2,
			        BackgroundRepeat.NO_REPEAT,
			        BackgroundRepeat.NO_REPEAT,
			        BackgroundPosition.DEFAULT,
			        new BackgroundSize(1.0, 1.0, true, true, false, false));
			prescreen.setBackground(new Background(backgroundImage2));
		 
		 Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
               window.setScene(startp);
               window.setFullScreen(true);
               musictitle.play();
			}));
			timeline.play();
			start.setShape(new Polygon(0.0, 0.0, 50.0, 0.0, 75.0, 50.0, 25.0, 50.0));
			how.setShape(new Polygon(0.0, 0.0, 50.0, 0.0, 75.0, 50.0, 25.0, 50.0));
			closegame.setShape(new Polygon(0.0, 0.0, 50.0, 0.0, 75.0, 50.0, 25.0, 50.0));
			
		 
		window.setScene(presc);
		window.setTitle("The Last of Us: Legacy");
		window.show();
		
	}
	public void setButtonStyle(Button b){
		b.setPrefWidth(700);
		b.setFont(new Font(50));
		b.setStyle("-fx-background-color : transparent; -fx-text-fill : white");
		b.setOnMouseEntered(e -> {
			b.setStyle("-fx-background-color: gray; -fx-border-color: black; -fx-border-width: 2px; -fx-text-fill: white ;");
			});
		b.setOnMouseExited(e -> {
			b.setStyle("-fx-background-color:  transparent; -fx-text-fill : white");
		});
		b.setOnAction(e->{;
		b.setStyle("-fx-background-color:  transparent; -fx-text-fill : white");
		b.setStyle("-fx-background-color:  transparent; -fx-text-fill : white");
		Media sound = new Media(new File("C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\seffects\\buttonsound.mp3").toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		if (b==closegame)
			closeGame();});
		b.setShape(new Polygon(0.0, 0.0, 50.0, 0.0, 75.0, 50.0, 25.0, 50.0));
	}
	public void closeGame(){
		
		boolean ans = Confirm.confirm("Are you sure you want to exit the game?");
		if(ans)	
		window.close();
	}
	public static void main(String[] args){
		launch(args);
	}
	public void setLabelStyle(Label l){
		l.setStyle("-fx-text-fill : white");
		l.setStyle("-fx-text-fill: white;");
		l.setFont(new Font(30));
		l.setWrapText(true);
		
	}

	public void update(){
		center.getChildren().clear();
		for(int i=0; i<15; i++){
			 for(int j=0; j<15; j++){
				 Button cell = new Button();
				 getcell(cell,i,j);
				 cell.setPrefSize(70,70);
				 center.add(cell, j,14-i);
				 cell.setOnAction(e -> {
						int col = GridPane.getColumnIndex(cell);
						int row = GridPane.getRowIndex(cell);
						if(Game.map[14-row][col] instanceof CharacterCell)
							tar =((CharacterCell)(Game.map[14-row][col])).getCharacter();
						else
							tar = null;
						
					});
			 }
		 }

		
	}
	public void getcell(Button c,int i, int j){
		if(chc){
		if(!Game.map[i][j].isVisible()){
			Image darkt = new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/map/darktile.jpg");
			ImageView dark=new ImageView(darkt);
			//c.setGraphic(dark);
		   // dark.setFitWidth(50);
			//dark.setFitHeight(50);
			  c.setStyle("-fx-background-color: black; -fx-text-fill: white;");
			  
		
			
			
		}
		else if(Game.map[i][j] instanceof CharacterCell){
		if(((CharacterCell)(Game.map[i][j])).getCharacter() instanceof Hero){
				if (((CharacterCell)(Game.map[i][j])).getCharacter().getName().equals("Joel Miller")){
					Image zackt=new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/map/zacktile.png");
				    ImageView zack=new ImageView(zackt);
				    c.setStyle("-fx-background-color: green; -fx-text-fill: white;");
				    c.setGraphic(zack);
				    zack.setFitWidth(50);
					zack.setFitHeight(50);
				}
				if (((CharacterCell)(Game.map[i][j])).getCharacter().getName().equals("Ellie Williams")){
					Image garnett=new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/map/garnettile.png");
				    ImageView garnet=new ImageView(garnett);
				    c.setStyle("-fx-background-color: green; -fx-text-fill: white;");
				    c.setGraphic(garnet);
				    garnet.setFitWidth(50);
					garnet.setFitHeight(50);
				
				}
				if (((CharacterCell)(Game.map[i][j])).getCharacter().getName().equals("Tess")){
					Image rikkut=new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/map/rikkutile.png");
				    ImageView rikku=new ImageView(rikkut);
				    c.setStyle("-fx-background-color: green; -fx-text-fill: white;");
				    c.setGraphic(rikku);
				    rikku.setFitWidth(50);
					rikku.setFitHeight(50);
					
				}
				if (((CharacterCell)(Game.map[i][j])).getCharacter().getName().equals("Riley Abel")){
					Image alisaet=new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/map/alisaetile.png");
				    ImageView alisae=new ImageView(alisaet);
				    c.setStyle("-fx-background-color: green; -fx-text-fill: white;");
				    c.setGraphic(alisae);
				    alisae.setFitWidth(50);
					alisae.setFitHeight(50);
				}
				if (((CharacterCell)(Game.map[i][j])).getCharacter().getName().equals("Tommy Miller")){
					Image zidanet=new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/map/zidanetile.png");
				    ImageView zidane=new ImageView(zidanet);
				    c.setStyle("-fx-background-color: green; -fx-text-fill: white;");
				    c.setGraphic(zidane);
				    zidane.setFitWidth(50);
					zidane.setFitHeight(50);
				}
				if (((CharacterCell)(Game.map[i][j])).getCharacter().getName().equals("Bill")){
					Image sorat=new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/map/soratile.png");
				    ImageView sora=new ImageView(sorat);
				    c.setStyle("-fx-background-color: green; -fx-text-fill: white;");
				    c.setGraphic(sora);
				    sora.setFitWidth(50);
					sora.setFitHeight(50);
					
				}
				if (((CharacterCell)(Game.map[i][j])).getCharacter().getName().equals("David")){
					Image cloudt=new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/map/cloudtile.png");
				    ImageView cloud=new ImageView(cloudt);
				    c.setStyle("-fx-background-color: green; -fx-text-fill: white;");
				    c.setGraphic(cloud);
				    cloud.setFitWidth(50);
					cloud.setFitHeight(50);
				}
				if (((CharacterCell)(Game.map[i][j])).getCharacter().getName().equals("Henry Burell")){
					Image noctt=new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/map/noctistile.png");
				    ImageView noct=new ImageView(noctt);
				    c.setStyle("-fx-background-color: green; -fx-text-fill: white;");
				    c.setGraphic(noct);
				    noct.setFitWidth(50);
					noct.setFitHeight(50);
				}
				
			}
				
			else if(((CharacterCell)(Game.map[i][j])).getCharacter() instanceof Zombie && Game.map[i][j].isVisible()){
				 Image zombiet=new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/map/zombie.png");
			     ImageView zombie=new ImageView(zombiet);
			     c.setStyle("-fx-background-color: green; -fx-text-fill: white;");
				 c.setGraphic(zombie);
				 zombie.setFitWidth(50);
			     zombie.setFitHeight(50);
			}
			else
			{
				Image defaulttt=new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/map/default.png");
			    ImageView defaultt=new ImageView(defaulttt);
			    c.setStyle("-fx-background-color: green; -fx-text-fill: white;");
			  //  defaultt.setFitWidth(50);
			//	defaultt.setFitHeight(50);
			//    c.setGraphic(defaultt);
			  
			    
			}
		}
		else if(Game.map[i][j] instanceof CollectibleCell){
			if(Game.map[i][j].isVisible()){
			if(((CollectibleCell)(Game.map[i][j])).getCollectible() instanceof Vaccine){
				Image vaccinet=new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/map/vaccine.png");
			    ImageView vaccine=new ImageView(vaccinet);
			    c.setStyle("-fx-background-color: green; -fx-text-fill: white;");
				c.setGraphic(vaccine);
				vaccine.setFitWidth(50);
			    vaccine.setFitHeight(50);
				
				
			}
			else {
				Image supplyt=new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/map/supply.png");
			    ImageView supply=new ImageView(supplyt);
			    c.setStyle("-fx-background-color: green; -fx-text-fill: white;");
				c.setGraphic(supply);
				supply.setFitWidth(50);
			    supply.setFitHeight(50);
			}
			
		}}
		else{              //Trap cell
			
			 c.setStyle("-fx-background-color: green; -fx-text-fill: white;");
			 Image defaulttt=new Image("File:/1-GUC/GUC/Semester 4 (Spring 2023)/CS Game/Milestone 3/Graphics/map/default.png");
			    ImageView defaultt=new ImageView(defaulttt);
			    c.setStyle("-fx-background-color: green; -fx-text-fill: white;");
			  //  defaultt.setFitWidth(50);
				//defaultt.setFitHeight(50);
			  //  c.setGraphic(defaultt);
		}
		}
	
	}
	public void crV(){
	   VBox v1 = new VBox();
	   VBox v2 = new VBox();
	   VBox v3 = new VBox();
	   VBox v4 = new VBox();
	   VBox v5 = new VBox();
	   VBox v6 = new VBox();
	   sp.getChildren().addAll(v1,v2,v3,v4,v5,v6);
	  sp.setSpacing(10);
	   
	   VB.add(v1);VB.add(v2);VB.add(v3);VB.add(v4);VB.add(v5);VB.add(v6);
	   BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, new CornerRadii(10), Insets.EMPTY);
	   Background background = new Background(backgroundFill);
		String buttonsound="C:\\1-GUC\\GUC\\Semester 4 (Spring 2023)\\CS Game\\Milestone 3\\Graphics\\seffects\\commandsound.mp3";
	   Media sound = new Media(new File(buttonsound).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		
		
	    v1.setOnMouseClicked(e ->{
	    	 mediaPlayer.stop();
	    	    mediaPlayer.seek(Duration.ZERO);
	         mediaPlayer.play(); 
	         clearSelect();
	         v1.setBackground(background);
			 Node node = v1.getChildren().get(0);
			    if (node instanceof Label) {
			        Label label = (Label) node;
			 
			 

			String labelText = ((Label)label).getText();
			String t2="";
			int v=0;
			while(labelText.charAt(v)!= ' '){
				t2=t2+labelText.charAt(v);
				v++;
			}
			v=0;
			while(! Game.heroes.get(v).getName().contains(t2)){
				v++;
			}
			curr=Game.heroes.get(v);
			    }
		 });
	    v2.setOnMouseClicked(e ->{
	    	 mediaPlayer.stop();
	    	    mediaPlayer.seek(Duration.ZERO);
	         mediaPlayer.play(); 
	    	   clearSelect();
	    	   v2.setBackground(background);
			 Node node = v2.getChildren().get(0);
			 
			    if (node instanceof Label) {
			        Label label = (Label) node;
			 
			 

		
			String labelText = ((Label)label).getText();
			String t2="";
			int v=0;
			while(labelText.charAt(v)!= ' '){
				t2=t2+labelText.charAt(v);
				v++;
			}
			v=0;
			while(! Game.heroes.get(v).getName().contains(t2)){
				v++;
			}
			curr=Game.heroes.get(v);
			    }
		 });
	    v3.setOnMouseClicked(e ->{
	    	 mediaPlayer.stop();
	    	    mediaPlayer.seek(Duration.ZERO);
	         mediaPlayer.play(); 
	         clearSelect();
	         v3.setBackground(background);
			 Node node = v3.getChildren().get(0);
			 
			    if (node instanceof Label) {
			        Label label = (Label) node;
			 
			 

			String labelText = ((Label)label).getText();
			String t2="";
			int v=0;
			while(labelText.charAt(v)!= ' '){
				t2=t2+labelText.charAt(v);
				v++;
			}
			v=0;
			while(! Game.heroes.get(v).getName().contains(t2)){
				v++;
			}
			curr=Game.heroes.get(v);
			    }
		 });
	    v4.setOnMouseClicked(e ->{
	    	 mediaPlayer.stop();
	    	    mediaPlayer.seek(Duration.ZERO);
	         mediaPlayer.play(); 
	         clearSelect();
	         v4.setBackground(background);
			 Node node = v4.getChildren().get(0);
			 
			    if (node instanceof Label) {
			        Label label = (Label) node;
			 
			 

			
			String labelText = ((Label)label).getText();
			String t2="";
			int v=0;
			while(labelText.charAt(v)!= ' '){
				t2=t2+labelText.charAt(v);
				v++;
			}
			v=0;
			while(! Game.heroes.get(v).getName().contains(t2)){
				v++;
			}
			curr=Game.heroes.get(v);
			    }
		 });
	    v5.setOnMouseClicked(e ->{
	    	 mediaPlayer.stop();
	    	    mediaPlayer.seek(Duration.ZERO);
	         mediaPlayer.play(); 
	         clearSelect();
	         v5.setBackground(background);
			 Node node = v5.getChildren().get(0);
			 
			    if (node instanceof Label) {
			        Label label = (Label) node;
			 
			 


			String labelText = ((Label)label).getText();
			String t2="";
			int v=0;
			while(labelText.charAt(v)!= ' '){
				t2=t2+labelText.charAt(v);
				v++;
			}
			v=0;
			while(! Game.heroes.get(v).getName().contains(t2)){
				v++;
			}
			curr=Game.heroes.get(v);
			    }
		 });
	    v6.setOnMouseClicked(e ->{
	    	 mediaPlayer.stop();
	    	    mediaPlayer.seek(Duration.ZERO);
	         mediaPlayer.play(); 
	         clearSelect();
	         v6.setBackground(background);
			 Node node = v6.getChildren().get(0);
			 
			    if (node instanceof Label) {
			        Label label = (Label) node;
			 
			 

			// Extract the text from the label
			String labelText = ((Label)label).getText();
			String t2="";
			int v=0;
			while(labelText.charAt(v)!= ' '){
				t2=t2+labelText.charAt(v);
				v++;
			}
			v=0;
			while(! Game.heroes.get(v).getName().contains(t2)){
				v++;
			}
			curr=Game.heroes.get(v);
			    }
		 });
	}
	public void createVBox(){
		 for(int i = 0; i<Game.heroes.size();i++){
			 if(Game.heroes.get(i) instanceof Fighter)
		        	type="FIGH";
		        else if(Game.heroes.get(i) instanceof Medic)
		        	type="MED";
		        else
		        	type="EXP";
	    Label dt = new Label(Game.heroes.get(i).getName()+" "+"\n Class: "+type+"\n HP: "+Game.heroes.get(i).getCurrentHp()+"\n Attack: "+Game.heroes.get(i).getAttackDmg()+"\n Actions: "+Game.heroes.get(i).getActionsAvailable()+"\n Sup: "+Game.heroes.get(i).getSupplyInventory().size()+" Vac: "+Game.heroes.get(i).getVaccineInventory().size());
	    VB.get(i).getChildren().addAll(dt);
	    
	    VB.get(i).layout();
		DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        dropShadow.setRadius(4); 
        dropShadow.setSpread(2);
	    dt.setEffect(dropShadow);
	    dt.setStyle("-fx-background-color : transparent; -fx-text-fill : white");
	    
	    
		 }
		 
	}

	public void updateVBox(){
	  
	    for(int i = 0; i<Game.heroes.size();i++){
	    	VB.get(i).getChildren().clear();
	    	if(Game.heroes.get(i) instanceof Fighter)
	        	type="FIGH";
	        else if(Game.heroes.get(i) instanceof Medic)
	        	type="MED";
	        else
	        	type="EXP";
	    Label dt = new Label(Game.heroes.get(i).getName()+" "+"\n Class: "+type+"\n HP: "+Game.heroes.get(i).getCurrentHp()+"\n Attack: "+Game.heroes.get(i).getAttackDmg()+"\n Actions: "+Game.heroes.get(i).getActionsAvailable()+"\n Sup: "+Game.heroes.get(i).getSupplyInventory().size()+" Vac: "+Game.heroes.get(i).getVaccineInventory().size());
		DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        dropShadow.setRadius(5); 
        dropShadow.setSpread(3);
	    dt.setEffect(dropShadow);
	    dt.setStyle("-fx-background-color : transparent; -fx-text-fill : white");
	    VB.get(i).getChildren().addAll(dt);
	  
	    VB.get(i).layout();
	    
	    }
	}
	public void startMap(){
		for(int i=0; i<15; i++){
			 for(int j=0; j<15; j++){
				 Button cell = new Button();
				 getcell(cell,i,j);
				 cell.setPrefSize(70,70);
				 
				 center.add(cell, j,14-i);
				 cell.setOnAction(e -> {
						int col = GridPane.getColumnIndex(cell);
						int row = GridPane.getRowIndex(cell);
						if(Game.map[14-row][col] instanceof CharacterCell)
							tar =((CharacterCell)(Game.map[14-row][col])).getCharacter();
						else
							tar = null;
						
					});
			 }
		 }
		
	}
	public void clearSelect() {
		 for(int i = 0; i<Game.heroes.size();i++){
			 VB.get(i).setBackground(null);
		 }
	}
	
	
	
}
