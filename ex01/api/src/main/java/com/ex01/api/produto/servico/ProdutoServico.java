package com.ex01.api.produto.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ex01.api.produto.entidade.Produto;
import com.ex01.api.produto.entidade.Resposta;
import com.ex01.api.produto.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {
    
    @Autowired
    private ProdutoRepositorio pr;

    @Autowired
    private Resposta respota;

    // Metódo para listar todos produtos do banco de dados
    public Iterable<Produto> listar(){
        return (pr.findAll());
    }

    // Método para registar produto
    public ResponseEntity<?> registar(Produto produto){

        if (produto.getNome() == null)
        {
            respota.setMenssagem("Nome de produto é obrigatório.");
            return (new ResponseEntity<Resposta>(respota, HttpStatus.BAD_REQUEST));
        }
        else if (produto.getMarca() == null)
        {
            respota.setMenssagem("Marca de produto é obrigatório.");
             return (new ResponseEntity<Resposta>(respota, HttpStatus.BAD_REQUEST));
        }
           
        else
            return new ResponseEntity<Produto>(pr.save(produto), HttpStatus.BAD_REQUEST);
    }

    // Alterar produto
    public ResponseEntity<Produto> alterar(Produto produto){
        return new ResponseEntity<Produto>(pr.save(produto), HttpStatus.OK);
    }

    // Eliminar produto
    public ResponseEntity<Resposta> eliminar(Long id){
        String mensagem = "Produto com id: " + id + " foi removido com sucesso.";
        respota.setMenssagem(mensagem);

        pr.deleteById(id);

        return new ResponseEntity<Resposta>(respota, HttpStatus.OK);
    }


}
