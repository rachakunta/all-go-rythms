package com.rana.trees;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public List<TreeNode> children;

    public TreeNode() {
    }

    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val, List<TreeNode> children) {
        this.val = val;
        this.children = children;
    }

    static class Tree{
        int val;
        Tree left;
        Tree right;

        public Tree(int val){
            this.val = val;
        }

        public Tree(){
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        public List<Tree> generateTrees(int n){
            if(n == 0) return new ArrayList<>();

            return generateTrees(1, n);
        }

        private List<Tree> generateTrees(int start, int end) {
            List<Tree> res = new ArrayList<>();
            if (start > end) {
                res.add(null);
                return res;
            }
            List<Tree> left , right;
            for (int i = start; i<= end; i++){
                left = generateTrees(start, i -1);
                right = generateTrees(i + 1, end);
                for(Tree l : left){
                    for (Tree r : right){
                        Tree root = new Tree(i);
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
            }
            return res;
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}'+"\n";
    }
}
