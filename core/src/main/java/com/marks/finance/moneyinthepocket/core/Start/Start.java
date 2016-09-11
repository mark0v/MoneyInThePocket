package com.marks.finance.moneyinthepocket.core.Start;

import com.marks.finance.moneyinthepocket.core.dao.impls.SourceDAOImpl;
import com.marks.finance.moneyinthepocket.core.dao.impls.StorageDAOImpl;
import com.marks.finance.moneyinthepocket.core.decorator.SourceSync;
import com.marks.finance.moneyinthepocket.core.decorator.StorageSync;
import com.marks.finance.moneyinthepocket.core.exceptions.CurrencyException;
import com.marks.finance.moneyinthepocket.core.impls.DefaultStorage;
import com.marks.finance.moneyinthepocket.core.interfaces.Storage;

import java.util.Currency;

/**
 * Created by Alexander on 9/3/2016.
 */
public class Start {

    public static void main(String[] args) {

        SourceSync sourceSync = new SourceSync(new SourceDAOImpl());
        sourceSync.getAll();
    }

}
