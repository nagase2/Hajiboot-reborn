package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Customer;
import com.example.domain.MstItem;
import com.example.domain.User;
import com.example.repository.CustomerRepository;
import com.example.repository.MstItemRepository;
/**
 * カスタマのサービスクラス
 * @author nagase
 *
 */
@Service //サービスクラスであることを示す。Componentと意味は変わらない
@Transactional
public class MstItemService {
	@Autowired
	MstItemRepository mstItemRepository;
	
	/*
	 * すべてを返す
	 */
	public List<MstItem> findAll(){
		return mstItemRepository.findAll();
	}
	
	public  List<MstItem> findByItemName(String itemName){
		return mstItemRepository.findByItemName(itemName);
	}


	

}
