public class QueueNode{

    private BSTNode node;
    private QueueNode next;

    public QueueNode(BSTNode n ){
        this.node = n ;
        this.next = null;
    }

    /**
     * @return the node
     */
    public BSTNode getNode() {
        return node;
    }


    public boolean hasNext() {
        if(next != null)
           return true;
        else
            return false;
    }

    public QueueNode next(){
        return this.next;
    }

    public void setNext(QueueNode n){
        this.next = n;
    }

    

}