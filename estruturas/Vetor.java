package estruturas;

public class Vetor {

    public Integer[] elementos; // 3fc -> 4fd
    private int tamanho;
    private int capacidade;

    public Vetor(int capacidade) {
        this.elementos = new Integer[capacidade];
        this.capacidade = capacidade;
        this.tamanho = 0;
    }

    public void adicionar(Integer valor) {
        if (this.capacidade == this.tamanho) {
            this.aumentarCapacidade();
        }

        this.elementos[this.tamanho] = valor;
        this.tamanho++;
    }

    public void adicionarAoInicio(Integer valor) {
        if (this.capacidade == this.tamanho) {
            this.aumentarCapacidade();
        }

        // Desloca todos os elementos para a direita
        for (int i = this.tamanho; i > 0; i--) {
            this.elementos[i] = this.elementos[i-1];
        }

        this.elementos[0] = valor;
        this.tamanho++;
    }

    public void buscaBinaria(Integer valor) {
        int inicio = 0;
        int fim = this.tamanho - 1;
        
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            
            if (this.elementos[meio].equals(valor)) {
                System.out.println("Valor " + valor + " encontrado na posição " + meio);
                return;
            }
            
            if (this.elementos[meio] < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        
        System.out.println("Valor " + valor + " não encontrado");
    }

    private void aumentarCapacidade() {
        int novaCapacidade = this.capacidade + (this.capacidade/2);
        Integer[] novosElementos = new Integer[novaCapacidade];

        for (int i =0; i<this.tamanho; i++) {
            novosElementos[i] = this.elementos[i];
        }

        this.elementos = novosElementos;
        this.capacidade = novaCapacidade;
    }

    public void mostrarElementos() {
        System.out.println("-----");
        System.out.println("Elementos no vetor");
        for (int i=0; i < tamanho; i++) {
            System.out.println(this.elementos[i]);
        }
        System.out.println("-----");
    }

    public void contem(Integer valor) {
        for (int i=0; i < tamanho; i++) {
            if (this.elementos[i] == valor) {
                System.out.println("Valor encontrado");
                return;
            }
        }
        System.out.println("Valor não encontrado");
    }

    public void remover(int posicao) {
        if (posicao > this.tamanho) {
            System.out.println("Posição informada é inválida");
            return;
        }

        for (int i = posicao; i < this.tamanho-1; i++) {
            this.elementos[i] = this.elementos[i+1];
        }

        this.elementos[this.tamanho-1] = null;
        this.tamanho--;
    }

    public void removerPorValor(Integer valor) {
        for (int i=0; i<this.tamanho; i++) {
            if (this.elementos[i] == valor) {
                this.remover(i);
                System.out.println("Item removido");
                return;
            }
        }

        System.out.println("Item não encontrado");
    }
}