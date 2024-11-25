//package ma.SalesManagementService.entities;
//
//import jakarta.persistence.*;
//import lombok.*;
//import ma.ClientService.entities.Client;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
//public class Sale {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @OneToOne
//    private Client client;
//
//    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
//    private List<SaleItem> saleItems = new ArrayList<>();
//
//    private double totalPrice;
//
//    private LocalDateTime saleDate;
//}
