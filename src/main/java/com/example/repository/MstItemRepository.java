package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Customer;
import com.example.domain.MstItem;

@Repository
@Transactional
public interface MstItemRepository extends JpaRepository<MstItem, Long> {
   List<MstItem> findByItemName(String itemName);
   
   List<MstItem> findAllOrderByItemName(Pageable pageable);
   
   Page<Customer> findAllOrderByItemId(Pageable pageable);
}