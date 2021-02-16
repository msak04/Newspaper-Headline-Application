package Team_SSD;
//Prothom Alo Offline
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ProthomAloOfline extends Stage{
	//Declaring GUI Object
	BorderPane mainpane = new BorderPane();
	Pane buttonpane = new VBox(50);
	Pane btnlblpane = new VBox(50);
	Pane IBpane = new Pane();
	Scene scene1 =new Scene(mainpane,1100,600);
	Button b1 = new Button("Home");
	Button bexit = new Button("[Exit]");
	
	ProthomAloOfline() throws FileNotFoundException {
	File f = new File("prothomalo.txt");
	Scanner i = new Scanner(f);
	Collection<String> list = new ArrayList<>();
	while(i.hasNext()) {
		list.add(i.nextLine());
	}
	ObservableList<String> details = FXCollections.observableArrayList(list);
    TableView<String> tableView = new TableView<>();
    TableColumn<String, String> col1 = new TableColumn<>();
    tableView.getColumns().addAll(col1);

    col1.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
    tableView.setItems(details);

    StackPane sp = new StackPane(tableView);
    sp.setPadding(new Insets(100,5,50,40));
	i.close();
	//.........................................
	b1.setStyle("-fx-background-color:SKYBLUE");
	bexit.setStyle("-fx-background-color:SKYBLUE");
	buttonpane.getChildren().addAll(b1,bexit);
	buttonpane.setPadding(new Insets(370,5,50,600));
	
	Label l = new Label("Offline Mode");
	l.setFont(Font.font("Freestyle Script",FontWeight.BOLD,FontPosture.REGULAR,140));
	l.setTextFill(Color.DARKRED);
	
	Label l1 = new Label("    The Dialy Prothom Alo");
	l1.setFont(Font.font("Gabriola",FontWeight.BOLD,FontPosture.REGULAR,50));
	l1.setTextFill(Color.RED);
	
	btnlblpane.getChildren().addAll(l,l1);
	btnlblpane.setPadding(new Insets(50,5,50,450));
	Image image = new Image("/image/2.jpeg");
	ImageView image1 = new ImageView(image);
	image1.setFitHeight(600);
	image1.setFitWidth(1100);
	IBpane.getChildren().addAll(image1,btnlblpane,buttonpane,sp);
	mainpane.setCenter(IBpane);
	mainpane.setStyle("-fx-background-color:BLACK");
	this.setTitle("Prothom Alo Offline News");
	this.setScene(scene1);
	this.show();
		
		b1.setOnAction(new EventHandler<ActionEvent>() {
	        public void handle(ActionEvent t) {
	        	new Home();
	        	
	        }
	      
	    });
		
		bexit.setOnAction(new EventHandler<ActionEvent>() {
	        public void handle(ActionEvent t) {
	   
	        	System.exit(0);
	        }
	      
	    });
	}
}
