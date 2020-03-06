package com.flygram.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.AccountMessages;
import com.flygram.service.IAccountProfileService;
import com.flygram.service.IUserMessageService;
import com.util.FlyGramConstant;
import com.util.UtilityService;

@RestController
public class UserMessageController {
	@Autowired
	private IUserMessageService userService;

	@Autowired
	private IAccountProfileService accountService;

	@Autowired
	ServletContext servletContext;

	@Autowired
	HttpServletRequest request;

	@PostMapping("/messagecomposer/{id}")
	public AccountMessages composeMessageTo(@PathVariable("id") long id, @RequestBody AccountMessages message) {
		AccountProfile accountFrom = (AccountProfile) servletContext
				.getAttribute(FlyGramConstant.LOGGED_ACCOUNT_PROFILE);
		AccountProfile accountTo = accountService.findAccountProfileById(id);
		AccountMessages accountMessages = new AccountMessages();
		accountMessages.setMessageDescription(message.getMessageDescription());
		accountMessages.setFromAccount(accountFrom);
		accountMessages.setToAccount(accountTo);
		accountMessages.setMessageDate(LocalDateTime.now());
		return userService.composeMessage(accountMessages);
	}

	@GetMapping("/viewChatList")
	public List<AccountProfile> peopleToFollow() {
		List<AccountProfile> people = new ArrayList<AccountProfile>();
		try {
			AccountProfile loggedAccount = (AccountProfile) servletContext
					.getAttribute(FlyGramConstant.LOGGED_ACCOUNT_PROFILE);
			List<AccountProfile> accounts = accountService.viewAccountProfile();

			for (AccountProfile acc : accounts) {
				acc.setProfilePic(UtilityService.readBytesFromFile(acc.getProfilePath()));
				if (acc.getAccountId() != loggedAccount.getAccountId()) {
					people.add(acc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return people;
	}
	
	@GetMapping("/viewmessages")
	public List<AccountMessages> viewMessagees() {
		List<AccountMessages> peopleMessages = new ArrayList<>();
		try {
			AccountProfile loggedAccount = (AccountProfile) servletContext
					.getAttribute(FlyGramConstant.LOGGED_ACCOUNT_PROFILE);
			peopleMessages = userService.readAllMessages();

			for (AccountMessages acc : peopleMessages) {
				acc.getFromAccount().setProfilePic(UtilityService.readBytesFromFile(acc.getFromAccount().getProfilePath()));
				acc.getToAccount().setProfilePic(UtilityService.readBytesFromFile(acc.getToAccount().getProfilePath()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return peopleMessages;
	}

}
