package com.Ecommerce.entites;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "user_id", nullable = false, unique = true)
	private long user_id;

	@Column(name = "products_id", nullable = false, unique = true)
	private long products_id;

	@Column(name = "quantity", nullable = false, length = 100)
	private int quantity;

	@Column(name = "total", nullable = false)
	private long total;

	@Column(name = "currency", nullable = false)
	private String currency;

	@Column(name = "taxe", nullable = true)
	private long taxe;

	@Column(name = "discount", nullable = true)
	private long discount;

	@Column(name = "create_at", nullable = false)
	private LocalDateTime create_at;

	@Column(name = "update_at", nullable = false)
	@UpdateTimestamp
	private Timestamp update_at;

	public Orders(long id, long user_id, long products_id, int quantity, long total, String currency, long taxe,
			long discount, LocalDateTime create_at, Timestamp update_at) {
		this.id = id;
		this.user_id = user_id;
		this.products_id = products_id;
		this.quantity = quantity;
		this.total = total;
		this.currency = currency;
		this.taxe = taxe;
		this.discount = discount;
		this.create_at = create_at;
		this.update_at = update_at;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getProducts_id() {
		return products_id;
	}

	public void setProducts_id(long products_id) {
		this.products_id = products_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public long getTaxe() {
		return taxe;
	}

	public void setTaxe(long taxe) {
		this.taxe = taxe;
	}

	public long getDiscount() {
		return discount;
	}

	public void setDiscount(long discount) {
		this.discount = discount;
	}

	public LocalDateTime getCreate_at() {
		return create_at;
	}

	public void setCreate_at(LocalDateTime create_at) {
		this.create_at = create_at;
	}

	public Timestamp getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(Timestamp update_at) {
		this.update_at = update_at;
	}

}
