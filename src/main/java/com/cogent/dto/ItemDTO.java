package com.cogent.dto;

/**
 * @author: Oliver
 * @time: Jan 18, 2022-11:16:33 AM
 */
public class ItemDTO {
	private int itemId;
	private String itemName;
	private String itemCategory;
	private double price;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ItemDTO() {
		super();
	}
	
	@Override
	public String toString() {
		return "\n" + itemId + " : " + itemName + " : " + itemCategory + " : " + price + "\n";
	}
	
	
}
