package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    public static Connection connectSQLite() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:contactos_db.db?foreign_keys=on;";
            conn = DriverManager.getConnection(dbURL); 
            System.out.println("coneccion establecida" );           
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexión" + e);
        }
        return conn;
    }
}
