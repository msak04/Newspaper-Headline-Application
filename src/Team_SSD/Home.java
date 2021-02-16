//Home Class
package Team_SSD;



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

public class Home extends Stage {
	
	//importing gui
	BorderPane mainpane = new BorderPane();
	Pane buttonpane = new HBox(200);
	Pane btnlblpane = new HBox(50);
	Pane IBpane = new Pane();
	Scene scene1 =new Scene(mainpane,1100,600);
	Button b1 = new Button("Online");
	Button b2 = new Button("Offline");
	Button b3 = new Button("Credits");
	Button bexit = new Button(" Exit ");
	//Constructor
	Home() {
	b1.setStyle("-fx-background-color:SKYBLUE");
	b2.setStyle("-fx-background-color:SKYBLUE");
	b3.setStyle("-fx-background-color:SKYBLUE");
	bexit.setStyle("-fx-background-color:SKYBLUE");
	buttonpane.getChildren().addAll(b1,b2,b3,bexit);
	buttonpane.setPadding(new Insets(370,5,50,140));

	Label l = new Label("News Headline Application");
	l.setFont(Font.font("Freestyle Script",FontWeight.BOLD,FontPosture.REGULAR,140));
	l.setTextFill(Color.TEAL);
	btnlblpane.getChildren().add(l);
	btnlblpane.setPadding(new Insets(50,5,50,100));
	Image image = new Image("/image/1.jpg");
	ImageView image1 = new ImageView(image);
	image1.setFitHeight(600);
	image1.setFitWidth(1100);
	
	IBpane.getChildren().addAll(image1,btnlblpane,buttonpane);
	mainpane.setCenter(IBpane);
	mainpane.setStyle("-fx-background-color:BLACK");
	this.setTitle("Home");
	this.setScene(scene1);
	this.show();
	
	b1.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent t) {
        	new Online();
        	
        }
      
    });
	
	b2.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent t) {
   
        	new Offline();
        }
      
    });
	
	b3.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent t) {
   
        	new Credits();
        }
      
    });
	
	bexit.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent t) {
   
        	System.exit(0);
        }
      
    });

	}
	
	
}
	
	
	

