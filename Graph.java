public class Graph{
    

    char[] vertex;
    Edge[] edges;
    int nodeCounter;
    int edgeCounter;

    public Graph(int x){
        this.vertex = new char[x];
        this.edges = new Edge[(x*(x-1))/2];
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

        System.out.println("\n Questi sono i nodi \n ");

        for(int i = 0; i < this.nodeCounter; i++){
            System.out.print(vertex[i] + " ");
        }

        System.out.println("\n \n Questi sono gli archi \n ");

        if(this.edgeCounter == 0){
            System.out.print("Non ci sono archi");
        }else{
            for(int i = 0; i < this.edgeCounter; i++){
                edges[i].printEdge();
                System.out.print("   ");
            }
        }

    }

    

}