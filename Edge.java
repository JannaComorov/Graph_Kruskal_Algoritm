package Graph_Kruskal_Lab3;

public class Edge implements Comparable<Edge> {
    int src, dest, weight; // Definim sursa, destinația și greutatea muchiei

    // Constructor
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    // Metoda pentru a compara muchiile după greutate
    @Override
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight; // Comparam greutățile muchiilor
    }
}
