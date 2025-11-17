package factory;

public class PedidoExpresso implements IPedido{
    
    @Override
    public void processarPedido(){
        System.out.println("Processando pedido expresso...");
    }
}
