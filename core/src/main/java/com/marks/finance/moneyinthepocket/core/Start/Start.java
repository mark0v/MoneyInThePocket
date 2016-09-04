package com.marks.finance.moneyinthepocket.core.Start;

import com.marks.finance.moneyinthepocket.core.database.SQLiteConnection;
import com.marks.finance.moneyinthepocket.core.exceptions.CurrencyException;
import com.marks.finance.moneyinthepocket.core.impls.DefaultStorage;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Currency;

/**
 * Created by Alexander on 9/3/2016.
 */
public class Start {

    public static void main(String[] args) {



        try (Statement stmt = SQLiteConnection.getConnection().createStatement(); ResultSet rs = stmt.executeQuery("select * from storage")){

            while (rs.next()){
                System.out.println(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
