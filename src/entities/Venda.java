package entities;

import java.io.Serializable;

public class Venda extends Product {
    private int quantidade;

    public Venda(String name, double price, int quantidade) {
        super(name, price);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double totalPrice(){
        return getPrice()*quantidade;
    }

    @Override
    public String toString() {
        return getName() + " | " + getPrice() + "R$ | Quantidade: " + getQuantidade();
    }
}
