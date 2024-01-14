package br.com.tadeu.testeapi.model.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Getter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Float price;

    public Product(ProductRequestDTO data) {
        this.name = data.name();
        this.price = data.price();
    }

    public void atualiza(ProductRequestDTO data) {
        this.name = data.name();
        this.price = data.price();
    }
}
