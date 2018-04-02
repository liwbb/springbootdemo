package com.example.springbootdemo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author D N
 * @create 2018-03-29 14:01
 **/
public class BinTree{

    private BinTree left;
    private BinTree right;
    private BinTree root;
    private Object data;
    private List<BinTree> datas;

    public BinTree(BinTree left, BinTree right, BinTree root) {
        super();
        this.left = left;
        this.right = right;
        this.root = root;
    }

    public BinTree(Object data) {
        this.data = data;
    }

    public BinTree() {
    }

    public void crearTree(Object[] objects){
        datas=new ArrayList<>();
        if(objects!=null&&objects.length>0){
            for (int i=0;i<objects.length;i++){
                datas.add(new BinTree(objects[i]));
            }
            root=datas.get(0);
            for (int i=0;i<objects.length/2;i++){
                datas.get(i).left=datas.get(i*2+1);
                if(i*2+2<datas.size()){
                    datas.get(i).right=datas.get(i*2+2);
                }
            }

        }
    }

    public BinTree getLeft() {
        return left;
    }

    public void setLeft(BinTree left) {
        this.left = left;
    }

    public BinTree getRight() {
        return right;
    }

    public void setRight(BinTree right) {
        this.right = right;
    }

    public BinTree getRoot() {
        return root;
    }

    public void setRoot(BinTree root) {
        this.root = root;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
