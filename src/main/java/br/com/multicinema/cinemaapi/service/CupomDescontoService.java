package br.com.multicinema.cinemaapi.service;

import br.com.multicinema.cinemaapi.model.entity.CupomDesconto;
import br.com.multicinema.cinemaapi.repository.CupomDescontoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CupomDescontoService {
    private CupomDescontoRepository cupomDescontoRepository;

    public CupomDescontoService(CupomDescontoRepository cupomDescontoRepository) {
        this.cupomDescontoRepository = cupomDescontoRepository;
    }

    public List<CupomDesconto> getCuponsDesconto() {
        return cupomDescontoRepository.findAll();
    }

    public Optional<CupomDesconto> getCupomDescontoById(Long id) {
        return cupomDescontoRepository.findById(id);
    }

    @Transactional
    public CupomDesconto salvar(CupomDesconto cupomDesconto) {
        return cupomDescontoRepository.save(cupomDesconto);
    }

}
