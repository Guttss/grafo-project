package entities;

public class InicializaGrafo {

    public void inicializaD(Grafo g, int[] d, int[] p, int s){
        for(int v = 0; v < g.getVertices(); v++){
            d[v] = Integer.MAX_VALUE / 2;
            p[v] = -1;
        }
        d[s] = 0;
    }
}
