package com.flygram.Domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PostLike {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private LocalDateTime date;
	private String description;

	@ManyToOne
	@JoinColumn(name = "post")
	private Post post;

	@ManyToOne
	@JoinColumn(name = "account")
	private AccountProfile account;

	private Boolean pyasu;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public AccountProfile getAccount() {
		return account;
	}

	public void setAccount(AccountProfile account) {
		this.account = account;
	}

	public Boolean getPyasu() {
		return pyasu;
	}

	public void setPyasu(Boolean pyasu) {
		this.pyasu = pyasu;
	}

}
