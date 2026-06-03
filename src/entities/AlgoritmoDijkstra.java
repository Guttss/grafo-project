package entities;

public class AlgoritmoDijkstra {

    public void relaxa(Grafo g, int[] d, int[] p, int u, int v){

        int pesoAresta = g.getPeso(u, v);

        if(pesoAresta > 0){
            if(d[v] > d[u] + pesoAresta){
                d[v] = d[u] + pesoAresta;
                p[u] = u;
            }
        }
    }
}
