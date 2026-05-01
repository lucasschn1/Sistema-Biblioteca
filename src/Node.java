public class Node {
    Livro livro;
    Node esquerda;
    Node direita;

    public Node(Livro livro) {
        this.livro = livro;
        this.esquerda = null;
        this.direita = null;
    }
}
