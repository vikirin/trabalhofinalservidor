package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionFactory {
    private connectionFactory(){}
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/trabalho",
                    "root" ,
                    "kirin1245");

        }catch (SQLException E){
            throw new RuntimeException(E);
        }
    }

}
