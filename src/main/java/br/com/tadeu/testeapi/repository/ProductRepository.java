package br.com.tadeu.testeapi.repository;

import br.com.tadeu.testeapi.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
