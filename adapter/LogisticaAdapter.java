package adapter;

import com.seupacote.pedido.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogisticaAdapter implements ILogistica {

    @Autowired
    private ILogisticaLegado logisticaLegado;

    @Override
    public void enviar(Pedido pedido) {
        logisticaLegado.enviarPacote("Endereço de exemplo", "COD123");
        System.out.println("Pedido enviado usando adapter.");
    }
}

