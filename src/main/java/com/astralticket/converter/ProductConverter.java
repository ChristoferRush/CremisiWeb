package com.astralticket.converter;

import com.astralticket.entity.Product;
import com.astralticket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class ProductConverter implements Converter<String, Product> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product convert(String s) {
        Product product = productRepository.findOne(Long.parseLong(s));
        return product;
    }
}
