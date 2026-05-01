import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria {
    private Node raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(Livro livro) {
        raiz = inserirRecursivo(raiz, livro);
    }

    public Node inserirRecursivo(Node atual, Livro livro) {
        if (atual == null) {
            return new Node(livro);
        }
        if (livro.getId() < atual.livro.getId()) {
            atual.esquerda = inserirRecursivo(atual.esquerda, livro);
        } else if (livro.getId() > atual.livro.getId()) {
            atual.direita = inserirRecursivo(atual.direita, livro);
        }
        return atual;
    }


    /**
     * Busca um livro na árvore usando BFS (Busca em Largura)
     *
     * @param tituloAlvo título do livro a ser buscaoo
     * @return o Livro {@code Livro} encontrado ou null {@code null} caso não exista
     */

    public Livro buscarBFS(String tituloAlvo) {
        if (raiz == null) return null;

        Queue<Node> fila = new LinkedList<>();
        fila.add(raiz);

        System.out.println("--- INICIANDO BUSCA BFS ---");

        while (!fila.isEmpty()) {
            Node atual = fila.poll();

            // exibir ratro do sistema
            System.out.println("Visitando: " + atual.livro.getTitulo());

            // verificar se é o livro buscado
            if (atual.livro.getTitulo().equalsIgnoreCase(tituloAlvo)) {
                System.out.println("Livro encontrado!");
                return atual.livro;
            }

            // adiciona os filhos na fila pra visita-los
            if (atual.esquerda != null) {
                fila.add(atual.esquerda);
            }
            if (atual.direita != null) {
                fila.add(atual.direita);
            }
        }

        System.out.println("Livro não encontrado na árvore");
        return null;
    }

    /**
     * Busca em profundidade
     *
     * @param tituloAlvo
     * @return Livro
     */

    public Livro buscarDFS(String tituloAlvo) {
        System.out.println("--- INICIANDO BUSCA DFS ---");

        return dfsRecursivo(raiz, tituloAlvo);
    }

    private Livro dfsRecursivo(Node atual, String tituloAlvo) {
        if (atual == null) return null;

        // mostra o livro quando chega no nó
        System.out.println("Visitando: " + atual.livro.getTitulo());

        // se encontrou retorna o objeto Livro
        if (atual.livro.getTitulo().equalsIgnoreCase(tituloAlvo)) {
            return atual.livro;
        }

        // busca na esquerda
        Livro encontradoEsq = dfsRecursivo(atual.esquerda, tituloAlvo);
        if (encontradoEsq != null) return encontradoEsq;

        // busca na direita
        return dfsRecursivo(atual.direita, tituloAlvo);
    }
}
