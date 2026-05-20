package entities;

public class Grafo {

    private final int vertices;
    private final int[][] matrizAdjacencia;

    public Grafo (int vertices) {
        this.vertices = vertices;
        this.matrizAdjacencia = new int[vertices][vertices];
    }

    public int getVertices() {
        return this.vertices;
    }

    public void adicionarAresta(int origem, int destino, int peso){
        matrizAdjacencia[origem][destino] = peso;
    }

    public int getPeso(int origem, int destino) {
        return matrizAdjacencia[origem][destino];
    }
}
