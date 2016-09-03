package com.marks.finance.moneyinthepocket.core.Start;

import com.marks.finance.moneyinthepocket.core.exceptions.CurrencyException;
import com.marks.finance.moneyinthepocket.core.impls.DefaultStorage;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by Alexander on 9/3/2016.
 */
public class Start {

    public static void main(String[] args) {
        try {

            DefaultStorage storage = new DefaultStorage();
            Currency currencyUSD = Currency.getInstance("USD");
            Currency currencyRUB = Currency.getInstance("RUB");

            storage.addCurrency(currencyUSD);
            storage.addAmount(new BigDecimal (200), currencyUSD);

            System.out.println(storage.getAmount(currencyUSD));
        } catch (CurrencyException e) {
            e.printStackTrace();
        }

    }
}
