package io.github.fatec.introducao.controller;

import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private static PessoaReqst pessoaSalva;

    // --- POST ---
    @PostMapping
    public PessoaReqst criar(@RequestBody PessoaRequest request) {
        String novoId = UUID.randomUUID().toString();
        pessoaSalva = new PessoaReqst(novoId, request.getNome());
        return pessoaSalva;
    }

    // --- GET ---
    @GetMapping
    public PessoaReqst buscar() {
        return pessoaSalva;
    }

    // --- PUT ---
    // Recebe ID, Nome, Telefone, Endereço. Retorna ID e Nome.
    @PutMapping
    public PessoaReqst atualizar(@RequestBody PessoaRequest request) {
        pessoaSalva = new PessoaReqst(request.getId(), request.getNome());
        return pessoaSalva;
    }

    // --- 4. DELETE ---
    // Recebe ID e retorna "Usuário {id} deletado".
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable("id") String id) {
        pessoaSalva = null; // Limpa o objeto da memória
        return "Usuário " + id + " deletado";
    }


    public static class PessoaRequest {
        private String id;
        private String nome;
        private String telefone;
        private String endereco;

        // Getters e Setters necessários para o Spring converter o JSON
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }
        public String getTelefone() { return telefone; }
        public void setTelefone(String telefone) { this.telefone = telefone; }
        public String getEndereco() { return endereco; }
        public void setEndereco(String endereco) { this.endereco = endereco; }
    }

    public static class PessoaReqst {
        private String id;
        private String nome;

        public PessoaReqst(String id, String nome) {
            this.id = id;
            this.nome = nome;
        }

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }
    }
}