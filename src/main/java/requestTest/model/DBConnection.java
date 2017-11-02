package requestTest.model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private String userName;
    private String password;
    private String serverName;
    private int portNumber;

    public DBConnection(String userName, String password, String serverName, int portNumber){
        this.userName = userName;
        this.password = password;
        this. serverName = serverName;
        this.portNumber = portNumber;
    }

    public Connection getConnection()
            throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);

        conn = DriverManager.getConnection("jdbc:mysql://" +
                        this.serverName + ":" +
                        Integer.toString(this.portNumber),
                connectionProps);
        System.out.println("Connected to database");
        return conn;
    }
}
