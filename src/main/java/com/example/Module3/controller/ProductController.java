package com.example.Module3.controller;


import com.example.Module3.entities.ProductEntity;
import com.example.Module3.repository.ProductRepository;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController()
@RequestMapping("product")
public class ProductController {

    final private int PAGE_SIZE = 5;

    final public ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping()
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy,
                                              @RequestParam(defaultValue = "0") Integer pageNumber) {

        Pageable pageable = PageRequest.of(
                pageNumber,
                PAGE_SIZE,
                Sort.by(sortBy, "price", "title")
    );
//        return productRepository.findByTitleContainingIgnoreCase(Sort.by(Sort.Direction.DESC, sortBy, "quantity", "price"), "Coca");
        LocalDateTime firstParam = LocalDate.parse("2026-11-01").atStartOfDay();
        LocalDateTime secondParam = LocalDate.parse("2026-11-04").atStartOfDay();
        return productRepository.findByCreatedAtBetweenAndUpdatedAtBetween(pageable, firstParam, secondParam, firstParam, secondParam);
    }
}
