package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.PedidoDTO;
import br.com.multicinema.cinemaapi.model.entity.Pedido;
import br.com.multicinema.cinemaapi.service.PedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity post(@RequestBody PedidoDTO pedidoDTO){
        try{
            Pedido pedido = converter(pedidoDTO);
            pedido = pedidoService.salvar(pedido);
            return new ResponseEntity(pedido, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar o pedido: " + e.getMessage());
        }
    }

    private Pedido converter(PedidoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Pedido pedido = modelMapper.map(dto, Pedido.class);
        return pedido;
    }
}
