package com.marks.finance.moneyinthepocket.core.decorator;

/**
 * Created by Alexander on 9/11/2016.
 */
import java.util.List;

import com.marks.finance.moneyinthepocket.core.dao.interfaces.SourceDAO;
import com.marks.finance.moneyinthepocket.core.interfaces.Source;
import com.marks.finance.moneyinthepocket.core.enums.OperationType;

public class SourceSync implements SourceDAO{

    private SourceDAO sourceDAO;
    private List<Source> sourceList;

    public SourceSync(SourceDAO sourceDAO) {
        this.sourceDAO = sourceDAO;
    }

    @Override
    public List<Source> getAll() {
        if (sourceList==null){
            sourceList = sourceDAO.getAll();
        }
        return sourceList;
    }

    @Override
    public Source get(long id) {
        return null;
    }

    @Override
    public boolean update(Source source) {
        if (sourceDAO.update(source)){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Source source) {

        if (sourceDAO.delete(source)){
            sourceList.remove(source);
            sourceDAO.getList(source.getOperationType()).remove(source);
            return true;
        }
        return false;
    }

    @Override
    public List<Source> getList(OperationType operationType) {
        return sourceDAO.getList(operationType);
    }
}