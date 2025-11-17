package service;


import com.seupacote.pedido.factory.*;
import com.seupacote.pedido.adapter.LogisticaAdapter;
import com.seupacote.pedido.model.*;
import com.seupacote.pedido.repository.PedidoRepository;
import com.seupacote.pedido.config.ConfiguracaoSistema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private PedidoFactory pedidoFactory;

    @Autowired
    private LogisticaAdapter logisticaAdapter;

    public Pedido processarPedido(Pedido pedido, TipoPedido tipo) {
        IPedido ipedido = pedidoFactory.criarPedido(tipo);
        ipedido.processarPedido();

        double desconto = ConfiguracaoSistema.INSTANCIA.getTaxaDescontoGlobal();
        pedido.aplicarDesconto(desconto);

        logisticaAdapter.enviar(pedido);

        pedido.setStatus(StatusPedido.ENVIADO);
        return repository.save(pedido);
    }

    public Pedido buscarPedidoPorId(int id) {
        return repository.findById(id).orElse(null);
    }
}
