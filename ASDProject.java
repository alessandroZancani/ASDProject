import java.lang.reflect.Array;

public class ASDProject{


    //97a 122z
    public static void main(String[] args){
        String s = "cicciopasticcio";
        BST bst = new BST(s);
        System.out.println("inOrder visit del albero non compresso \n"+bst.inOrderVisit()+"\n \n");

        bst.copressTree();

        System.out.println("inOrder visit del albero compresso \n"+bst.inOrderVisit()+"\n");
        int[] occ = new int[26];
        int temp = 0;
        //calcola m e M
        //cerca nel raggio di m e M

        for(int i=0; i<s.length(); i++){
            temp = s.charAt(i);
            
            occ[temp-97] =  occ[temp-97] + 1;
        }

        int min = 0;
        int max = 0;

        for(int i=0; i<26; i++){
            if(occ[i] < min){
                min = occ[i];
            }
            if(occ[i] > max){
                max = occ[i];
            }
        }

        System.out.println("il max :"+ max);
        System.out.println("il min :"+ min + "\n");

        System.out.println("le occorrenze per carattere \n");
        char x;
        for(int i=0; i<26; i++){
            x = (char) (i + 97);
            System.out.print(x);
        }
        
        System.out.print("\n");

        for(int i=0; i<26; i++){
            System.out.print(occ[i]);
        }
        System.out.print("\n");
        
       

        

        /* queue test
        BSTNode x = new BSTNode('x');
        BSTNode y = new BSTNode('y');
        BSTNode w = new BSTNode('w');
        BSTNode z = new BSTNode('z');

        BSTNode a;

        MyQueue q = new MyQueue();

        q.enqueue(x);
        q.enqueue(y);
        q.enqueue(w);
        q.enqueue(z);

        while(!q.isEmpty()){
            a = q.dequeue();
            System.out.println(a.getLabel());
        }


        System.out.println("end");
        */


        //search leaf test
        /*
        BSTNode a;
        MyQueue q = bst.searchLeaf();

        a = q.dequeue();
        System.out.println(a.getLabel());


        while(!q.isEmpty()){
            a = q.dequeue();
            System.out.println(a.getLabel());
        }

        */
        System.out.println("\n \n \n");

        /*test white
        bst.resetWhiteDist();

        MyQueue q = new MyQueue();

        BSTNode x = bst.getRoot();

        q.enqueue(x);

        while(!q.isEmpty()){
            x= q.dequeue();

            System.out.println(x.getColor()+" " +x.getDist());

            if(x.getLeft()!= null)
                q.enqueue(x.getLeft());

            if(x.getRight()!= null)
                q.enqueue(x.getRight());
        }
        */

        Graph g = bst.crateGraph(min, max);

        g.printGraph();

    }
    


    

}