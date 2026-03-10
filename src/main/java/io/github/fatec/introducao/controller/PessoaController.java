package io.github.fatec.introducao.controller;

import io.github.fatec.introducao.model.Pessoa;
import io.github.fatec.introducao.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public Collection<Pessoa> listar() {
        return service.listar();
    }

    @PostMapping
    public Pessoa criar(@RequestBody Pessoa pessoa){
        return service.criar(pessoa);
    }

    @PutMapping("/{id}")
    public Pessoa atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        pessoa.setId(id);
        return service.atualizar(pessoa);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        boolean excluiu = service.deletar(id);

        if (excluiu) {
            return "Usuário com ID " + id + " deletado com sucesso!";
        } else {
            return "Usuário não encontrado.";
        }
    }
}