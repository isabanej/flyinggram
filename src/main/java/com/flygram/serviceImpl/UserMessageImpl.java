package com.flygram.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.AccountMessages;
import com.flygram.dao.UserMessageDao;
import com.flygram.service.IUserMessageService;

@Service
public class UserMessageImpl implements IUserMessageService {

	@Autowired
	private UserMessageDao messageDao;

	@Override
	public AccountMessages composeMessage(AccountMessages message) {
		return messageDao.save(message);
	}

	@Override
	public List<AccountMessages> readAllMessages() {
		return (List<AccountMessages>) messageDao.findAll();
	}

	@Override
	public List<AccountMessages> findAccountMessages(AccountProfile acc) {
		List<AccountMessages> userMessageList = new ArrayList<AccountMessages>();
		for (AccountMessages ac : readAllMessages()) {
			if (ac.getToAccount().getAccountId() == acc.getAccountId()) {
				userMessageList.add(ac);
			}
		}
		return userMessageList;
	}

}
