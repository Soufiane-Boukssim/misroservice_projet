package ma.ProductService.controllers;

import lombok.RequiredArgsConstructor;
import ma.ProductService.dto.ProductDto;
import ma.ProductService.dto.ProductDtoWithoutId;
import ma.ProductService.exceptions.ProductNotFoundException;
import ma.ProductService.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController @RequestMapping("/products") @RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("get/all")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("get/byId/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/post")
    public ProductDto addProduct(@RequestBody ProductDtoWithoutId productDtoWithoutId) {
        return productService.createProduct(productDtoWithoutId);
    }

    @DeleteMapping("/delete/productById/{id}")
    public ResponseEntity<Map<String, Object>> deleteProductById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
            productService.deleteProductById(id);
            response.put("message", "Product with id " + id + " deleted successfully");
            response.put("status", HttpStatus.OK.value());
            return ResponseEntity.ok(response);
    }


    @PutMapping("/update/productById/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDtoWithoutId productDtoWithoutId) {
        return productService.updateProduct(id,productDtoWithoutId);
    }

}
