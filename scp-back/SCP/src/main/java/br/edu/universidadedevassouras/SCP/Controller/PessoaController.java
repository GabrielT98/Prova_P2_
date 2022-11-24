package br.edu.universidadedevassouras.SCP.Controller;

import br.edu.universidadedevassouras.SCP.Model.Pessoa;
import br.edu.universidadedevassouras.SCP.Repository.PessoaRepository;
import br.edu.universidadedevassouras.SCP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/pessoa")
@CrossOrigin
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private UserService userService;

    @GetMapping
    public @ResponseBody Iterable<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Pessoa> getPessoa(@PathVariable("id") Long id) {
        return pessoaRepository.findById(id);
    }

    @PostMapping
    public Pessoa postPessoa(@RequestBody Pessoa p) {
        return userService.save(p);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        pessoaRepository.deleteById(id);
    }

    @PutMapping
    public Pessoa putPessoa(@RequestBody Pessoa p) {
        return userService.save(p);
    }

}
