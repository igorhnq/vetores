import estruturas.Lista;
import estruturas.Vetor;
import estruturas.Iterador;

public class VetorApp {

    public static void main(String[] args) {
        // Inicialização do vetor com os valores solicitados
        Vetor vetor = new Vetor(10);
        vetor.adicionar(2);
        vetor.adicionar(7);
        vetor.adicionar(9);
        vetor.adicionar(12);
        vetor.adicionar(16);
        vetor.adicionar(21);
        vetor.adicionar(27);
        vetor.adicionar(33);
        vetor.adicionar(42);
        vetor.adicionar(54);

        System.out.println("Vetor inicial:");
        vetor.mostrarElementos();

        // Teste da busca binária
        System.out.println("\nTestando busca binária:");
        vetor.buscaBinaria(21);
        vetor.buscaBinaria(10);

        // Teste de inserção no início
        System.out.println("\nInserindo 1 no início:");
        vetor.adicionarAoInicio(1);
        vetor.mostrarElementos();

        // Teste da lista duplamente encadeada
        System.out.println("\nTestando lista duplamente encadeada:");
        Lista lista = new Lista();
        lista.adicionarAoInicio(2);
        lista.adicionarAoInicio(7);
        lista.adicionarAoInicio(9);
        lista.adicionarAoInicio(12);
        lista.adicionarAoInicio(16);
        lista.adicionarAoInicio(21);
        lista.adicionarAoInicio(27);
        lista.adicionarAoInicio(33);
        lista.adicionarAoInicio(42);
        lista.adicionarAoInicio(54);

        System.out.println("Lista inicial:");
        lista.mostrarNos();
        System.out.println("Tamanho da lista: " + lista.getTamanho());

        // Teste de inserção no final
        System.out.println("\nInserindo 100 no final:");
        lista.adicionarAoFinal(100);
        lista.mostrarNos();

        // Teste de inserção após valor
        System.out.println("\nInserindo 15 após 12:");
        lista.inserirAposValor(12, 15);
        lista.mostrarNos();

        // Teste dos iteradores
        System.out.println("\nTestando operações com iterador:");
        Iterador iterador = lista.getIterador();
        iterador.display(); // Mostra o nó atual
        
        System.out.println("\nInserindo 50 após o atual:");
        iterador.inserirApos(50);
        lista.mostrarNos();

        System.out.println("\nRemovendo após o atual:");
        iterador.removerApos();
        lista.mostrarNos();

        System.out.println("\nInserindo 30 antes do atual:");
        iterador.inserirAntes(30);
        lista.mostrarNos();

        System.out.println("\nRemovendo antes do atual:");
        iterador.removerAntes();
        lista.mostrarNos();
    }
}