package ro.alex.springdatajpa.controllers;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ro.alex.springdatajpa.models.dtos.ProductDTO;
import ro.alex.springdatajpa.models.entities.Product;
import ro.alex.springdatajpa.services.ProductService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody @Valid ProductDTO productDTO){
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProductList(){
        return ResponseEntity.ok(productService.getProductList());
    }

    @PutMapping ("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("id") Long productId, @RequestBody @Valid ProductDTO product){
       return ResponseEntity.ok(productService.updateProduct(productId, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId){
        productService.deleteProductDTOByID(productId);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }

}
