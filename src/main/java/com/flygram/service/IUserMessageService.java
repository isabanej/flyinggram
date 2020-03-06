package com.flygram.service;

import java.util.List;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.AccountMessages;

public interface IUserMessageService {
	public AccountMessages composeMessage(AccountMessages message);

	public List<AccountMessages> readAllMessages();

	public List<AccountMessages> findAccountMessages(AccountProfile acc);

}
