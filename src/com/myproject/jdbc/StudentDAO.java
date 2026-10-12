package com.myproject.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StudentDAO {

    static void main() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch74", "root", "root");

            Statement st = con.createStatement();

            int n = st.executeUpdate("insert into students  values (12, 'JDBC', 'Driver', 100)");

            if (n > 0) {
                System.out.println(n + " rows effected");
            }

            con.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
