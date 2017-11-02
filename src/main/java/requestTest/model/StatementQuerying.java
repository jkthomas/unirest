package requestTest.model;

import java.sql.*;

public class StatementQuerying {

    public static void select(Connection conn, String dbName)
            throws SQLException {

        PreparedStatement preparedStatement = null;
        Statement stmt = null;
        String query = "SELECT * " + "FROM " + dbName;
        try {
            preparedStatement = conn.prepareStatement(query);

            stmt = conn.createStatement();
            stmt.execute("USE rates");
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("Base currency: EUR.\n");
            while (rs.next()) {
                Date dbDate = rs.getDate("date");
                double PLN = rs.getDouble("PLN");
                double USD = rs.getDouble("USD");
                double GBP = rs.getDouble("GBP");
                double JPY = rs.getDouble("JPY");
                System.out.println("Rates update date: " + dbDate +
                        "\n" + "PLN: " + PLN +
                        "\t" + "USD: " + USD +
                        "\t" + "GBP: " + GBP +
                        "\t" + "JPY: " + JPY + "\n");
            }
        } catch (SQLException e ) {
            System.out.println(e);
        } finally {
            if (stmt != null) { stmt.close(); }
        }
    }

    public static void insert(Connection conn, String dbName, String date, double pln, double usd, double gbp, double jpy)
            throws SQLException {

        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO " + dbName +
                "(`date`, `PLN`, `USD`, `GBP`, `JPY`) VALUES " +"(?,?,?,?,?)";
        try {
            preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, date);
            preparedStatement.setDouble(2, pln);
            preparedStatement.setDouble(3, usd);
            preparedStatement.setDouble(4, gbp);
            preparedStatement.setDouble(5, jpy);
            preparedStatement.execute("USE rates");
            preparedStatement.executeUpdate();
        } catch (SQLException e ) {
            System.out.println(e);
        } finally {
            if (preparedStatement != null) { preparedStatement.close(); }
        }
    }

    public static void delete(Connection conn, String dbName, String condition) throws SQLException {
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM " + dbName + " WHERE " + "?";

        try {
            preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, condition);
            preparedStatement.execute("USE rates");
            preparedStatement.executeUpdate();
        } catch (SQLException e ) {
            System.out.println(e);
        } finally {
            if (preparedStatement != null) { preparedStatement.close(); }
        }
    }
}
