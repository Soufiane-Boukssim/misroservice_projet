package ma.ProductService.controllers;

import lombok.RequiredArgsConstructor;
import ma.ProductService.dto.ProductDto;
import ma.ProductService.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @DeleteMapping("/delete/productById/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @PutMapping("/update/productById/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return productService.updateProduct(id,productDto);
    }

}
