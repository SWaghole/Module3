package com.example.Module3;

import com.example.Module3.entities.ProductEntity;
import com.example.Module3.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class Module3ApplicationTests {

    @Autowired
    ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

    @Test
    void testRepository() {
        ProductEntity productEntity = ProductEntity
                .builder()
                .sku("nestle234")
                .title("Nestle Chocolate")
                .price(BigDecimal.valueOf(23.45))
                .quantity(4)
                .build();

        ProductEntity savedProductEntity = productRepository.save(productEntity);
        System.out.println(savedProductEntity);
    }

    @Test
    void testTitle() {
       List<ProductEntity> getTitle = productRepository.findByTitle("KitKat");
        System.out.println(getTitle);
    }

    @Test
    void testAllQuantity() {
        List<Integer> quantity = productRepository.findAllQuantity();
        System.out.println(quantity);
    }
}
