package br.com.tadeu.testeapi.controller;

import br.com.tadeu.testeapi.model.product.Product;
import br.com.tadeu.testeapi.model.product.ProductRequestDTO;
import br.com.tadeu.testeapi.model.product.ProductResponseDTO;
import br.com.tadeu.testeapi.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;


    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> mostrarProdutos(){
        List<ProductResponseDTO> produtos = repository.findAll().stream()
                                                .map(ProductResponseDTO::new)
                                                .toList();

        return ResponseEntity.ok(produtos);
    }



    @PostMapping
    public ResponseEntity cadastrarProduct(@RequestBody @Valid ProductRequestDTO data){
        var produto = new Product(data);
        this.repository.save(produto);

        return ResponseEntity.ok().build();


    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarProduto(@PathVariable Long id){
        var produto = repository.findById(id);
        if(produto.isPresent()){
            repository.delete(produto.get());
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity alterarProduto(@PathVariable Long id,
                                         @RequestBody @Valid ProductRequestDTO data){

        var produto = repository.findById(id);

        if(produto.isPresent()){
            produto.get().atualiza(data);
            repository.save(produto.get());

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();

    }
}
