package com.seupacote.pedido.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date dataCriacao = new Date();

    @Enumerated(EnumType.STRING)
    private StatusPedido status = StatusPedido.NOVO;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItemPedido> itens;

    private double valorComDesconto;

    // construtores, getters/setters

    public double calcularValorTotal() {
        return itens.stream()
                .mapToDouble(item -> item.getProduto().getPreco() * item.getQuantidade())
                .sum();
    }

    public void aplicarDesconto(double desconto) {
        double total = calcularValorTotal();
        this.valorComDesconto = total * (1 - desconto);
    }
}
