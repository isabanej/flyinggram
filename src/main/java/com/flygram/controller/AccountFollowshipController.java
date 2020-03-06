package com.flygram.controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flygram.Domain.AccountFollowship;
import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.Post;
import com.flygram.service.IAccountFollowshipService;
import com.flygram.service.IAccountProfileService;
import com.util.FlyGramConstant;
import com.util.UtilityService;

@RestController
public class AccountFollowshipController {

	@Autowired
	IAccountFollowshipService service;

	@Autowired
	IAccountProfileService profileService;

	@Autowired
	ServletContext servletContext;

	@PostMapping("/follow/{accountId}")
	public void findPostCommentById(@PathVariable long accountId) throws IOException, URISyntaxException {
		AccountProfile follower = new AccountProfile();
		AccountProfile following = new AccountProfile();
		try {
			follower = (AccountProfile) servletContext.getAttribute(FlyGramConstant.LOGGED_ACCOUNT_PROFILE);
			following = profileService.findAccountProfileById(accountId);
			service.follow(follower, following);
		} catch (Exception e) {
			AccountFollowship accountToUnFollow = service.findByFollowerAndFollowing(follower, following);
			unFollow(accountToUnFollow);
		}
		send();
	}

	public void send() {
		String url = "file:///D:/flyinggram/src/flyGram_UI/newsfeed.html";
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.browse(new URI(url));
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
		} else {
			Runtime runtime = Runtime.getRuntime();
			try {
				runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	@PostMapping("/unFollow")
	public AccountFollowship unFollow(@RequestBody AccountFollowship accountFollowship) {
		AccountFollowship object = null;
		try {
			AccountFollowship accountToUnFollow = service.findAccountFollowshipById(accountFollowship.getId());
			object = service.unFollow(accountToUnFollow);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	// Find who follow you
	@GetMapping("/myFollowers")
	public List<AccountProfile> followersList() {
		AccountProfile myAccount = (AccountProfile) servletContext.getAttribute(FlyGramConstant.LOGGED_ACCOUNT_PROFILE);
		List<AccountProfile> accounts = new ArrayList<>();
		try {
			List<AccountFollowship> list = service.findByFollowing(myAccount);

			for (AccountFollowship p : list) {
				accounts.add(p.getFollower());
			}

			for (AccountProfile acc : accounts) {
				acc.setProfilePic(UtilityService.readBytesFromFile(acc.getProfilePath()));
			}
			accounts.remove(myAccount);
			return accounts;
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping("/myFollowing")
	public List<AccountProfile> followingList() {
		AccountProfile myAccount = (AccountProfile) servletContext.getAttribute(FlyGramConstant.LOGGED_ACCOUNT_PROFILE);
		List<AccountProfile> accounts = new ArrayList<>();
		try {
			List<AccountFollowship> list = service.findByFollower(myAccount);

			for (AccountFollowship p : list) {
				accounts.add(p.getFollowing());
			}

			for (AccountProfile acc : accounts) {
				acc.setProfilePic(UtilityService.readBytesFromFile(acc.getProfilePath()));
			}
			accounts.remove(myAccount);
			return accounts;
		} catch (Exception e) {
			return null;
		}
	}
}
