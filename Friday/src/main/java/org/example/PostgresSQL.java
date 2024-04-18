package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class PostgresSQL {
    // устанавливаем связь с СУБД PostgreSQL, заполняем данные в базу данных через API
    private static final String url = "jdbc:postgresql://localhost:5432/middleJava";
    private static final String user = "postgres";
    private static final String password ="1111";
    static Random random = new Random();
    private static final Connection connection;
    static {
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i <10 ; i++) {
            String sqlInsert = "INSERT INTO middleJava(name, phone) VALUES ('Maxim',"+getNumber()+")";
            PreparedStatement  preparedStatement = connection.prepareStatement(sqlInsert);

            preparedStatement.executeUpdate();
        }

    }
    public static String getNumber(){
        return "+37529"+random.nextInt(1000000,10000000);
    }
}
