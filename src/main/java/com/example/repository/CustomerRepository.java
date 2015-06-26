package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Customer;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	//@Query(value="select id,first_name,last_name,address from customers order by first_name desc",nativeQuery=true)
	@Query("SELECT a FROM Customer a ORDER BY a.firstName, a.lastName") //JPQLで指定
	Page<Customer> findAllOrderByName2(Pageable pageable);
}


