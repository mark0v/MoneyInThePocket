package com.marks.finance.moneyinthepocket.core.dao.interfaces;

import com.marks.finance.moneyinthepocket.core.interfaces.Storage;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

/**
 * Created by Alexander on 9/4/2016.
 */
public interface StorageDAO extends CommonDAO {


    boolean addCurrency(Storage storage, Currency currency);
    boolean deleteCurrency(Storage storage, Currency currency);
    boolean updateAmount(Storage storage, BigDecimal amount);
}
