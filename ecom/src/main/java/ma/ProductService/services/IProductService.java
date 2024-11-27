package ma.ProductService.services;

import ma.ProductService.dto.ProductDto;
import ma.ProductService.dto.ProductDtoWithoutId;

import java.util.List;

public interface IProductService {

    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long id);
    ProductDto createProduct(ProductDtoWithoutId productDtoWithoutId);
    void deleteProductById(Long id);
    ProductDto updateProduct(Long id, ProductDtoWithoutId productDtoWithoutId);


}
