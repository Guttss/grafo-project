d = vetor de distâncias acumuladas a partir do início

p = vetor de predecessores / pais (guarda o histórico do caminho)

s = vértice inicial (ponto de partida / source)

u = vértice atual que está a ser explorado (vértice "origem" da aresta)

v = vértice vizinho de 'u' que está a ser testado (vértice "destino" da aresta)

---
Na função relaxa(g, d, p, u, v):

O algoritmo testa se: (distância para chegar em u) + (peso para ir de u até v)
é menor do que a distância que já conhecíamos para v (d[v]).
Se for menor, o caminho passando por 'u' passa a ser a nova melhor rota para 'v'.
