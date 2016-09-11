package com.marks.finance.moneyinthepocket.core.impls;

import com.marks.finance.moneyinthepocket.core.abstrects.AbstractTreeNode;
import com.marks.finance.moneyinthepocket.core.interfaces.Source;
import com.marks.finance.moneyinthepocket.core.interfaces.TreeNode;
import com.marks.finance.moneyinthepocket.core.enums.OperationType;

import java.util.List;

/**
 * Created by Alexander on 9/3/2016.
 */
public class DefaultSource extends AbstractTreeNode implements Source {

    private OperationType operationType;

    public DefaultSource() {
    }

    public DefaultSource(String name) {
        super(name);
    }

    public DefaultSource(String name, long id) {
        super(name, id);
    }

    public DefaultSource(List<TreeNode> childs) {
        super(childs);
    }

    public DefaultSource(long id, List<TreeNode> childs, TreeNode parent, String name) {
        super(id, childs, parent, name);
    }

    public DefaultSource(String name, long id, OperationType operationType) {
        super(name, id);
        this.operationType = operationType;
    }

    @Override
    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    @Override
    public void add(TreeNode child) {
        // for child element set parents' operation type
        if(child instanceof DefaultSource){
            ((DefaultSource)child).setOperationType(operationType);
        }

        super.add(child);
    }
}
