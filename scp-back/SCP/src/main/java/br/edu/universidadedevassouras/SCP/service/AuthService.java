package br.edu.universidadedevassouras.SCP.service;

import br.edu.universidadedevassouras.SCP.Model.Pessoa;
import br.edu.universidadedevassouras.SCP.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Pessoa> pessoa = pessoaRepository.findByUsername(userName);
        if (pessoa.isEmpty()) {
            throw new UsernameNotFoundException("Pessoa não encontrada com o usuário: " + userName);
        }
        Pessoa p = pessoa.get();
        return new User(p.getUsername(), p.getPassword(), new ArrayList<>());
    }
}
