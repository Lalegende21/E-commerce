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
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "sku", nullable = false)
	private String sku;

	@Column(name = "price", nullable = false, length = 100)
	private int price;

	@Column(name = "cuurency", nullable = false)
	private String currency;

	@Column(name = "brand", nullable = false, length = 50)
	private String brand;

	@Column(name = "color", nullable = false, length = 20)
	private String color;

	@Column(name = "description", nullable = false, length = 100)
	private String description;

	@Column(name = "thumbail", nullable = false)
	private String thumbmail;

	@Column(name = "create_at", nullable = false)
	private LocalDateTime create_at;

	@Column(name = "update_at", nullable = false)
	@UpdateTimestamp
	private Timestamp update_at;

	public Products(int id, String name, String sky, int price, String currency, String brand, String color,
			String description, String thumbmail, LocalDateTime create_at, Timestamp update_at) {
		this.id = id;
		this.name = name;
		this.sku = sky;
		this.price = price;
		this.currency = currency;
		this.brand = brand;
		this.color = color;
		this.description = description;
		this.thumbmail = thumbmail;
		this.create_at = create_at;
		this.update_at = update_at;
	}

	public long getId() {
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

	public String getSky() {
		return sku;
	}

	public void setSky(String sky) {
		this.sku = sky;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getThumbmail() {
		return thumbmail;
	}

	public void setThumbmail(String thumbmail) {
		this.thumbmail = thumbmail;
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
