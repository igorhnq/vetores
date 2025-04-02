package estruturas;

public class Lista {

    public No inicio;
    protected int tamanho;

    public Lista() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void adicionarAoInicio(int valor) {
        No no = new No(valor);

        if (this.inicio == null) {
            this.inicio = no;
        } else {
            this.inicio.anterior = no;
            no.proximo = this.inicio;
            this.inicio = no;
        }
        this.tamanho++;
    }

    public void adicionarAoFinal(int valor) {
        No no = new No(valor);

        if (this.inicio == null) {
            this.inicio = no;
        } else {
            No atual = this.inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = no;
            no.anterior = atual;
        }
        this.tamanho++;
    }

    public void inserirAposValor(int valorReferencia, int novoValor) {
        No no = new No(novoValor);
        No atual = this.inicio;

        while (atual != null && atual.dado != valorReferencia) {
            atual = atual.proximo;
        }

        if (atual == null) {
            System.out.println("Valor de referência não encontrado");
            return;
        }

        no.proximo = atual.proximo;
        no.anterior = atual;
        
        if (atual.proximo != null) {
            atual.proximo.anterior = no;
        }
        
        atual.proximo = no;
        this.tamanho++;
    }

    public void mostrarNos() {
        Iterador iterador = this.getIterador();
        while (iterador.getAtual() != null) {
            iterador.display();
        }
    }

    public void remover(int valor) {
        No noAux = this.inicio;

        while (noAux != null && noAux.dado != valor) {
            noAux = noAux.proximo;
        }

        if (noAux == null) {
            System.out.println("Valor não encontrado");
            return;
        }

        if (noAux.anterior == null) {
            this.inicio = noAux.proximo;
        } else {
            noAux.anterior.proximo = noAux.proximo;
        }

        if (noAux.proximo != null) {
            noAux.proximo.anterior = noAux.anterior;
        }

        this.tamanho--;
    }

    public Iterador getIterador() {
        return new Iterador(this, this.inicio);
    }
}
