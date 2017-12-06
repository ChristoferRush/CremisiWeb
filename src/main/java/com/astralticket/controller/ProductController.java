package com.astralticket.controller;

import com.astralticket.entity.Product;
import com.astralticket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/list")
    public String listProduct(Model model){
        List<Product> issues = productRepository.findAllByProductCategory(1L);
        List<Product> volumes = productRepository.findAllByProductCategory(2L);
        List<Product> companionBooks = productRepository.findAllByProductCategory(3L);
        List<Product> artBooks = productRepository.findAllByProductCategory(4L);
        List<Product> packs = productRepository.findAllByProductCategory(5L);
        model.addAttribute("issues", issues);
        model.addAttribute("volumes", volumes);
        model.addAttribute("companionBooks", companionBooks);
        model.addAttribute("artBooks", artBooks);
        model.addAttribute("packs", packs);
        return "products";
    }

    @RequestMapping("/add")
    public String addProduct(){
        return "product_add";
    }

}
