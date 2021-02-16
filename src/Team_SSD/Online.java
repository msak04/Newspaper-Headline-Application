package Team_SSD;

import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;


public class Online extends Stage {
	//Declaring GUI Object
	BorderPane mainpane = new BorderPane();
	Pane buttonpane = new VBox(10);
	Pane btnlblpane = new VBox(50);
	Pane IBpane = new Pane();
	Scene scene1 =new Scene(mainpane,1100,600);
	Button b1 = new Button("Prothom Alo");
	Button b3 = new Button("     B  B  C      ");
	Button b4 = new Button("NewYork Times");
	Button b2 = new Button("      Home      ");
	Button bexit = new Button("[       Exit       ]");
	
	
	Online() {
	b1.setStyle("-fx-background-color:SKYBLUE");
	b2.setStyle("-fx-background-color:SKYBLUE");
	b3.setStyle("-fx-background-color:SKYBLUE");
	b4.setStyle("-fx-background-color:SKYBLUE");
	bexit.setStyle("-fx-background-color:SKYBLUE");
	buttonpane.getChildren().addAll(b1,b3,b4,b2,bexit);
	buttonpane.setPadding(new Insets(370,5,50,500));
	
	Label l = new Label("Online Mode");

	l.setFont(Font.font("Freestyle Script",FontWeight.BOLD,FontPosture.REGULAR,140));
	l.setTextFill(Color.WHITE);
	Label l1 = new Label("Make Sure Internet Is Connected");
	l1.setFont(Font.font("Gabriola",FontWeight.BOLD,FontPosture.REGULAR,40));
	l1.setTextFill(Color.YELLOW);
	btnlblpane.getChildren().addAll(l,l1);
	btnlblpane.setPadding(new Insets(50,5,50,350));
	Image image = new Image("/image/3.jpg");
	ImageView image1 = new ImageView(image);
	image1.setFitHeight(600);
	image1.setFitWidth(1100);
	IBpane.getChildren().addAll(image1,btnlblpane,buttonpane);
	mainpane.setCenter(IBpane);
	mainpane.setStyle("-fx-background-color:BLACK");
	this.setTitle("Online News Site");
	this.setScene(scene1);
	this.show();
	
	b1.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent t) {
        	try {
				new ProthomAloOnline();
			} catch (FileNotFoundException e) {
				new Online();
			}
        	
        }
      
    });
	b2.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent t) {
        	new Home();
        	
        }
      
    });
	b3.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent t) {
        	try {
				new BBCOnline();
			} catch (FileNotFoundException e) {
				new Online();
			}
        	
        }
      
    });
	b4.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent t) {
        	try {
				new NYTOnline();
			} catch (FileNotFoundException e) {
				new Online();
			}
        	
        }
      
    });
	bexit.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent t) {
   
        	System.exit(0);
        }
      
    });

	}
	
	
}
	
	
	

