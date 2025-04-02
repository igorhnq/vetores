package estruturas;

public class Iterador {
    
    Lista lista;
    No atual;

    public Iterador(Lista lista, No atual) {
        this.lista = lista;
        this.atual = atual;
    }

    public Boolean haProximo() {
        return this.atual.proximo != null;
    }

    public Boolean haAnterior() {
        return this.atual.anterior != null;
    }

    public void proximo() {
        this.atual = atual.proximo;
    }

    public int getDadoAnterior() {
        return this.atual.anterior.dado;
    }

    public int getDadoProximo() {
        return this.atual.proximo.dado;
    }

    public int getDado() {
        return this.atual.dado;
    }

    public No getAtual() {
        return this.atual;
    }

    public void resetar() {
        this.atual = this.lista.inicio;
    }

    public void display() {
        if (this.haAnterior()) {
            System.out.print("Anterior -> " + this.getDadoAnterior() + " | ");
        }

        System.out.print("No " + this.getDado());
        
        if (this.haProximo()) {
            System.out.println(" | Proximo -> " + this.getDadoProximo());
        }
        System.out.println("");
        this.proximo();
    }

    public void inserirApos(int valor) {
        No novoNo = new No(valor);
        
        novoNo.proximo = this.atual.proximo;
        novoNo.anterior = this.atual;
        
        if (this.atual.proximo != null) {
            this.atual.proximo.anterior = novoNo;
        }
        
        this.atual.proximo = novoNo;
        this.lista.tamanho++;
    }

    public void removerApos() {
        if (this.atual.proximo == null) {
            System.out.println("Não há elemento após o atual");
            return;
        }

        No noRemovido = this.atual.proximo;
        this.atual.proximo = noRemovido.proximo;
        
        if (noRemovido.proximo != null) {
            noRemovido.proximo.anterior = this.atual;
        }
        
        this.lista.tamanho--;
    }

    public void inserirAntes(int valor) {
        No novoNo = new No(valor);
        
        novoNo.proximo = this.atual;
        novoNo.anterior = this.atual.anterior;
        
        if (this.atual.anterior == null) {
            this.lista.inicio = novoNo;
        } else {
            this.atual.anterior.proximo = novoNo;
        }
        
        this.atual.anterior = novoNo;
        this.lista.tamanho++;
    }

    public void removerAntes() {
        if (this.atual.anterior == null) {
            System.out.println("Não há elemento antes do atual");
            return;
        }

        No noRemovido = this.atual.anterior;
        
        if (noRemovido.anterior == null) {
            this.lista.inicio = this.atual;
        } else {
            noRemovido.anterior.proximo = this.atual;
        }
        
        this.atual.anterior = noRemovido.anterior;
        this.lista.tamanho--;
    }
}
