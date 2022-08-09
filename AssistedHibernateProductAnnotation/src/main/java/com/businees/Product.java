
package com.businees;
import javax.persistence.*;


@Entity
@Table(name="product details")

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	@Column
	private String name;
	@Column(length=20)
	private int qty;
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
