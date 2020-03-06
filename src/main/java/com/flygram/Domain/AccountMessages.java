package com.flygram.Domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AccountMessages {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String messageDescription;
	private LocalDateTime messageDate;
	@ManyToOne
	@JoinColumn(name = "fromAccount")
	private AccountProfile fromAccount;

	@ManyToOne
	@JoinColumn(name = "tofAccount")
	private AccountProfile toAccount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessageDescription() {
		return messageDescription;
	}

	public void setMessageDescription(String messageDescription) {
		this.messageDescription = messageDescription;
	}

	public LocalDateTime getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(LocalDateTime messageDate) {
		this.messageDate = messageDate;
	}

	public AccountProfile getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(AccountProfile fromAccount) {
		this.fromAccount = fromAccount;
	}

	public AccountProfile getToAccount() {
		return toAccount;
	}

	public void setToAccount(AccountProfile toAccount) {
		this.toAccount = toAccount;
	}

}
