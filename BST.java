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

            System.out.println("il nodo foglia è  "+ n.getLabel());
            BFSinBST(g, n, min , max);
            System.out.println("\n \n");
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
        n.setColor('g');

        int dist = 0;

        System.out.println("nodo di partenza "+x.getLabel());

        while(!q.isEmpty()){
            

            n = q.dequeue();

            System.out.println("nodo analizzato " + n.getLabel() + "  ha distanza "+n.getDist());
            //se il predecessore è nullo è il primo passo quindi posso solo salire

            

            if(n.getPred() == null){

                if(n.getRight() != null){

                    dist = n.getOcc() + n.getRight().getOcc()-1;
                    n.getRight().setDist(dist);
                    n.getRight().setColor('g');
                    n.getRight().setPred(n);
                
                    q.enqueue(n.getRight());
                }

                if(n.getParent()!= null){

                    dist = n.getOcc()+ n.getParent().getOcc()-1;
                    n.getParent().setDist(dist);
                    n.getParent().setColor('g');
                    n.getParent().setPred(n);

                    q.enqueue(n.getParent());
                }
            
                
            }else{
                
                //se il predecessore è padre del nodo
                // quando scendo a sinistra sommo le occorrenze
                // quando scendo a destra no
                if(n.getParent() == n.getPred()){

                    //se scendo a sx
                    if(n.getLeft() != null && n.getLeft().getColor() == 'w'){
                        dist = n.getDist()+n.getOcc()+ n.getLeft().getOcc()-1;
                        n.getLeft().setDist(dist);
                        n.getLeft().setColor('g');
                        n.getLeft().setPred(n);

                        q.enqueue(n.getLeft());
                        System.out.println("arrivo da padre e vado a sx aggiungo " +n.getLeft().getLabel()+n.getLeft().getDist() );
                    }

                    //se scendo a dx
                    if(n.getRight() != null && n.getRight().getColor() == 'w'){

                        dist = n.getDist() - n.getOcc()+ n.getRight().getOcc() +1;
                        n.getRight().setDist(dist);
                        n.getRight().setColor('g');
                        n.getRight().setPred(n);

                        q.enqueue(n.getRight());
                        System.out.println("arrivo da padre e vado a dx aggiungo " + n.getRight().getLabel()+n.getRight().getDist() );
                    }
                }


                //se il predecessore è un figlio sx
                //quando salgo sommo sia le sue occorrenze che quelle del padre
                //quando vado a destra solo le sue occorrenze 
                if(n.getPred() == n.getLeft()){

                    //se salgo
                    if(n.getParent() != null && n.getParent().getColor() == 'w'){
                        dist = n.getDist()+ n.getParent().getOcc();
                        n.getParent().setDist(dist);
                        n.getParent().setColor('g');
                        n.getParent().setPred(n);

                        q.enqueue(n.getParent());
                        System.out.println("arrivo da sx e vado a su aggiungo" + n.getParent().getLabel()+n.getParent().getDist());
                    }

                    //se scendo a dx
                    if(n.getRight() != null && n.getRight().getColor() == 'w'){
                        dist = n.getDist()+ n.getRight().getOcc();
                        n.getRight().setDist(dist);
                        n.getRight().setColor('g');
                        n.getRight().setPred(n);

                        q.enqueue(n.getRight());
                        System.out.println("arrivo da sx e vado a dx aggiungo  " +n.getRight().getLabel()+n.getRight().getDist());
                
                    }

                }

                //se il predecessore è un figlio dx
                //quando salgo sommo sia le sue occorrenze che quelle del padre
                //quando vado a destra solo le sue occorrenze 
                if(n.getPred() == n.getRight() ){
            
                    //se salgo
                    if(n.getParent() != null && n.getParent().getColor() == 'w'){
                        dist = n.getDist() - n.getOcc() + n.getParent().getOcc() +1;
                        n.getParent().setDist(dist);
                        n.getParent().setColor('g');
                        n.getParent().setPred(n);

                        q.enqueue(n.getParent());
                        System.out.println("arrivo da dx e vado a su aggiungo" +n.getParent().getLabel()+n.getParent().getDist());
                    
                    }

                    //se scendo a sx
                    if(n.getLeft() != null && n.getLeft().getColor() == 'w'){
                        dist = n.getDist()+n.getLeft().getOcc();
                        n.getLeft().setDist(dist);
                        n.getLeft().setColor('g');
                        n.getLeft().setPred(n);

                        q.enqueue(n.getLeft());
                        System.out.println("arrivo da dx e vado a sx aggiungo "+n.getLeft().getLabel() +n.getLeft().getDist());
                    
                    }
                }
            }




            if(n.isLeaf() && n.getDist() <= max && n.getDist() >= min && x.getLabel() != n.getLabel()){
                g.addEdge(x.getLabel(), n.getLabel() );
                System.out.println ("\n ora aggiungo l' arco : "+x.getLabel()+ " " + n.getLabel()+ "  "+ n.getDist() +"\n");
            }   

        }


    }

    public void printOcc(){

        BSTNode n = this.root;
        MyQueue q = new MyQueue();

        q.enqueue(n);

        while(!q.isEmpty()){
            n = q.dequeue();
            System.out.print(n.getLabel());
            System.out.print(n.getOcc() + " ");

            if(n.getLeft() != null)
                q.enqueue(n.getLeft());

            if(n.getRight() != null)
                q.enqueue(n.getRight());
        }


    }



}