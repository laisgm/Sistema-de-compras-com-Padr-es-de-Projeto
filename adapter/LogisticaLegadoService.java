package adapter;

package com.seupacote.pedido.adapter;

import org.springframework.stereotype.Service;

@Service
public class LogisticaLegadoService implements ILogisticaLegado {
    @Override
    public void enviarPacote(String endereco, String codigoRastreio) {
        System.out.println("Enviando pacote para: " + endereco + " com código: " + codigoRastreio);
    }
}
