import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.sql.Statement;
import javafx.scene.control.Label;
import pack.Userdata;

public class HomeController{

    @FXML
    private Label firstletter;

    @FXML
    private Label fullname;

    public void start(){
        fullname.setText("hello");
        System.out.println("working ah");
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void availTicket(ActionEvent event) {

    }

    @FXML
    void bookTicket(ActionEvent event) throws IOException{
        root=FXMLLoader.load(getClass().getResource("Book.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cancelTicket(ActionEvent event) {

    }

    @FXML
    void showTicket(ActionEvent event) {

    }

    @FXML
    void sighout(ActionEvent event) throws IOException{
        root=FXMLLoader.load(getClass().getResource("Main.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);        
        stage.show();
    }


    public static Connection getConnection(){
        String url="jdbc:mysql://localhost:3306/dearam";
        String user="root";
        String password="dearam8114";
        try{
            Connection conn=DriverManager.getConnection(url,user,password);
            return conn;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }

    }
}
