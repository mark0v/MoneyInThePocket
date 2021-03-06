package com.marks.finance.moneyinthepocket.core.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Alexander on 9/4/2016.
 */
public class SQLiteConnection {

    private static Connection con;

    public static Connection getConnection(){
        try {

            Class.forName("org.sqlite.JDBC").newInstance();

            String url = "jdbc:sqlite:c:\\money\\money.db";

            if (con==null) con = DriverManager.getConnection(url);

            return con;

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}