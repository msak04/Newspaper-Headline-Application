package Team_SSD;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BBCOnline extends Stage{
	//Declaring GUI Object
	BorderPane mainpane = new BorderPane();
	Pane buttonpane = new VBox(50);
	Pane btnlblpane = new VBox(50);
	Pane IBpane = new Pane();
	Scene scene1 =new Scene(mainpane,1100,600);
	Button b1 = new Button(" Home ");
	Button b2 = new Button("Offline");
	Button bexit = new Button("[ Exit ]");
	
	public BBCOnline() throws FileNotFoundException {

		try{
			Document doc = null;
	    doc = Jsoup.connect("http://www.bbc.com/news").get();
        File f = new File("BBC.txt");
    	PrintWriter o = new PrintWriter(f);
    	SimpleDateFormat tf = new SimpleDateFormat("dd-MM-yyyy & HH:mm:ss");
    	String td = tf.format(System.currentTimeMillis());
        
    	o.println("Source: BBC");
    	o.println( "Last Update: "+td );

        o.println("News Website link : http://www.bbc.com/news" );

        Elements headlines = doc.select("h3");
        o.println("Number of Headlines: "+headlines.size()+"\n");
      //loading to file
        int count =1;
        for(Element headline : headlines){
            o.println(count+": "+headline.text());
            count++;
        }
        o.close();
      

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

    		b1.setStyle("-fx-background-color:SKYBLUE");
    		bexit.setStyle("-fx-background-color:SKYBLUE");
    		buttonpane.getChildren().addAll(b1,bexit);
    		buttonpane.setPadding(new Insets(370,5,50,600));
    		
    		Label l = new Label("Online Mode");
    		l.setFont(Font.font("Freestyle Script",FontWeight.BOLD,FontPosture.REGULAR,140));
    		l.setTextFill(Color.WHITE);
    		
    		Label l1 = new Label("                B B C");
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
    		this.setTitle("BBC Online News");
    		this.setScene(scene1);
    		this.show();
		}
		catch(Exception e){
			b1.setStyle("-fx-background-color:SKYBLUE");
    		b2.setStyle("-fx-background-color:SKYBLUE");
    		bexit.setStyle("-fx-background-color:SKYBLUE");
    		buttonpane.getChildren().addAll(b1,b2,bexit);
    		buttonpane.setPadding(new Insets(370,5,50,500));
    		
    		Label l = new Label("  404 Error!");
    		l.setFont(Font.font("Freestyle Script",FontWeight.BOLD,FontPosture.REGULAR,140));
    		l.setTextFill(Color.DARKRED);
    		
    		Label l1 = new Label("Maybe Internet Is not Connected");
    		l1.setFont(Font.font("Gabriola",FontWeight.BOLD,FontPosture.REGULAR,50));
    		l1.setTextFill(Color.RED);
    		
    		btnlblpane.getChildren().addAll(l,l1);
    		btnlblpane.setPadding(new Insets(50,5,50,300));
    		Image image = new Image("/image/2.jpeg");
    		ImageView image1 = new ImageView(image);
    		image1.setFitHeight(600);
    		image1.setFitWidth(1100);
    		IBpane.getChildren().addAll(image1,btnlblpane,buttonpane);
    		mainpane.setCenter(IBpane);
    		mainpane.setStyle("-fx-background-color:BLACK");
    		this.setTitle("Error");
    		this.setScene(scene1);
    		this.show();
		}
    		
    		b1.setOnAction(new EventHandler<ActionEvent>() {
    	        public void handle(ActionEvent t) {
    	        	new Home();
    	        	
    	        }
    	      
    	    });
    		b2.setOnAction(new EventHandler<ActionEvent>() {
    	        public void handle(ActionEvent t) {
    	        	new Offline();
    	        	
    	        }
    	      
    	    });
    		bexit.setOnAction(new EventHandler<ActionEvent>() {
    	        public void handle(ActionEvent t) {
    	   
    	        	System.exit(0);
    	        }
    	      
    	    });
	}
}
