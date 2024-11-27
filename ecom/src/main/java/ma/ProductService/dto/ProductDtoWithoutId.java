package ma.ProductService.dto;

import lombok.*;
import java.math.BigDecimal;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class ProductDtoWithoutId {
    private String name;
    private BigDecimal unitPrice;
    private String description;
    private String brand;
    private Integer stockQuantity;
    private String category;
}
