package br.edu.universidadedevassouras.SCP.service;


import br.edu.universidadedevassouras.SCP.Model.Pessoa;
import br.edu.universidadedevassouras.SCP.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Pessoa save(Pessoa pessoa) {
        if (pessoa.getPassword() != null) {
            pessoa.setPassword(passwordEncoder.encode(pessoa.getPassword()));
        }
        return pessoaRepository.save(pessoa);
    }
}