# Documentação do Projeto: Biblioteca Virtual Inteligente

Este projeto consiste em um sistema de gerenciamento e recomendação de livros que integra diversas estruturas de dados e algoritmos fundamentais da computação. O objetivo é demonstrar a aplicação prática de conceitos como busca em árvores, navegação em grafos e ordenação.

## Estruturas de Dados Utilizadas

### 1. Pilha (Stack) e Fila (Queue)
*   **Pilha de Histórico:** Armazena os livros acessados recentemente pelo usuário. Segue a lógica LIFO (Last-In, First-Out), onde o último livro pesquisado é o primeiro a ser exibido no topo do histórico.
*   **Fila de Espera:** Gerencia as solicitações de usuários para livros que não estão disponíveis no momento. Segue a lógica FIFO (First-In, First-Out), garantindo a ordem de chegada na reserva.

### 2. Árvore Binária de Busca (BST)
O catálogo de 15 livros é organizado hierarquicamente em uma árvore binária baseada nos títulos. Esta estrutura foi escolhida por permitir:
*   Busca rápida de itens.
*   Demonstração dos percursos DFS (Depth-First Search) e BFS (Breadth-First Search) para fins acadêmicos e técnicos.

### 3. Grafo e Algoritmo de Dijkstra
O sistema utiliza um Grafo de Adjacência para representar as conexões entre livros da mesma categoria ou autor.
*   **Recomendação Inteligente:** Implementação do algoritmo de Dijkstra (versão simplificada com pesos unitários) para calcular o caminho mais curto entre livros no grafo.
*   **Métrica de Relevância:** Quanto menor a distância calculada pelo algoritmo, maior é o grau de similaridade e relevância da recomendação para o usuário.

## Organização do Código

O projeto está dividido em classes com responsabilidades bem definidas, seguindo princípios de modularização:

*   **Main:** Classe de entrada que inicializa o sistema.
*   **SistemaBiblioteca:** Classe controladora que orquestra o fluxo entre as estruturas de dados e gerencia o menu de interação.
*   **Livro:** Entidade principal com os atributos (ID, Título, Autor, Ano).
*   **Node:** Classe auxiliar para a árvore binária.
*   **ArvoreBinaria:** Implementação da lógica de inserção e busca (BFS/DFS).
*   **Grafo:** Implementação do mapeamento de adjacências e do algoritmo de Dijkstra.

## Instruções de Uso

1.  O sistema é iniciado com 15 instâncias de livros pré-configuradas.
2.  Utilize o menu numérico para navegar entre as funcionalidades.
3.  A opção de busca na árvore exibirá o rastro dos nós percorridos para demonstrar a eficiência do algoritmo.
4.  A opção de recomendação solicitará um título base e retornará os livros mais próximos geograficamente dentro do grafo de categorias.

---
**Desenvolvedor:** Lucas Schneider Cordeiro  
**Curso:** Análise e Desenvolvimento de Sistemas (ADS)  
**Instituição:** PUCPR
