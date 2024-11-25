//package ma.SalesManagementService.entities;
//
//import jakarta.persistence.*;
//import lombok.*;
//import ma.ProductService.entities.Product;
//
//@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
//public class SaleItem {
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @ManyToOne
//    private Sale sale;
//    @ManyToOne
//    private Product product;
//    private int quantity;
//}
