package com.example.domain;

// Generated 2015/07/08 11:31:23 by Hibernate Tools 4.3.1

/**
 * ItemMst generated by hbm2java
 */
public class ItemMst implements java.io.Serializable {

	private int itemId;
	private Integer version;
	private String itemName;
	private String itemExpireDate;
	private Float price;
	private Boolean deleteFlag;

	public ItemMst() {
	}

	public ItemMst(int itemId) {
		this.itemId = itemId;
	}

	public ItemMst(int itemId, String itemName, String itemExpireDate,
			Float price, Boolean deleteFlag) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemExpireDate = itemExpireDate;
		this.price = price;
		this.deleteFlag = deleteFlag;
	}

	public int getItemId() {
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

	public String getItemExpireDate() {
		return this.itemExpireDate;
	}

	public void setItemExpireDate(String itemExpireDate) {
		this.itemExpireDate = itemExpireDate;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Boolean getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
