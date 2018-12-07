public class BSTNode{
    
    private final char c;
    private BSTNode left ;
    private BSTNode right ;
    private BSTNode parent ;
    private int num;


    public BSTNode(char c){
        this.c = c;
        setLeft(null);
        setRight(null);
        setParent(null);
        num = 0;
    }

    /**
     * @return the isLeaf
     */
    public boolean isLeaf() {
        if(left == null && right == null){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * @return the c
     */
    public char getChar() {
        return c;
    }

    /**
     * @return the left
     */
    public BSTNode getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(BSTNode left) {
        this.left = left;
    }

    /**
     * @return the parent
     */
    public BSTNode getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(BSTNode parent) {
        this.parent = parent;
    }

    /**
     * @return the right
     */
    public BSTNode getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(BSTNode right) {
        this.right = right;
    }




}