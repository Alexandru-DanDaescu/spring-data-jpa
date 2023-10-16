package ro.alex.springdatajpa.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.alex.springdatajpa.models.dtos.ProductDTO;
import ro.alex.springdatajpa.models.entities.Product;
import ro.alex.springdatajpa.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    private final ObjectMapper objectMapper;


    public ProductServiceImpl(ProductRepository productRepository, ObjectMapper objectMapper){
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product productEntity = objectMapper.convertValue(productDTO, Product.class);

        Product productResponseEntity = productRepository.save(productEntity);

        log.info("Product created with id : {} ", productResponseEntity.getId());

        return objectMapper.convertValue(productResponseEntity, ProductDTO.class);

    }

    @Override
    public List<ProductDTO> getProductList() {
        List<Product> productsInDB = productRepository.findAll();
        List<ProductDTO> response = new ArrayList<>();
        for(Product product : productsInDB){
            response.add(objectMapper.convertValue(product, ProductDTO.class));
        }

        return response;
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product currentProduct = productRepository.findById(id).get();
        currentProduct.setId(id);
        currentProduct.setProductName(productDTO.getProductName());
        currentProduct.setPrice(productDTO.getPrice());
        currentProduct.setStock(productDTO.getStock());
        Product responseEntity = productRepository.save(objectMapper.convertValue(currentProduct, Product.class));

        return objectMapper.convertValue(responseEntity, ProductDTO.class);
    }

    @Override
    public void deleteProductDTOByID(Long productDTOId) {
        productRepository.deleteById(productDTOId);
    }
}
