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
@Table(name = "products_categories")
public class ProductsCategories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "products_id", nullable = false, unique = true)
	private long products_id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "create_at", nullable = false)
	private LocalDateTime create_at;

	@Column(name = "update_at", nullable = false)
	@UpdateTimestamp
	private Timestamp update_at;

	public ProductsCategories(long id, long products_id, String name, LocalDateTime create_at, Timestamp update_at) {
		this.id = id;
		this.products_id = products_id;
		this.name = name;
		this.create_at = create_at;
		this.update_at = update_at;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProducts_id() {
		return products_id;
	}

	public void setProducts_id(long products_id) {
		this.products_id = products_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
