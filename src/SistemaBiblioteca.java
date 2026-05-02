import java.util.*;

public class SistemaBiblioteca {
    private ArvoreBinaria arvore = new ArvoreBinaria();
    private Grafo grafo = new Grafo();
    private Stack<Livro> historico = new Stack<>();
    private Queue<String> filaDeEspera = new LinkedList<String>();
    private List<Livro> listaLivros = new ArrayList<>();

    public void iniciar() {
        popularSistema();
        exibirMenu();
    }

    private void popularSistema() {
        // instacia os livros prontos
        Livro l1 = new Livro(1, "Duna", "Frank Herbert", 1965);
        Livro l2 = new Livro(2, "O Problema dos Três Corpos", "Cixin Liu", 2008);
        Livro l3 = new Livro(3, "Fundação", "Isaac Asimov", 1951);
        Livro l4 = new Livro(4,"A Guerra dos Tronos", "George R. R. Martin", 1996);
        Livro l5 = new Livro(5, "O Senhor dos Anéis", "J. R. R. Tolkien", 1954);
        Livro l6 = new Livro(6, "1984", "George Orwell", 1949);
        Livro l7 = new Livro(7,"Frankenstein", "Mary Shelley", 1818);
        Livro l8 = new Livro(8,"Crime e Castigo", "Fyodor Dostoevsky", 1866);
        Livro l9 = new Livro(9,"Entendendo Algoritmos", "Aditya Bhargava", 2016);
        Livro l10 = new Livro(10, "Código Limpo", "Robert C. Martin", 2008);
        Livro l11 = new Livro(11, "O Iluminado", "Stephen King", 1977);
        Livro l12 = new Livro(12, "It: A Coisa", "Stephen King", 1986);
        Livro l13 = new Livro(13, "Drácula", "Bram Stoker", 1897);
        Livro l14 = new Livro(14, "O Exorcista", "William Peter Blatty", 1971);
        Livro l15 = new Livro(15, "A Assombração da Casa da Colina", "Shirley Jackson", 1959);

        // Criando Lista com todos os livros para mostra-los no menu
        listaLivros.add(l1);
        listaLivros.add(l2);
        listaLivros.add(l3);
        listaLivros.add(l4);
        listaLivros.add(l5);
        listaLivros.add(l6);
        listaLivros.add(l7);
        listaLivros.add(l8);
        listaLivros.add(l9);
        listaLivros.add(l10);
        listaLivros.add(l11);
        listaLivros.add(l12);
        listaLivros.add(l13);
        listaLivros.add(l14);
        listaLivros.add(l15);

        // alimentar a ávore
        arvore.inserir(l8);
        arvore.inserir(l4);
        arvore.inserir(l12);
        arvore.inserir(l2);
        arvore.inserir(l6);
        arvore.inserir(l10);
        arvore.inserir(l14);
        arvore.inserir(l1);
        arvore.inserir(l3);
        arvore.inserir(l5);
        arvore.inserir(l7);
        arvore.inserir(l9);
        arvore.inserir(l11);
        arvore.inserir(l13);
        arvore.inserir(l15);

        // Alimentar Grafo e cria as conexões por categoria
        grafo.adicionarVertices(l1);
        grafo.adicionarVertices(l2);
        grafo.adicionarVertices(l3);
        grafo.adicionarVertices(l4);
        grafo.adicionarVertices(l5);
        grafo.adicionarVertices(l6);
        grafo.adicionarVertices(l7);
        grafo.adicionarVertices(l8);
        grafo.adicionarVertices(l9);
        grafo.adicionarVertices(l10);
        grafo.adicionarVertices(l11);
        grafo.adicionarVertices(l12);
        grafo.adicionarVertices(l13);
        grafo.adicionarVertices(l14);
        grafo.adicionarVertices(l15);

        /*
         * -> crinado conexões por categoria de Livros
         */

        // FICÇÃO CIENTÍFICA
        grafo.adicionarAresta(l1, l2); // Duna - Três Corpos
        grafo.adicionarAresta(l2, l3);  // Três Corpos - Fundação
        grafo.adicionarAresta(l1, l3);  // Duna - Fundação

        // FANTASIA
        grafo.adicionarAresta(l4, l5); // Game of Thrones - Senhor dos Anéis

        // DISTOPIA
        grafo.adicionarAresta(l6, l1); // 1984 - Duna
        grafo.adicionarAresta(l6, l2); // 1984 - Três Corpos

        // TERROR
        grafo.adicionarAresta(l7, l13); // Frankenstein - Drácula
        grafo.adicionarAresta(l11, l12); // O Iluminado - It
        grafo.adicionarAresta(l11, l15); // O Iluminado - Casa da Colina
        grafo.adicionarAresta(l14, l15); // Exorcista - Casa da Colina

        // CLÁSSICOS
        grafo.adicionarAresta(l8, l7);  // Crime e Castigo - Frankenstein
        grafo.adicionarAresta(l8, l13); // Crime e Castigo - Drácula

        // TECNOLOGIA
        grafo.adicionarAresta(l9, l10); // Entendendo Algoritmos - Código Limpo
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n==========================================");
            System.out.println("     SISTEMA DE BIBLIOTECA VIRTUAL        ");
            System.out.println("==========================================");
            System.out.println("1 - Catálogo Completo");
            System.out.println("2 - Fila de Espera e Histórico (Stack/Queue)");
            System.out.println("3 - Recomendações Dijkstra)");
            System.out.println("4 - Busca na Árvore Binária (BFS)");
            System.out.println("5 - Reservar Livro (Fila de Espera)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido.");
                continue;
            }

