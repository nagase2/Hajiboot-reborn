package com.example.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

// Generated 2015/07/07 12:06:42 by Hibernate Tools 4.3.1

/**
 * ItemMst generated by hbm2java
 */
@Entity
@Data
// @Table(name="mst_item")//テーブル名（＝クラス名）
public class MstItem {
  @Id
  private Integer itemId;
  private Integer version;
  private String itemName;
  private Date itemExpireDate;
  private Double price;
  private Boolean deleteFlag;

  @ManyToOne(fetch = FetchType.LAZY)
  // UserとCustomerを多対一の関係にする。
  @JoinColumn(nullable = true, name = "itemTypeId")
  // Joincolumnで外部キーのカラム名を指定
  private MstItemType mstItemType;

  public MstItem() {}

  public MstItem(Integer itemId) {
    this.itemId = itemId;
  }

  public MstItem(Integer itemId, String itemName, Date itemExpireDate,
      Double price, Boolean deleteFlag) {
    this.itemId = itemId;
    this.itemName = itemName;
    this.itemExpireDate = itemExpireDate;
    this.price = price;
    this.deleteFlag = deleteFlag;
  }

  public Integer getItemId() {
    return this.itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

  public Integer getVersion() {
    return this.version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public String getItemName() {
    return this.itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public Date getItemExpireDate() {
    return this.itemExpireDate;
  }

  public void setItemExpireDate(Date itemExpireDate) {
    this.itemExpireDate = itemExpireDate;
  }

  public Double getPrice() {
    return this.price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Boolean getDeleteFlag() {
    return this.deleteFlag;
  }

  public void setDeleteFlag(Boolean deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

}
