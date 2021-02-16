package Team_SSD;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Credits extends Stage {
	//Declaring GUI Object
	BorderPane mainpane = new BorderPane();
	Pane buttonpane = new HBox(50);
	Pane btnlblpane = new VBox(5);
	Pane IBpane = new Pane();
	Scene scene1 =new Scene(mainpane,1100,600);
	Button b1 = new Button("Home");
	Button bexit = new Button("[Exit]");
	
	//Constructor
	Credits() {
	b1.setStyle("-fx-background-color:ORANGE");
	bexit.setStyle("-fx-background-color:ORANGE");
	buttonpane.getChildren().addAll(b1,bexit);
	buttonpane.setPadding(new Insets(500,5,50,500));
	
	//Declaring And Customizing Label
	Label l = new Label("TEAM SSD");
	l.setFont(Font.font("Stencil",FontWeight.BOLD,FontPosture.REGULAR,140));
	l.setTextFill(Color.DARKRED);
	
	Label l1 = new Label("  This Software Developed By");
	l1.setFont(Font.font("Stencil",FontWeight.BOLD,FontPosture.REGULAR,40));
	l1.setTextFill(Color.DARKRED);
	
	Label lSaif = new Label("Md. Saif Ahammod Khan; ID# 1721779642");
	lSaif.setFont(Font.font("Gabriola",FontWeight.BOLD,FontPosture.REGULAR,30));
	lSaif.setTextFill(Color.YELLOW);
	
	Label lShobuz = new Label("Ismail Hossain; ID# 1722018042");
	lShobuz.setFont(Font.font("Gabriola",FontWeight.BOLD,FontPosture.REGULAR,30));
	lShobuz.setTextFill(Color.YELLOW);
	
	Label lDukul = new Label("Dukul Howlader Mohin; ID# 1722072642");
	lDukul.setFont(Font.font("Gabriola",FontWeight.BOLD,FontPosture.REGULAR,30));
	lDukul.setTextFill(Color.YELLOW);
	
	//Adding All Label to pane
	btnlblpane.getChildren().addAll(l1,l,lSaif,lShobuz,lDukul);
	btnlblpane.setPadding(new Insets(50,5,50,230));
	
	//Declaring  And Customizing Image
	Image image = new Image("/image/4.jpg");
	ImageView image1 = new ImageView(image);
	image1.setFitHeight(600);
	image1.setFitWidth(1100);
	
	//Adding image button and label to pane
	IBpane.getChildren().addAll(image1,btnlblpane,buttonpane);
	mainpane.setCenter(IBpane);
	mainpane.setStyle("-fx-background-color:BLACK");
	
	//Setting Scene And Stage
	this.setTitle("Credits");
	this.setScene(scene1);
	this.show();
	
	//Setting Action To Button
	b1.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent t) {
        	//Calling Home Class 
				new Home();
        }
      
    });
	
	bexit.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent t) {
        	//Calling For Exit 
        	System.exit(0);
        }
      
    });

	}
}
