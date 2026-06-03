package application;

import entities.AlgoritmoDijkstra;
import entities.Grafo;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String[] CIDADES = {
            "Sao Paulo",
            "Rio de Janeiro",
            "Vitoria",
            "Recife",
            "Salvador",
            "Natal"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Grafo grafo = criarGrafo();

        System.out.println("Cidades disponiveis:");
        for (int i = 0; i < CIDADES.length; i++) {
            System.out.println(i + " - " + CIDADES[i]);
        }

        int origem = lerCidade(sc, "Digite a cidade de origem: ");
        int destino = lerCidade(sc, "Digite a cidade de destino: ");

        AlgoritmoDijkstra dijkstra = new AlgoritmoDijkstra();
        int[] predecessores = new int[grafo.getVertices()];
        int[] distancias = dijkstra.executarDijkstra(grafo, origem, predecessores);

        if (distancias[destino] >= Integer.MAX_VALUE / 2) {
            System.out.println("Nao existe caminho entre " + CIDADES[origem] + " e " + CIDADES[destino] + ".");
            sc.close();
            return;
        }

        System.out.println();
        System.out.println("Caminho minimo: " + montarCaminho(predecessores, origem, destino));
        System.out.println("Custo do caminho: " + distancias[destino] + " km");

        sc.close();
    }

    private static Grafo criarGrafo() {
        Grafo grafo = new Grafo(CIDADES.length);

        adicionarLigacao(grafo, 0, 1, 300);
        adicionarLigacao(grafo, 0, 3, 400);
        adicionarLigacao(grafo, 0, 4, 100);
        adicionarLigacao(grafo, 1, 2, 100);
        adicionarLigacao(grafo, 1, 5, 70);
        adicionarLigacao(grafo, 2, 3, 50);
        adicionarLigacao(grafo, 3, 5, 150);
        adicionarLigacao(grafo, 4, 5, 50);

        return grafo;
    }

    private static void adicionarLigacao(Grafo grafo, int origem, int destino, int distancia) {
        grafo.adicionarAresta(origem, destino, distancia);
        grafo.adicionarAresta(destino, origem, distancia);
    }

    private static int lerCidade(Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = sc.nextLine().trim();

            int cidade = buscarCidade(entrada);
            if (cidade != -1) {
                return cidade;
            }

            System.out.println("Cidade invalida. Digite o nome ou o numero da cidade.");
        }
    }

    private static int buscarCidade(String entrada) {
        try {
            int indice = Integer.parseInt(entrada);
            if (indice >= 0 && indice < CIDADES.length) {
                return indice;
            }
        } catch (NumberFormatException ignored) {
        }

        return -1;
    }

    private static String normalizar(String texto) {
        String semAcentos = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        return semAcentos.toLowerCase();
    }

    private static String montarCaminho(int[] predecessores, int origem, int destino) {
        List<String> caminho = new ArrayList<>();

        for (int atual = destino; atual != -1; atual = predecessores[atual]) {
            caminho.add(0, CIDADES[atual]);

            if (atual == origem) {
                break;
            }
        }

        return String.join(" -> ", caminho);
    }
}