package com.myproject.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetStudent {

    static void main() {

        try {
            // 1. Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/batch74",
                    "root",
                    "root"
            );

            // 3. Create statement
            Statement st = con.createStatement();

            // 4. Execute SELECT query
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM students"
            );

            // 5. Read the result
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                int marks = rs.getInt(4);

                System.out.println(
                        id + " | " + firstName + " | " + lastName + " | " + marks
                );
            }

            // 6. Close resources
            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
