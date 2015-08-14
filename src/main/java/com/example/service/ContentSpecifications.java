package com.example.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.example.domain.Content;
import com.example.domain.MstItem;

public class ContentSpecifications {

  public static Specification<Content> commentContains(String comment) {
    return StringUtils.isEmpty(comment) ? null : new Specification<Content>() {
      @Override
      public Predicate toPredicate(Root<Content> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.like(root.get("comment"), "%" + comment + "%");
      }
    };
  }
  
  /**
   * 検索項目（ラムダ式版）
   * @param contentName
   * @return
   */
  public static Specification<Content> contentNamecontains(String contentName) {
    return StringUtils.isEmpty(contentName) ? null : (root, query, cb) -> {
      return cb.like(root.get("contentName"), "%" + contentName + "%");
    };
  }
  /**
   * TODO:ここにMstItemで検索できるようにする。
   * @param count
   * @return
   */
  public static Specification<Content> mstItemContain(MstItem mstItem) {
    return StringUtils.isEmpty(mstItem)||mstItem.getItemId()==0 ? null : (root, query, cb) -> {
      return cb.equal(root.get("mstItem.itemId"),  mstItem.getItemId() );
    };
  }
      
  
  
//  public static Specification<Content> countContains(int count) {
//    return StringUtils.isEmpty(count) ? null : (root, query, cb) -> {
//      return cb.greaterThan(root.get("count"),  count );
//    };
//  }
  public static Specification<Content> countContains(Integer count) {
    return StringUtils.isEmpty(count) ? null : new Specification<Content>() {
      @Override
      public Predicate toPredicate(Root<Content> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.greaterThan(root.get("count"),  count );
      }
    };
  }
  
}

//public class CustomerSpecs {
//
//  public static Specification<Customer> isLongTermCustomer() {
//    return new Specification<Customer>() {
//      public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query,
//            CriteriaBuilder builder) {
//
//         LocalDate date = new LocalDate().minusYears(2);
//         return builder.lessThan(root.get(Customer_.createdAt), date);
//      }
//    };
//  }
//
//  public static Specification<Customer> hasSalesOfMoreThan(MontaryAmount value) {
//    return new Specification<Customer>() {
//      public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
//            CriteriaBuilder builder) {
//
//         // build query here
//      }
//    };
//  }
//}
