package com.rana.trees;

import java.util.List;

public class TreeNode {
    public int val;
    public List<TreeNode> children;

    public TreeNode() {
    }

    public TreeNode(int val, List<TreeNode> children) {
        this.val = val;
        this.children = children;
    }
}
