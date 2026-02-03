package com.wipro.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {

    public static Connection getDBConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "system";
            String pass = "SAKTHI14";

            return DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
