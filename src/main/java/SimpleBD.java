package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class SimpleBD {
    public static void main(String[] args) {
        testDatabase();
    }

    static void testDatabase() {

        //Class.forName("org.h2.Driver");
//            String url="jdbc:h2:mem:testdb";
//            String login="sa";
//            String pass="";

        try (Connection con = DriverManager.getConnection("jdbc:h2:mem:")) {
            try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate("CREATE TABLE JC_CONTACT ( CONTACT_ID SERIAL, FIRST_NAME VARCHAR(50) NOT NULL, LAST_NAME VARCHAR(50) NOT NULL, PHONE VARCHAR(50) NOT NULL, EMAIL VARCHAR(50) NOT NULL, PRIMARY KEY (CONTACT_ID));");
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {

                con.close();
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
