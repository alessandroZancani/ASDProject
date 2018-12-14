

public class Graph{
    

    char[] vertex;
    Edge[] edges;
    int nodeCounter;
    int edgeCounter;

    public Graph(int x){
        this.vertex = new char[x];
        this.edges = new Edge[(x*(x-1))];
        this.nodeCounter = 0;
        this.edgeCounter = 0;
    }

    public void addNode(char c){
        this.vertex[this.nodeCounter] = c;
        this.nodeCounter ++;
    }
   
    public void addEdge(char c1, char c2){
        Edge e = new Edge(c1,c2);
        edges[this.edgeCounter] = e;
        this.edgeCounter ++;
    }

    public void printGraph(){


        char c1;
        char c2;
        int x;
        int y;

        System.out.println(nodeCounter + "  "+ edgeCounter/2);
        System.out.println("graph G {");
		for (int i = 0; i < this.nodeCounter; i++) {
                System.out.println("" + i + " [label=\""+ vertex[i] + "\"];");
		}

       

        if(this.edgeCounter != 0){
            for(int i = 0; i < this.edgeCounter; i++){
                //stampa solo gli alberi con etichetta crescente
                c1 = edges[i].getNode1();

                c2 = edges[i].getNode2();

                x = searchNode(c1);
                y = searchNode(c2);

                if(x < y){
                    System.out.println(x +" -- "+y+";");
                }

            
            }
        }

        System.out.println("}");

    }


    public int searchNode(char c){
        int i= 0;
        
        while(vertex[i] != c){
            i++;
        }

        return i;

    }
    

    

    

}