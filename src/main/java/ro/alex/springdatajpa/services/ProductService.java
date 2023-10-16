package ro.alex.springdatajpa.services;

import ro.alex.springdatajpa.models.dtos.ProductDTO;
import ro.alex.springdatajpa.models.entities.Product;

import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> getProductList();

    ProductDTO updateProduct(ProductDTO productDTO);

    void deleteProductDTOByID(Long productDTOId);


}
