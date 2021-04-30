package com.gj.routine.jz;

/**
 * @title: TreeNode
 * @description: 二叉树节点类
 * @author: jguo
 * @date: 2021/4/30
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
