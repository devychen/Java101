package dsa2_st9;

/**
 * A class to represent a binary tree.
 */
import java.util.*;

public class BinaryTree<T> implements java.io.Serializable {
    
    private BinaryNode<T> root; // 声明了引用变量root ...
    
    /**
     * Construct an empty binary tree.
     */
    public BinaryTree() {
        // todo
        root = null;
        
    }
    
    /**
     * Construct a binary tree with data in the root node.
     * @param rootData the root of the new tree
     */
    public BinaryTree(T rootData) {
        // todo
        root = new BinaryNode<>(rootData);
        // ...需要将其指向实际的BinaryNode对象

        
    }
    
    /**
     * Construct a binary tree from the two specified binary trees.
     * @param rootData the root of the new tree
     * @param leftTree the left branch
     * @param rightTree the right branch
     */
    public BinaryTree(T rootData,
                      BinaryTree<T> leftTree, 
                      BinaryTree<T> rightTree) {
        
        
        // todo
        root = new BinaryNode<>(rootData);
        if (leftTree != null) {
            root.setLeftChild(leftTree.root);
        }
        if (rightTree != null) {
            root.setRightChild(rightTree.root);
        }
        
    }
    
    /**
     * Construct a binary tree with the given root node.
     * @param aRootNode the root node for the new tree
     */
    protected BinaryTree(BinaryNode<T> aRootNode) {
        root = aRootNode;
    }
    
    /**
     * Get the data at root
     * @return the root data
     */
    public T getRootData() {        
        if (root == null)
            return null;
        return root.getData();
    }
    
    /**
     * Removes the left subtree of this binary tree.
     */
    public void removeLeftSubtree() {
        if (root != null) {
            root.setLeftChild(null);
        }
    }
    
    /**
     * Removes the right subtree of this binary tree.
     */
    public void removeRightSubtree() {
        if (root != null) {
            root.setRightChild(null);
        }
    }
    
    /**
     * Deletes all nodes from this binary tree.
     */
    public void clear() {
        root = null;
    }
    
    /**
     * Determine if the tree is empty.
     * @return true if this binary tree is empty, false otherwise.
     */ 
    public boolean isEmpty() {
        return root == null;
    }
    
    /**
     * Get the height of this binary tree
     */
    public int getHeight() {
        return getHeight(root);
    }
    
    /*
     * Helper method for getHeight - does the recursion
     */
    private int getHeight(BinaryNode<T> node) {
        int height = 0;
        
        if (node != null)
            height = 1 + Math.max(getHeight(node.getLeftChild()),
                                  getHeight(node.getRightChild()));
        
        return height;
    }
    
    /**
     * Set the data at the root node (can only be used by subclasses)
     * @param rootData the data
     */
    protected void setRootData(T rootData) {
        root.setData(rootData);
    }
    
    /**
     * Set the root node (can only be used by subclasses)
     * @param rootNode the new root node
     */
    protected void setRootNode(BinaryNode<T> rootNode) {
        root = rootNode;
    }
    
    /**
     * Get the root node (can only be used by subclasses)
     * @return the root node
     */
    protected BinaryNode<T> getRootNode() {
        return root;
    }
    
    /**
     * Turn this tree into a mirror image of itself
     */
    public void mirror() {
        mirror(root);
    }
    
    /*
     * Helper mirror method.
     */
    private void mirror(BinaryNode<T> node) {

        if (node == null) return;
        //**********     TO DO    **********
        mirror(node.getLeftChild());
        mirror(node.getRightChild());

        BinaryNode<T> tmp = node.getLeftChild();
        node.setLeftChild(node.getRightChild());
        node.setRightChild(tmp);
    }
    
    /**
     * Generate a string representation of the tree
     * as a parenthesized expression
     * @return a parenthesized representation of this binary tree.
     */
    public String toString() {
        return toString(root);
    }
    
    /*
     * Helper method for toString
     */
    private String toString(BinaryNode<T> top) {
        
        // todo
        if (top == null){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        if(top.isLeaf()){
            sb.append(" " + top.getData());
        } else {
            sb.append(
                    " [" + top.getData()
                            + " " + toString(top.getLeftChild())
                            + " " + toString(top.getRightChild())
                            + "]");
        }

        return sb.toString().replace(" ]", "]");

    }
}