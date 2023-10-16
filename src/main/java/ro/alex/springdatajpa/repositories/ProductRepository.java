package ro.alex.springdatajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.alex.springdatajpa.models.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
