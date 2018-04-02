package com.example.springbootdemo.test;


/**
 * @author D N
 * @create 2018-03-29 14:36
 **/
public class Tree {

    /**
     * 先序遍历二叉树
     * @param root
     */
    public void Fprint(TreeNode root){
        if(root!=null){
            System.out.println(root.obj);
            Fprint(root.lchild);
            Fprint(root.rchild);
        }
    }

    /**
     * 中序遍历二叉树
     * @param root
     */
    public void Mprint(TreeNode root){
        if(root!=null){
            Mprint(root.lchild);
            System.out.print(root.obj+" ");

            Mprint(root.rchild);
        }
    }

    /**
     * 根据一个int数组建立二叉排序树
     * @param a 数组
     * @return
     */
    public TreeNode Build(int[] a){
        if(a.length==0){
            return null;
        }
        TreeNode root = new TreeNode(a[0]);
        for(int i=1;i<a.length;i++){
            TreeNode newnode = new TreeNode(a[i]);
            sort(root,newnode);
        }
        return root;
    }
    /**
     * 在二叉排序树中添加一个节点
     * @param root 二叉树的根节点
     * @param newnode 新加入的加点
     * @return
     */
    public void sort(TreeNode root,TreeNode newnode){
        TreeNode node = root;
        if((Integer)newnode.obj<=(Integer)node.obj){
            if(node.lchild==null){
                newnode.parent = node;
                node.lchild = newnode;
            }else{
                sort(node.lchild,newnode);
            }
        }else{
            if(node.rchild==null){
                newnode.parent = node;
                node.rchild = newnode;
            }else{
                sort(node.rchild,newnode);
            }
        }
    }
}