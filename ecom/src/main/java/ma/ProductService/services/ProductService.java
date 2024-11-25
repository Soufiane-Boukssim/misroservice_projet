package ma.ProductService.services;

import lombok.RequiredArgsConstructor;
import ma.ProductService.dto.ProductDto;
import ma.ProductService.entities.Product;
import ma.ProductService.exceptions.ProductNotFoundException;
import ma.ProductService.mappers.ProductMapper;
import ma.ProductService.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service @RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty())
            throw new ProductNotFoundException("Product table is empty");
        List<ProductDto> productsDto = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = productMapper.productToProductDto(product);
            productsDto.add(productDto);
        }
        return productsDto;
    }


    @Override
    public ProductDto getProductById(Long id) {
        Product product= productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        return productMapper.productToProductDto(product);
    }


    @Override
    public ProductDto createProduct(ProductDto productDtoRequest) {
        Product product=productMapper.fromProductDtoToProduct(productDtoRequest);
        product=productRepository.save(product);
        return productMapper.productToProductDto(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id)
                .ifPresentOrElse(
                        productRepository::delete,
                        () -> {
                            throw new ProductNotFoundException("Product not found with id: " + id);
                        }
                );
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDtoRequest) {
        Product product= productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product not found with id: " + id));
        product=Product.builder()
                .id(product.getId())  // Garder l'ID existant
                .name(productDtoRequest.getName())
                .unitPrice(productDtoRequest.getUnitPrice())
                .description(productDtoRequest.getDescription())
                .brand(productDtoRequest.getBrand())
                .stockQuantity(productDtoRequest.getStockQuantity())
                .category(productDtoRequest.getCategory())
                .build();
        product = productRepository.save(product);
        return productMapper.productToProductDto(product);
    }

}
