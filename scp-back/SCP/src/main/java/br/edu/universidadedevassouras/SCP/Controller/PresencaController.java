package br.edu.universidadedevassouras.SCP.Controller;

import br.edu.universidadedevassouras.SCP.Model.Presenca;
import br.edu.universidadedevassouras.SCP.Repository.PresencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/presenca")
@CrossOrigin
public class PresencaController {

    @Autowired
    private PresencaRepository presencaRepository;

    @GetMapping
    public @ResponseBody Iterable<Presenca> getAll() {
        return presencaRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Presenca> getPresenca(@PathVariable("id") Long id) {
        return presencaRepository.findById(id);
    }

    @PostMapping
    public Presenca postPresenca(@RequestBody Presenca p) {
        return presencaRepository.save(p);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        presencaRepository.deleteById(id);
    }

    @PutMapping
    public Presenca putPresenca(@RequestBody Presenca p) {
        return presencaRepository.save(p);
    }

}
