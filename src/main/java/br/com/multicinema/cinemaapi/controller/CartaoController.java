package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.CartaoDTO;
import br.com.multicinema.cinemaapi.model.entity.Cartao;
import br.com.multicinema.cinemaapi.service.CartaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/cartoes")
public class CartaoController {
    private final CartaoService cartaoService;

    public CartaoController(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    @GetMapping()
    public ResponseEntity get(){
        List<Cartao> cartoes = cartaoService.getCartoes();
        return ResponseEntity.ok(cartoes.stream().map(CartaoDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        Optional<Cartao> cartao = cartaoService.getCartaoById(id);
        if (!cartao.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cartao.map(CartaoDTO::create));
    }

}
