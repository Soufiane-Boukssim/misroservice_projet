package ma.ProductService.mappers;

import ma.ProductService.dto.ProductDto;
import ma.ProductService.dto.ProductDtoWithoutId;
import ma.ProductService.entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    private final ModelMapper modelMapper=new ModelMapper();

    public Product fromProductDtoWithoutIdToProduct(ProductDtoWithoutId productDtoWithoutId) {
        return modelMapper.map(productDtoWithoutId, Product.class);
    }

    public ProductDto productToProductDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

}
