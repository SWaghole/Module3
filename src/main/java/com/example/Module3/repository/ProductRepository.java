package com.example.Module3.repository;

import com.example.Module3.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

//    List<Integer> findAllQuantity();

    List<ProductEntity> findByTitle(String title);

    List<ProductEntity> findByQuantity(Integer quantity);

    @Query("SELECT p.quantity FROM ProductEntity p")
    List<Integer> findAllQuantity();

    List<ProductEntity> findByTitleContainingIgnoreCase(Sort sortBy, String title);

    List<ProductEntity> findByCreatedAtBetweenAndUpdatedAtBetween(Pageable pageable, LocalDateTime startCreate, LocalDateTime endCreate, LocalDateTime startUpdate, LocalDateTime endUpdate);
}
