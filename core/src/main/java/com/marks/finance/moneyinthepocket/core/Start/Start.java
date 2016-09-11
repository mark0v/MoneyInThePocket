package com.marks.finance.moneyinthepocket.core.Start;

import com.marks.finance.moneyinthepocket.core.dao.impls.StorageDAOImpl;
import com.marks.finance.moneyinthepocket.core.database.SQLiteConnection;
import com.marks.finance.moneyinthepocket.core.decorator.StorageSynchronizer;
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

//        try {
//
//            DefaultStorage storage = new DefaultStorage();
//
//            Currency currencyUSD = Currency.getInstance("USD");
//            Currency currencyRUB = Currency.getInstance("RUB");
//
//            storage.addCurrency(currencyUSD);
//            storage.addCurrency(currencyRUB);
//            storage.addAmount(new BigDecimal(200), currencyUSD);
//
//            //storage.expenseAmount(new BigDecimal(250), currencyUSD);
//
//            System.out.println("storage = " + storage.getAvailableCurrencies());
//
//        } catch (CurrencyException e) {
//            e.printStackTrace();
//        }


//        try (Statement stmt = SQLiteConnection.getConnection().createStatement(); ResultSet rs = stmt.executeQuery("select * from storage")){
//
//            while (rs.next()){
//                System.out.println(rs.getString("name"));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        System.out.println(Currency.getInstance("RUB").getDisplayName());





    }

}
