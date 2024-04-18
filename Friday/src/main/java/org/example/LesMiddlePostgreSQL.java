package org.example;

import java.sql.*;

public class LesMiddlePostgreSQL {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password ="1111";
    private static final String sql = "SELECT * FROM parser_data";
    private static final Connection connection;
    static {
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) throws Exception {
        ConnectionSQL();
        sendData();
    }
    public static void ConnectionSQL() throws SQLException {

        Statement statement  = connection.createStatement();
        ResultSet resultSet =statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.print(resultSet.getString(1)+" ");
            System.out.print(resultSet.getString(2)+" ");
            System.out.print(resultSet.getString(3)+" ");
            System.out.println(resultSet.getString(4)+" ");
        }
//        resultSet.close();
    }
    public static void sendData() throws Exception{
        Statement statement  = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.last();
        int id = resultSet.getInt(1)+5000;
        System.out.println(id);
        resultSet.moveToInsertRow();
        resultSet.updateInt("id",id);
        resultSet.updateString(2,"newDescription");
        resultSet.updateString(3,"newImages");
        resultSet.updateString(4,"newPrice");
        resultSet.insertRow();
        resultSet.beforeFirst();

    }
}
