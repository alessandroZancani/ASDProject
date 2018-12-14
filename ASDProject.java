import java.util.Scanner;

public class ASDProject{


    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        if(s.length()>0)
		    graphGenerator(s);
		in.close();

    }

    public static void graphGenerator(String s){        
      
        int occ[] = getOcc(s);
        int min = getMin(occ);
        int max = getMax(occ);

        BST bst = new BST(s);
        bst.copressTree();
        Graph g = bst.crateGraph(min, max);

        g.printGraph();
    }
    



    public static int getMin(int[] occ){
        int min = 0;
        for(int i=0; i<26; i++){
            if(occ[i] < min){
                min = occ[i];
            }
        }
        return min;
    }



    public static int getMax(int[] occ){
        int max = -1;
        for(int i=0; i<26; i++){
            if(occ[i] > max){
                max = occ[i];
            }
        }
        return max;
        
    }

    //97a 122z    
    public static int[] getOcc(String st){
        int[] occ = new int[26];
        int temp = 0;
        //calcola m e M
        //cerca nel raggio di m e M

        for(int i=0; i<st.length(); i++){
            temp = st.charAt(i);   
            occ[temp-97] =  occ[temp-97] + 1;
        }
        return occ;
    }

    

}