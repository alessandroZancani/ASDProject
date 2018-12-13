import java.util.Queue;

public class BST{
    
    private BSTNode root;
    private String inOrderString;



    public BST(String s){
        root = new BSTNode(s.charAt(0));
        for(int i = 1; i< s.length(); i++){
            addNode(s.charAt(i));
        }
    }

    public BSTNode getRoot(){
        return root;
    }

    private void addNode(char c){
        BSTNode cNode = new BSTNode(c);
        BSTNode lastNode = root;
    

        while((c <= lastNode.getLabel() && lastNode.getLeft()!=null) || (c > lastNode.getLabel() && lastNode.getRight()!=null)){

            if(c <= lastNode.getLabel()){
                lastNode = lastNode.getLeft();
            }else{
                lastNode = lastNode.getRight();
            }
        }

        cNode.setParent(lastNode);

        if(c > lastNode.getLabel()){
            lastNode.setRight(cNode);
        }else{
            lastNode.setLeft(cNode);
        }
        
    }

    public String inOrderVisit(){
        inOrderString = "";
        inOrder(root);
        return inOrderString;
    
    }

    private void inOrder(BSTNode node){
        if (node != null) {
        inOrderString = inOrderString + node.getLabel();
        inOrder(node.getLeft());
        inOrder(node.getRight());
        }
    }


    public void copressTree(){
        treeCompresser(root);
    }

    public void treeCompresser(BSTNode node){

        // comprimo l' albero destro
        if(node.getRight() != null)
        treeCompresser(node.getRight());

        BSTNode leftNode = node.getLeft();

        //se la catena di figli sinistri hanno etichetta uguale la comprimo in un solo nodo
        while (leftNode != null && leftNode.getLabel() == node.getLabel() ){      

            node.addOcc();
            node.setLeft(leftNode.getLeft());
            leftNode = node.getLeft();

        }
        
        //comprimo l' albero sinistro quando ha etichetta diversa
        if(node.getLeft()!= null){
            treeCompresser(node.getLeft());
        }


    }


    public void resetWhiteDist(){


        MyQueue q = new MyQueue();

        BSTNode n = root;
        
        q.enqueue(n);

        while(!q.isEmpty()){
            n = q.dequeue();
            

            if(n.getLeft() != null){
                q.enqueue(n.getLeft());
            }   

            if(n.getRight() != null){
                q.enqueue(n.getRight());
            }

            n.resetVisit();            
        }
    }


    public Graph crateGraph(int min, int max){
        
        Graph g = new Graph(24);

        MyQueue q = searchLeaf();

        BSTNode n;

        while(!q.isEmpty()){

            n = q.dequeue();

            g.addNode(n.getLabel());

            resetWhiteDist();

            BFSinBST(g, n, min , max);

        }
        
        return g;
    }




    public MyQueue searchLeaf(){

        MyQueue q = new MyQueue();
        MyQueue r = new MyQueue();

        BSTNode n = root;
        
        q.enqueue(n);

        
        while(!q.isEmpty()){

            n = q.dequeue();
            
            if(n.isLeaf()){
                r.enqueue(n);
            }

            if(n.getLeft() != null)
            q.enqueue(n.getLeft());

            if(n.getRight() != null)
                q.enqueue(n.getRight());
            
        }


        return r;
    }



    public void BFSinBST(Graph g, BSTNode n, int min, int max){

        MyQueue q = new MyQueue();

        q.enqueue(n);

        BSTNode x = n;

        n.setDist(0);


        while(!q.isEmpty() && n.getDist() < max){
            
            n = q.dequeue();
            

            if(n.getParent() != null && n.getParent().getColor() == 'w'){

                q.enqueue(n.getParent());
                n.getParent().setDist(n.getDist() + n.getOcc());
                n.getParent().setColor('g');

            }

            if(n.getLeft() != null && n.getLeft().getColor() == 'w'){

                q.enqueue(n.getLeft());
                n.getLeft().setDist(n.getDist()+ 1);
                n.getLeft().setColor('g');

            }

            if(n.getRight() != null && n.getRight().getColor() == 'w'){

                q.enqueue(n.getRight());
                n.getRight().setDist(n.getDist()+ n.getOcc());
                n.getRight().setColor('g');

            }


            if(n.isLeaf() && n.getDist()< max && n.getDist()> min && x.getLabel() != n.getLabel()){
                g.addEdge(x.getLabel(), n.getLabel() );
            }


            

        }


    }



}