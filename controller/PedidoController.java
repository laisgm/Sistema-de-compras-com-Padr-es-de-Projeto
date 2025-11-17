package controller;

package com.seupacote.pedido.controller;

import com.seupacote.pedido.factory.TipoPedido;
import com.seupacote.pedido.model.Pedido;
import com.seupacote.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido, @RequestParam TipoPedido tipo) {
        return pedidoService.processarPedido(pedido, tipo);
    }

    @GetMapping("/{id}")
    public Pedido obterPedidoPorId(@PathVariable int id) {
        return pedidoService.buscarPedidoPorId(id);
    }
}
