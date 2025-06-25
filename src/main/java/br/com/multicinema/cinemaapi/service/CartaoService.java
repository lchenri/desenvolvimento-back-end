package br.com.multicinema.cinemaapi.service;

import br.com.multicinema.cinemaapi.model.entity.Cartao;
import br.com.multicinema.cinemaapi.repository.CartaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CartaoService {
    private CartaoRepository cartaoRepository;

    public CartaoService(CartaoRepository cartaoRepository) {
        this.cartaoRepository = cartaoRepository;
    }

    public List<Cartao> getCartoes() {
        return cartaoRepository.findAll();
    }

    public Optional<Cartao> getCartaoById(Long id) {
        return cartaoRepository.findById(id);
    }

    @Transactional
    public Cartao salvar(Cartao cartao) {
        return cartaoRepository.save(cartao);
    }

}
