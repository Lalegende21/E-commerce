package com.Ecommerce.entites;

import java.sql.Date;
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
@Table(name = "Paiement_Methode")
public class PaiementMethode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "user_id", nullable = false, unique = true)
	private long user_id;

	@Column(name = "ref", nullable = true, unique = true, length = 100)
	private String ref;

	@Column(name = "code", nullable = true, unique = true)
	private int code;

	@Column(name = "expired_at", nullable = true)
	private Date expired_at;

	@Column(name = "create_at", nullable = false)
	private LocalDateTime create_at;

	@Column(name = "update_at", nullable = false)
	@UpdateTimestamp
	private Timestamp update_at;

	public PaiementMethode(long id, long user_id, String ref, int code, Date expired_at, LocalDateTime create_at,
			Timestamp update_at) {
		this.id = id;
		this.user_id = user_id;
		this.ref = ref;
		this.code = code;
		this.expired_at = expired_at;
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

	public String getRef() {
		return ref;
	}

	public void setRef(String references) {
		this.ref = references;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Date getExpired_at() {
		return expired_at;
	}

	public void setExpired_at(Date expired_at) {
		this.expired_at = expired_at;
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
