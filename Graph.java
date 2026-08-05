package Graph_Kruskal_Lab3;

import java.util.*;

public class Graph {
    private int V; // Numărul de noduri în graf
    private LinkedList<Edge> edges; // Lista muchiilor în graf

    // Constructor
    public Graph(int v) {
        V = v;
        edges = new LinkedList<>(); // Inițializăm lista de muchii
    }

    // Metoda pentru adăugarea unei muchii în graf
    public void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight); // Cream o nouă muchie
        edges.add(edge); // Adăugăm muchia în lista de muchii
    }

    // Funcția pentru a găsi arborele parțial minim folosind algoritmul lui Kruskal
    public void kruskalMST() {
        // Sortăm lista muchiilor în ordine crescătoare a greutăților
        Collections.sort(edges);

        // Vector pentru a stoca muchiile arborelui parțial minim
        ArrayList<Edge> mstEdges = new ArrayList<>();

        // Vector pentru a ține evidența componentelor conexe
        int[] parent = new int[V];

        // Inițializăm vectorul părinților pentru fiecare nod
        for (int i = 0; i < V; i++) {
            parent[i] = i; // Fiecare nod este inițial propriul său părinte
        }

        int edgeCount = 0; // Numărul de muchii adăugate în arborele parțial minim
        int index = 0; // Indexul curent al muchiei din lista sortată

        // Parcurgem lista muchiilor și adăugăm în arborele parțial minim
        while (edgeCount < V - 1 && index < edges.size()) {
            Edge nextEdge = edges.get(index++); // Preluăm următoarea muchie

            // Găsim părinții nodurilor src și dest ale muchiei
            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            // Dacă muchia nu formează un ciclu în arborele parțial, o adăugăm
            if (x != y) {
                mstEdges.add(nextEdge);
                edgeCount++;
                union(parent, x, y); // Unim cele două componente conexe
            }
        }

        // Afișăm muchiile arborelui parțial minim
        System.out.println("Arborele parțial minim:");
        for (Edge edge : mstEdges) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }
    }

    // Metoda pentru a găsi părintele unui nod în arborele de părinți
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]); // Compresia căilor
        }
        return parent[i];
    }

    // Metoda pentru a uni două componente conexe
    private void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        parent[yRoot] = xRoot; // Facem rădăcina lui y să fie x
    }
}

