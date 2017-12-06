package com.astralticket.repository;

import com.astralticket.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p where p.productCategory.id = :categoryId")
    List<Product> findAllByProductCategory(@Param("categoryId") Long categoryId);

}
