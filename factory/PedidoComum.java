package factory;

public class PedidoComum implements IPedido {
    @Override
    public void processarPedido() {
        System.out.println("Processando pedido comum...");
    }
}

