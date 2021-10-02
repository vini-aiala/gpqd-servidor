package br.com.gpqd.petshop.config.security;

import br.com.gpqd.petshop.model.Funcionario;
import br.com.gpqd.petshop.repository.FuncionarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {
    private final FuncionarioRepository repository;

    public AuthenticationService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Funcionario> funcionario = repository.findByEmail(email);
        if (funcionario.isPresent()) {
            return funcionario.get();
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
    }
}
