package com.marks.finance.moneyinthepocket.core.dao.interfaces;

import com.marks.finance.moneyinthepocket.core.interfaces.Source;
import com.marks.finance.moneyinthepocket.core.enums.OperationType;

import java.util.List;

/**
 * Created by Alexander on 9/11/2016.
 */
public interface SourceDAO extends CommonDAO<Source>{

    List<Source> getList(OperationType operationType);

}
