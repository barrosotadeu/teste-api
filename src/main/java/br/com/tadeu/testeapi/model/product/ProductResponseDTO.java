package br.com.tadeu.testeapi.model.product;

public record ProductResponseDTO(
        Long id,
        String name,
        Float price
        ) {

    public ProductResponseDTO(Product produto){
        this(produto.getId(), produto.getName(), produto.getPrice());
    }
}
