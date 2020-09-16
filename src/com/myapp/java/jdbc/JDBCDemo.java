package com.myapp.java.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCDemo {
    static Connection connection = null;

    static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@10.208.22.4:1521/PDB_EPFO_CLONE", "UNIFIED_PORTAL", "UNIFIED_PORTAL");
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = JDBCDemo.getConnection();
        Statement s = null;
        try {
            if (con != null) System.out.println("CONNECTION CREATED");
            String QUERY = "SELECT * FROM (SELECT 1 FROM DUAL UNION ALL SELECT 2 FROM DUAL UNION ALL SELECT 3 FROM DUAL)";
            s = con.createStatement();
            ResultSet rs = s.executeQuery(QUERY);
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("SOME EXCEPTION");
        } finally {
            if (s == null) s.close();
            if (con != null) con.close();
        }
    }
}
