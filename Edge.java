public class Edge{
    private char node1;
    private char node2;




    public Edge(char c1, char c2){
        this.node1 = c1;
        this.node2 = c2;
    }
    /**
     * @return the node1
     */
    public char getNode1() {
        return this.node1;
    }

    /**
     * @return the node2
     */
    public char getNode2() {
        return this.node2;
    }

    /**
     * @param node2 the node2 to set
     */
    public void setNode2(char node) {
        this.node2 = node;
    }

    /**
     * @param node1 the node1 to set
     */
    public void setNode1(char node) {
        this.node1 = node;
    }

    public void printEdge(){
        System.out.print(this.node1);
        System.out.print(this.node2 + " ");
    }
    
}