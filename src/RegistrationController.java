import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class RegistrationController {

    @FXML
    private TextField rconfirmpassword;

    @FXML
    private TextField remail;

    @FXML
    private TextField rname;

    @FXML
    private TextField rpassword;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void signup(ActionEvent event) throws IOException{
        addRecord();
        root=FXMLLoader.load(getClass().getResource("Main.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addRecord(){
        String query="insert into rlogin values('"+rname.getText()+"','"+rconfirmpassword.getText()+"')";
        executeQuery(query);
    }
    public void executeQuery(String query){
        Connection conn=getConnection();
        java.sql.Statement st;
        try{
            st=conn.createStatement();
            st.executeUpdate(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        Connection conn;
        String url="jdbc:mysql://localhost:3306/dearam";
        String name="root";
        String password="dearam8114";
        try{
            conn=DriverManager.getConnection(url, name, password);
            System.out.println("connected");
            return conn;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }


}
