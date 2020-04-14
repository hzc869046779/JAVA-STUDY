package DataStructure.tttt;

public class BiTree {
    public static void main(String args[]){
        BTreeNode<Integer> root = new BTreeNode<>(10);
        root.left = new BTreeNode<Integer>(8);
        root.right = new BTreeNode<Integer>(15);

        System.out.println("根节点"+root.data+"左孩子"+root.left.data+"右孩子"+root.right.data);

    }
}

class BTreeNode<T>{
    public T data;
    public BTreeNode<T> left;
    public BTreeNode<T> right;

    public BTreeNode(T t){
        this.data = t;
    }
}
