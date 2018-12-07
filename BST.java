public class BST{
    
    private BSTNode root;
    private String inOrderString;
    private int counter;


    public BST(String s){
        root = new BSTNode(s.charAt(0));
        for(int i = 1; i< s.length(); i++){
            addNode(s.charAt(i));
        }
    }

    private void addNode(char c){
        BSTNode cNode = new BSTNode(c);
        BSTNode lastNode = root;
    

        while((c <= lastNode.getChar() && lastNode.getLeft()!=null) || (c > lastNode.getChar() && lastNode.getRight()!=null)){

            if(c <= lastNode.getChar()){
                lastNode = lastNode.getLeft();
            }else{
                lastNode = lastNode.getRight();
            }
        }

        cNode.setParent(lastNode);

        if(c > lastNode.getChar()){
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
        inOrderString = inOrderString + node.getChar();
        inOrder(node.getLeft());
        inOrder(node.getRight());
        }
    }

    public void getLeafs(){
        String s = "";
        
        System.out.println(s);
    }

}