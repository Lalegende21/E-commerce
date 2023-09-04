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
@Table(name = "product_image")
public class ProductImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "url", nullable = false)
	private String url;

	@Column(name = "products_id", nullable = false, unique = true)
	private long products_id;

	@Column(name = "create_at", nullable = false)
	private LocalDateTime create_at;

	@Column(name = "update_at", nullable = false)
	@UpdateTimestamp
	private Timestamp update_at;

	public ProductImage(long id, String url, long products_id, LocalDateTime create_at, Timestamp update_at) {
		this.id = id;
		this.url = url;
		this.products_id = products_id;
		this.create_at = create_at;
		this.update_at = update_at;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getProducts_id() {
		return products_id;
	}

	public void setProducts_id(long products_id) {
		this.products_id = products_id;
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
