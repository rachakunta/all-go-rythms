package com.rana.trees;

public class AllTreeProblems {

    public static void main(String[] args) {
        System.out.println(new TreeNode.Tree().generateTrees(5).toString());
    }

    public static int maxDepthOfNArrTree(TreeNode root){
        return max(root);
    }

    private static int max(TreeNode root){
        if(root == null){
            return 0;
        }
        int max = 0;
        for(TreeNode node : root.children){
            max = Math.max(max, max(node));
        }
        return max + 1;
    }

}
