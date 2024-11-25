package ma.ProductService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.math.BigDecimal;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal unitPrice;
    private String description;
    private String brand;
    private Integer stockQuantity;
    private String category;
}
