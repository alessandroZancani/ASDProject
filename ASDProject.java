import java.lang.reflect.Array;

public class ASDProject{


    //97a 122z
    public static void main(String[] args){
        String s = "mississippi";
        BST bst = new BST(s);
        System.out.println(bst.inOrderVisit());
        int[] occ = new int[26];
        int temp = 0;
        //calcola m e M
        //cerca nel raggio di m e M

        for(int i=0; i<s.length(); i++){
            temp = s.charAt(i);
            
            occ[temp-97] =  occ[temp-97] + 1;
        }

        int min = 0;
        int MAX = 0;

        for(int i=0; i<26; i++){
            if(occ[i] < min){
                min = occ[i];
            }
            if(occ[i] > MAX){
                MAX = occ[i];
            }
        }

        System.out.println(MAX);
        System.out.println(min + "\n");

        for(int i=0; i<26; i++){
            System.out.print(occ[i]);
        }
        


    }


}