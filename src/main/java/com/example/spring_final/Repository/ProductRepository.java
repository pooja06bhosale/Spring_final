package com.example.spring_final.Repository;

import com.example.spring_final.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/* //jpa--> lots of jpa query methods implements into orms
JpaRepository -->also interface --> interface can extends another interface
*  JpaRepository<Product, Integer> -->which model jparepo want and inside that datatype of pk
* */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //by self_service--> all product
    // findAll();-- jpa method
    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(Long id);

    // created product add into database
    Product save(Product p);
}
