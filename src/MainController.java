import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.sql.Statement;
import pack.Userdata;

public class MainController {

    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField logname;

    @FXML
    private Label wrong;

    @FXML
    private TextField logpwd;
    private Stage s;
    private Scene sc;
    private Parent r;
    @FXML
    void loginbtn(ActionEvent event) {
        Connection conn=getConnection();
        String query="select count(name) from rlogin where name='"+logname.getText()+"' and password='"+logpwd.getText()+"'";
        java.sql.Statement st;
        ResultSet rs;
        try{
            st=conn.createStatement();
            rs=st.executeQuery(query);
            rs.next();
            int a=rs.getInt(1);
            if(a==1){
                String q="insert into loggedusers values('"+logname.getText()+"')";
                st.executeUpdate(q);
                r=FXMLLoader.load(getClass().getResource("Home.fxml"));
                s=(Stage)((Node)event.getSource()).getScene().getWindow();
                sc=new Scene((r));
                s.setScene(sc);
                s.show();
            }
            else{
                wrong.setText("Name or password wrong");
            }
        }catch(Exception e){
            e.printStackTrace();
        }   
    }

    @FXML
    void registernewbtn(ActionEvent event) throws IOException{
        root=FXMLLoader.load(getClass().getResource("Registration.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public Connection getConnection(){
        Connection conn;
        String url="jdbc:mysql://localhost:3306/dearam";
        String name="root";
        String password="dearam8114";
        try{
            conn=DriverManager.getConnection(url,name,password);
            return conn;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public void checkLogin(){

    }

}
