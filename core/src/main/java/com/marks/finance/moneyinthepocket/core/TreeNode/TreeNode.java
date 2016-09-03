package com.marks.finance.moneyinthepocket.core.TreeNode;


import java.util.List;

/**
 * Created by Alexander on 9/3/2016.
 */
public interface TreeNode {

    java.lang.String getName();

    long getId();

    void add(TreeNode child);

    void remove (TreeNode child);

    List<TreeNode> getChilds();

    TreeNode getChild (long id);

    TreeNode getParent();

    void setParent(TreeNode parent);
}
