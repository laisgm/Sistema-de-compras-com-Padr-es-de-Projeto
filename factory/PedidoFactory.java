package factory;

import org.springframework.stereotype.Component;

@Component
public class PedidoFactory {

    public IPedido criarPedido(TipoPedido tipo) {
        switch (tipo) {
            case EXPRESSO:
                return new PedidoExpresso();
            case COMUM:
            default:
                return new PedidoComum();
        }
    }
}

