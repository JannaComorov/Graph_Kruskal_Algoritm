package Graph_Kruskal_Lab3;

import java.util.Scanner;

public class KruskalAlgorithmMain {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Citim numărul de noduri în graf
        System.out.print("Introduceți numărul de noduri: ");
        int V = scanner.nextInt();

        // Creăm graful cu V noduri
        Graph graph = new Graph(V);

        // Citim numărul de muchii
        System.out.print("Introduceți numărul de muchii: ");
        int E = scanner.nextInt();

        // Adăugăm muchiile în graf
        System.out.println("Introduceți muchiile în formatul: src dest weight");
        for (int i = 0; i < E; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(src, dest, weight);
        }

        // Apelăm metoda pentru găsirea arborelui parțial minim
        graph.kruskalMST();

        scanner.close();
    }
}
