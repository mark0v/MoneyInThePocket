package com.marks.finance.moneyinthepocket.core.enums;

/**
 * Created by Alexander on 9/11/2016.
 */

import java.util.HashMap;
import java.util.Map;

public enum OperationType {

    INCOME(1), OUTCOME(2), TRANSFER(3), CONVERT(4);

    private static Map<Integer, OperationType> map = new HashMap<Integer, OperationType>();

    static {
        for (OperationType oper : OperationType.values()) {
            map.put(oper.getId(), oper);
        }
    }

    private Integer id;

    private OperationType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static OperationType getType(int id) {
        return map.get(id);
    }


}