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

        StorageSynchronizer storageSync = new StorageSynchronizer(new StorageDAOImpl());
        DefaultStorage tmpStore = (DefaultStorage) storageSync.getAll().get(1).getChilds().get(0);

        try {
            storageSync.addCurrency(tmpStore, Currency.getInstance("USD"));
            System.out.println("storageSync.getAll() = " + storageSync.getAll());
        } catch (CurrencyException e) {
            e.printStackTrace();
        }




    }

}
