package br.com.multicinema.cinemaapi.service;

import br.com.multicinema.cinemaapi.model.entity.Cliente;
import br.com.multicinema.cinemaapi.repository.ClienteRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements UserDetailsService {
    private ClienteRepository clienteRepository;
    private PasswordEncoder encoder;

    public ClienteService(ClienteRepository clienteRepository, PasswordEncoder encoder) {
        this.clienteRepository = clienteRepository;
        this.encoder = encoder;
    }

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    public UserDetails autenticar(Cliente cliente) throws Exception {
        UserDetails user = loadUserByUsername(cliente.getEmail());
        boolean senhasBatem = encoder.matches(cliente.getSenha(), user.getPassword());

        if (senhasBatem){
            return user;
        }
        throw new Exception("Senha inválida");
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Cliente cliente = clienteRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        String[] roles = cliente.isFuncionario()
                ? new String[]{"ADMIN", "USER"}
                : new String[]{"USER"};

        return User
                .builder()
                .username(cliente.getEmail())
                .password(cliente.getSenha())
                .roles(roles)
                .build();
    }
}
