package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.ItemMst;

//@Repository
//@Transactional
//public interface ItemMstRepository extends JpaRepository<ItemMst, Long> {
//   List<ItemMst> findByItemName(String itemName);
//}