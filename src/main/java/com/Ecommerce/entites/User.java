package com.Ecommerce.entites;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = { "phone", "country_code" }) })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "firstname", nullable = false, length = 50)
	private String firstname;

	@Column(name = "lastname", nullable = false, length = 50)
	private String lastname;

	@Column(name = "email", unique = true, nullable = false, length = 50)
	private String email;

	@Column(name = "hash", nullable = false, length = 50)
	private String hash;

	@Column(name = "phone", unique = true, nullable = false, length = 15)
	private int phone;

	@Column(name = "country_code", nullable = false, length = 10)
	private int country_code;

	@Column(name = "create_at", nullable = false)
	private LocalDateTime create_at;

	@Column(name = "update_at", nullable = false)
	@UpdateTimestamp
	private Timestamp update_at;

	public User() {

	}

	public User(int id, String firstname, String lastname, String email, int phone, LocalDateTime create_at,
			Timestamp update_at) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.create_at = create_at;
		this.update_at = update_at;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public LocalDateTime getCreate_at() {
		return create_at;
	}

	@PrePersist
	public void prePersist() {
		this.create_at = LocalDateTime.now();
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
