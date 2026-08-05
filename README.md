# Graph_Kruskal_Algoritm

Implementare în Java a algoritmului lui Kruskal pentru determinarea 
arborelui parțial de cost minim (Minimum Spanning Tree - MST) 
într-un graf neorientat și ponderat.

## Structura proiectului
- `Edge.java` – clasă ce reprezintă o muchie (sursă, destinație, greutate), 
  implementează `Comparable` pentru sortarea după greutate
- `Graph.java` – reprezentarea grafului prin listă de muchii; conține 
  algoritmul Kruskal și structura Union-Find (`find`/`union`) cu 
  compresie de cale
- `KruskalAlgorithmMain.java` – punctul de intrare; citește graful 
  de la tastatură și afișează MST-ul rezultat

## Cum funcționează
1. Se citesc numărul de noduri, numărul de muchii și lista de muchii (src, dest, weight)
2. Muchiile sunt sortate crescător după greutate
3. Se parcurg muchiile sortate și se adaugă în MST doar dacă nu formează ciclu 
   (verificat cu Union-Find)
4. Se afișează muchiile arborelui parțial minim rezultat

## Complexitate
- Timp: O(E log E) — dominat de sortarea muchiilor
- Spațiu: O(V + E)

## Rulare

```bash
javac Graph_Kruskal_Lab3/*.java
java Graph_Kruskal_Lab3.KruskalAlgorithmMain
```

### Exemplu de input
