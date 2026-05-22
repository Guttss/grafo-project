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

    public int[] executarDijkstra(Grafo g, int s){

        int n = g.getVertices();

        int[] d = new int[n];
        int[] p = new int[n];

        boolean[] aberto = new boolean[n];

        InicializaGrafo init = new InicializaGrafo();
        init.inicializaD(g, d, p, s);

        for (int i = 0; i < n; i++){
            aberto[i] = false;
        }

        while(existeAberto(aberto)){
            int u = menorDist(d, aberto);

            aberto[u] = false;

            for (int v = 0; v < n; v++){
                if(g.getPeso(u, v) > 0){
                    relaxa(g, d, p, u, v);
                }
            }
        }

        return d;
    }

    private boolean existeAberto(boolean[] aberto){
        for (boolean status: aberto){
            if(status) return true;
        }
        return false;
    }

    private int menorDist(int[] d, boolean[] aberto){
        int minValor = Integer.MAX_VALUE;
        int minIndice = -1;

        for(int i =0; i < d.length; i++){
            if(aberto[i] && d[i] < minValor){
                minValor = d[i];
                minIndice = i;
            }
        }
        return minIndice;
    }
}
