package io.github.fatec.introducao.service;

import io.github.fatec.introducao.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PessoaService {

    private final Map<Long, Pessoa> armazenamento = new HashMap<>();
    private Long proximoId = 1L;

    public Collection<Pessoa> listar() {
        return armazenamento.values();
    }

    public Pessoa criar(Pessoa pessoa) {
        pessoa.setId(proximoId++);
        armazenamento.put(pessoa.getId(), pessoa);
        return pessoa;
    }

    public Pessoa atualizar(Pessoa pessoa) {
        if (!armazenamento.containsKey(pessoa.getId())) {
            return null; // caso não exista
        }

        armazenamento.put(pessoa.getId(), pessoa);
        return pessoa;
    }

    public boolean deletar(Long id) {
        return armazenamento.remove(id) != null;
    }
}
