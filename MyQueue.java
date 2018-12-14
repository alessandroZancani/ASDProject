public class MyQueue{


    QueueNode head;
    QueueNode tail;

    public MyQueue(){
    }

    public void enqueue(BSTNode node){
        
        QueueNode n = new QueueNode(node);

        if(head != null){            
            tail.setNext(n);
            this.tail= n;
        }else{
            this.head = n;
            this.tail = n;
        }
            
    }

    public BSTNode dequeue(){
        if(this.head != null){
            QueueNode x = this.head;
            this.head = x.next();
            return x.getNode();
        }else{
            return null;
        }
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    
}