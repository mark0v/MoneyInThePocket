package com.marks.finance.moneyinthepocket.core.decorator;

import com.marks.finance.moneyinthepocket.core.dao.interfaces.StorageDAO;
import com.marks.finance.moneyinthepocket.core.exceptions.CurrencyException;
import com.marks.finance.moneyinthepocket.core.interfaces.Storage;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

/**
 * Created by Alexander on 9/11/2016.
 */
public class StorageSynchronizer implements StorageDAO{

    private StorageDAO storageDAO;
    private List<Storage> storageList;

    public StorageSynchronizer(StorageDAO storageDAO) {
        this.storageDAO = storageDAO;
        init();
    }

    private void init() {
        storageList = storageDAO.getAll();
    }



    @Override
    public boolean addCurrency(Storage storage, Currency currency) {
        return false;
    }

    @Override
    public boolean deleteCurrency(Storage storage, Currency currency) {
        return false;
    }

    @Override
    public boolean updateAmount(Storage storage, BigDecimal amount) {
        return false;
    }

    @Override
    public List<Storage> getAll() {
        return null;
    }

    @Override
    public Storage get(long id) {
        return null;
    }

    @Override
    public boolean update(Storage storage) {
        return false;
    }

    @Override
    public boolean delete(Storage storage) {
        return false;
    }
}
