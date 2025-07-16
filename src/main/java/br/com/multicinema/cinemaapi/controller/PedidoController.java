package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.PedidoDTO;
import br.com.multicinema.cinemaapi.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping()
    public ResponseEntity get(){
        var pedidos = pedidoService.getPedidos();
        return ResponseEntity.ok(pedidos.stream().map(PedidoDTO::create).collect(java.util.stream.Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var pedido = pedidoService.getPedidoById(id);
        if (pedido.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedido.map(PedidoDTO::create));
    }
}
