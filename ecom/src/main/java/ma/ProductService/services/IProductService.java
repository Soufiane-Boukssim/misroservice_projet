package ma.ProductService.services;

import ma.ProductService.dto.ProductDto;
import java.util.List;

public interface IProductService {

    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long id);
    ProductDto createProduct(ProductDto productDto);
    void deleteProductById(Long id);
    ProductDto updateProduct(Long id, ProductDto productDto);


}
