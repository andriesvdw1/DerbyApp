package derbyapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.derby.jdbc.EmbeddedDriver;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class DBConnection {
    //Set the fully qualified name of the Apache Derby embedded JDBC driver class
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    
    //JDBC URL used to connect to an Apache Derby database.
    //Specifies to create a database named studentDB
    //It should be created if it does not already exist.
    private static final String JDBC_URL = "jdbc:derby:studentDB;create=true";
    
    //Set connection object to connect to Apache Derby database
    public static Connection con;
    
    //Set constructor
    public DBConnection (){
    }
    
    //Create a connect to database method
    public void connect() throws ClassNotFoundException{
        try{
            //Dynamically load JDBC driver class at runtime
        Class.forName(DRIVER);
        this.con = DriverManager.getConnection(JDBC_URL);
        if(this.con != null){
            System.out.println("Connected to database");
        }
        }catch (SQLException ex){
                ex.printStackTrace();}
    }
    
    public void createTable(){
        try{
            String query= "Create Table Student(StudentID varchar(20),"
                    +" name varchar(20), surname varchar(20)";
            this.con.createStatement().execute(query);
            System.out.println("Created table");
        } catch (SQLException ex){
            System.out.println("SQL error when attempting to create table");
            ex.printStackTrace();
        }
    }
}