            switch (opcao) {
                case 1:
                    mostrarCatalogo();
                    break;
                case 2:
                    mostrarFluxos();
                    break;
                case 3:
                    recomendarComDijkstra(scanner);
                    break;
                case 4:
                    buscarNaArvore(scanner);
                    break;
                case 5:
                    reservarLivro(scanner);
                case 0:
                    System.out.println("Saindo... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // mostra o catalogo de livros completo
    private void mostrarCatalogo() {
        System.out.println("\n--- Catálogo de Livros ---");
        for (Livro l : listaLivros) {
            System.out.println(l.getId() + " - " + l.getTitulo() + " (" + l.getAutor() + ")");
        }
    }

    // mostrar usuários na fila de espera e histórico de busca
    private void mostrarFluxos() {
        System.out.println("\n--- Status do Sistema ---");
        System.out.println("Usuários na Fila de Espera: " + filaDeEspera);
        if (!historico.isEmpty()) {
            System.out.println("Último livro consultado (Pilha): " + historico.peek().getTitulo());
        } else {
            System.out.println("Histórico de busca vazio.");
        }
    }

    // busca na árvore binária de livros usando BFS
    private void buscarNaArvore(Scanner scanner) {
        System.out.print("Digite o título para busca: ");
        String titulo = scanner.nextLine();

        // método criado na classe ArvoreBinaria
        Livro encontrado = arvore.buscarBFS(titulo);

        if (encontrado != null) {
            historico.push(encontrado); // Alimenta a Pilha
            System.out.println("Livro encontrado e adicionado ao seu histórico!");
        }
    }

    // usar Dijkstra pra receber recomendação relevante
    private void recomendarComDijkstra(Scanner scanner) {
        System.out.print("Título base para recomendação: ");
        String titulo = scanner.nextLine();

        Livro base = arvore.buscarBFS(titulo); // Busca na árvore primeiro

        if (base != null) {
            // Chama o método 'djikstraSimples' na classe Grafo
            Map<Livro, Integer> recs = grafo.djikstraSimples(base);

            System.out.println("\n--- Recomendações ---");
            recs.forEach((livro, dist) -> {
                if (dist > 0 && dist < 4) {
                    System.out.println("Distância " + dist + ": " + livro.getTitulo());
                }
            });
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    // colocar livro e usuário na fila de espera (Fila)
    private void reservarLivro(Scanner scanner) {
        System.out.print("Digite o título do livro que deseja reservar: ");
        String titulo = scanner.nextLine();

        // 1. Buscamos o livro na árvore para garantir que ele existe
        Livro encontrado = arvore.buscarBFS(titulo);

        if (encontrado != null) {
            System.out.print("Digite seu nome para a fila de espera: ");
            String nomeUsuario = scanner.nextLine();

            // 2. Adicionamos o nome à fila (FIFO - First In, First Out)
            filaDeEspera.add(nomeUsuario + " (Reserva: " + encontrado.getTitulo() + ")");

            System.out.println("Reserva realizada com sucesso para: " + encontrado.getTitulo());
        } else {
            System.out.println("Livro não encontrado para reserva.");
        }
    }
}
