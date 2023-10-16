package ro.alex.springdatajpa.models.dtos;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;



@Data
public class ProductDTO implements Serializable {

    private Long id;

    @NotEmpty(message = "The product must have a name")
    private String productName;


    private double price;


    private int stock;

}
