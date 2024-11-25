package ma.ProductService.dto;

import lombok.*;
import java.math.BigDecimal;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class ProductDto {
    private Long id; // Utile pour les opérations de lecture ou mise à jour
    private String name;
    private BigDecimal unitPrice;
    private String description;
    private String brand;
    private Integer stockQuantity;
    private String category;
}
