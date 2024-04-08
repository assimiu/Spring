package com.ex01.api.produto.cotrolador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ex01.api.produto.entidade.Produto;
import com.ex01.api.produto.entidade.Resposta;
import com.ex01.api.produto.servico.ProdutoServico;

@RestController
public class ProdutoControle {

    @Autowired
    private ProdutoServico ps;

    @DeleteMapping("/eliminar/{id}")
    private ResponseEntity<Resposta> elimanar(@PathVariable Long id){
        return ps.eliminar(id);
    }

    @PutMapping("/alterar")
    public ResponseEntity<Produto> alterar(@RequestBody Produto produto){
        return ps.alterar(produto);
    }
    
    @GetMapping("/listar")
    public Iterable<Produto> listar(){
        return (ps.listar());
    }

    @PostMapping("/registar")
    public ResponseEntity<?> registar(@RequestBody Produto produto){
        return ps.registar(produto);
    }

    @GetMapping("/")
    public String rota(){
        return ("Api produtos funcionando  corretamente");
    }

}
