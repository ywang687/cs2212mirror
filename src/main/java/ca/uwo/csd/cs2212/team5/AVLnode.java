package ca.uwo.csd.cs2212.team5;
import java.lang.*;

/**
 * AVLnode class represents a node in an AVL tree
 */
public class AVLnode implements Position{
    private AVLnode parent;     // reference to the parent node
    private AVLnode left;       // reference to the left child
    private AVLnode right;      // reference to the right child
    private DictEntry entry;    // reference to the entry stored at the node
    private int height;         // height of the node for checking balance-height property

    public AVLnode(DictEntry inputEntry, AVLnode inputParent, AVLnode inputLeft, AVLnode inputRight)
    {
	entry  = inputEntry;
        parent = inputParent;
        left   = inputLeft;
        right  = inputRight;
	height = 0;
	if (left != null ) height  = Math.max(height,1+left.getHeight());
	if (right != null ) height = Math.max(height,1+right.getHeight()); 
    }

    public AVLnode parent(){ return parent;}
    public AVLnode left() {return left;}
    public AVLnode right() {return right;}
    public int getHeight () { return height; }
    public DictEntry getEntry() { return entry; } 
    public void setParent(AVLnode newParent){ parent = newParent; }
    public void setLeft(AVLnode newLeft) {left = newLeft;}
    public void setRight(AVLnode newRight) { right = newRight; }  
    public void setEntry(DictEntry newEntry) { entry = newEntry; }
    public Object element(){return entry;}

    public void resetHeight() throws AVLtreeException{
	if ( left == null || right == null ) throw  new AVLtreeException("Attempt to update height for external node ");
	height = 1+Math.max(left.getHeight(),right.getHeight());
    }
}


