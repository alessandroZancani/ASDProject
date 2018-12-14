public class BSTNode{
    
    private char label; 
    private BSTNode left ;
    private BSTNode right ;
    private BSTNode parent ;
    private int occ;


    //parametri aggiuntivi per la visita
    private char color;
    private int dist;
    private BSTNode pred;


    public BSTNode(char c){
        this.label = c;
        setLeft(null);
        setRight(null);
        setParent(null);
        setOcc(1);
        resetVisit();
    }

    /**
     * @return the pred
     */
    public BSTNode getPred() {
        return pred;
    }

    /**
     * @param pred the pred to set
     */
    public void setPred(BSTNode pred) {
        this.pred = pred;
    }

    public void resetVisit() {
        this.color = 'w';
        this.dist = -1;
        this.pred = null;
    }


    /**
     * @return the dist
     */
    public int getDist() {
        return dist;
    }
    /**
     * @param dist the dist to set
     */
    public void setDist(int dist) {
        this.dist = dist;
    }


    /**
     * @return the label
     */
    public char getLabel() {
        return label;
    }



    // getter setter occurence
    /**
     * @return the occ
     */
    public int getOcc() {
        return occ;
    }
    /**
     * @param occ the occ to set
     */
    public void addOcc() {
        this.occ ++;
    }
    private void setOcc(int i){
        this.occ = i;
    }


    // getter setter color
    /**
     * @return the color
     */
    public char getColor() {
        return color;
    }
    /**
     * @param color the color to set
     */
    public void setColor(char color) {
        this.color = color;
    }


    /**
     * @return the isLeaf
     */
    public boolean isLeaf() {
        if((this.left == null && this.right == null) || (this.left == null && occ > 1 )){
            return true;
        }
        else{
            return false;
        }
    }


    //getter setter left 
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