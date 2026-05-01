import java.util.*;

public class Grafo {
    private Map<Livro, Set<Livro>> adjacencias;

    public Grafo() {
        this.adjacencias = new HashMap<>();
    }

    public void adicionarVertices(Livro livro) {
        if (!adjacencias.containsKey(livro)) {
            adjacencias.put(livro, new HashSet<>());
        }
    }

    public void adicionarAresta(Livro origem, Livro destino) {
        adicionarVertices(origem);
        adicionarVertices(destino);

        // grafo bi-direcional
        adjacencias.get(origem).add(destino);
        adjacencias.get(destino).add(origem);
    }

    public Set<Livro> obterVizinhos (Livro livro) {
        if (adjacencias.containsKey(livro)) {
            return adjacencias.get(livro);
        }
        return new HashSet<>();
    }

    public Map<Livro, Integer> djikstraSimples(Livro origem) {
        //mapa que armazena a distância (em pulos) de cada livro até a origem
        Map<Livro, Integer> distancias = new HashMap<>();

        Queue<Livro> fila = new LinkedList<>();

        distancias.put(origem, 0); // distância da origem para ela mesma é 0

        fila.add(origem);

        while (!fila.isEmpty()) {
            // retira o primeiro livro da fila para processar
            Livro atual = fila.poll();
            int distanciaAtual = distancias.get(atual);

            for (Livro vizinho : obterVizinhos(atual)) {
                if (!distancias.containsKey(vizinho)) {
                    distancias.put(vizinho, distanciaAtual + 1);
                    fila.add(vizinho);
                }
            }
        }
        return distancias;
    }

    public void mostrarRecomendacoes(Livro livro) {
        // executa o Dijkstra a partir do livro escolhido
        Map<Livro, Integer> resultados = this.djikstraSimples(livro);

        System.out.println("--- RECOMENDAÇÕES BASEADAS EM: " + livro.getTitulo() + " ---");

        resultados.entrySet().stream()
                .filter(entry -> entry.getValue() > 0) // ignora o próprio livro (distância 0)
                .sorted(Map.Entry.comparingByValue())                    // ordena do mais próximo ao mais distante
                .limit(4)                                       // exibe apenas as 4 melhores recomendações
                .forEach(entry -> System.out.println("Livro: " + entry.getKey().getTitulo() +
                        " | Distância (pulos): " + entry.getValue()));
    }
}
