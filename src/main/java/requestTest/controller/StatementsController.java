package requestTest.controller;

import requestTest.model.DBConnection;
import requestTest.model.StatementQuerying;

import java.sql.Connection;
import java.sql.SQLException;

public class StatementsController {
    private DBConnection dbConnection;
    private String dbName;
    private Connection conn;

    public StatementsController (DBConnection dbConnection, String dbName){
        this.dbConnection = dbConnection;
        this.dbName = dbName;
    }

    public void setConnection(){
        try {
            this.conn = dbConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewTable(){
        try {
            StatementQuerying.select(this.conn, this.dbName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertRecord(String date, double pln, double usd, double gbp, double jpy){
        try {
            StatementQuerying.insert(this.conn, this.dbName, date, pln, usd, gbp, jpy);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecord(String condition){
        try {
            StatementQuerying.delete(this.conn, this.dbName, condition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
