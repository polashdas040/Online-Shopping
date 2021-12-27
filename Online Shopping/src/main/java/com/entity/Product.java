package com.entity;


public class Product {

	private int id;
	private String proname;
	private String category;
	private String price;
	private String status;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String proname,String category, String price, String status) {
		super();
		this.proname = proname;
		this.category = category;
		this.price = price;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", proname=" + proname + ", category=" + category + ", price=" + price
				+ ", status=" + status + "]";
	}

	
}