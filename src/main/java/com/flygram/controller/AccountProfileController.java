package com.flygram.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.flygram.Domain.AccountFollowship;
import com.flygram.Domain.AccountProfile;
import com.flygram.service.IAccountFollowshipService;
import com.flygram.service.IAccountProfileService;
import com.util.FlyGramConstant;
import com.util.UtilityService;

@RestController
@CrossOrigin(origins = "http://localhost:9595", maxAge = 3600)
public class AccountProfileController {

	@Autowired
	IAccountProfileService service;

	@Autowired
	ServletContext servletContext;

	@Autowired
	private IAccountFollowshipService followShip;

	private byte[] fileContent;

	private MultipartFile file;

	@PostMapping("/saveAccountProfile")
	public AccountProfile saveAccountProfile(@RequestBody AccountProfile account) throws Exception {
		File imageFile = new File(account.getProfilePath());
		try {
			byte[] fileContent = Files.readAllBytes(imageFile.toPath());
			if (fileContent != null || fileContent.length > 0)
				account.setProfilePath(UtilityService.saveFileToFolder(fileContent, account.getProfilePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return service.createAccountProfile(account);
	}

	@PutMapping("/updateAccountProfile/{id}")
	public AccountProfile updateStudent(@PathVariable("id") long id, @RequestBody AccountProfile acc) throws Exception {
		AccountProfile currentProfile = service.findAccountProfileById(id);
		currentProfile.setProfilePic(fileContent);
		currentProfile.setWebsite(acc.getWebsite());
		currentProfile.setBiography(acc.getBiography());
		currentProfile.setGender(acc.getGender());
		AccountProfile updatedAccount = service.updateAccountProfile(currentProfile);
		return updatedAccount;
	}

	@PostMapping("/upload")
	public AccountProfile singleFileUpload(@RequestParam("file") MultipartFile file) {
		AccountProfile account = (AccountProfile) servletContext.getAttribute(FlyGramConstant.LOGGED_ACCOUNT_PROFILE);
		try {
			account.setProfilePath(UtilityService.saveFileToFolder(file));
			AccountProfile acc = service.updateAccountProfile(account);
			acc.setProfilePic(UtilityService.readBytesFromFile(acc.getProfilePath()));
			return acc;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@DeleteMapping("/removeAccountProfile{id}")
	public void removeStudent(@PathVariable long id) {
		try {
			AccountProfile account = service.findAccountProfileById(id);
			service.deleteAccountProfile(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/viewAccountProfiles")
	public List<AccountProfile> viewAccountProfiles() {
		AccountProfile account = (AccountProfile) servletContext.getAttribute(FlyGramConstant.LOGGED_ACCOUNT_PROFILE);
		List<AccountProfile> accounts = new ArrayList<AccountProfile>();
		List<AccountProfile> list = new ArrayList<>();
		List<AccountFollowship> followship = followShip.findByFollower(account);
		try {
			list = service.viewAccountProfile();
			for (AccountProfile acc : list) {
				if (acc.getAccountId() != account.getAccountId()) {
					acc.setProfilePic(UtilityService.readBytesFromFile(acc.getProfilePath()));
					accounts.add(acc);
				}
			}
			int i = 0;
			List<AccountProfile> temp = new ArrayList<>();
			for (AccountFollowship foll : followship) {
				temp.add(foll.getFollowing());
			}

			List<AccountProfile> temp1 = new ArrayList<>();
			for (AccountProfile acc : accounts) {
				temp1.add(acc);
			}

			for (AccountProfile prof : temp) {
				for (AccountProfile acc : accounts) {
					if (acc.getAccountId() == prof.getAccountId()) {
						temp1.remove(acc);
					}
				}
			}
			accounts = temp1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@GetMapping("/findAccountProfile{id}")
	public AccountProfile findAccountProfile(@PathVariable long id) {
		try {
			return service.findAccountProfileById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/getLoggedAccountProfile")
	public AccountProfile getLoggedAccountProfile() {
		try {
			System.out.print("Byagezeyo!!!!!!!!!!!!!!!!!!!!!!!!");
			return service.getLoggedAccountProfile();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/testing")
	public ResponseEntity<?> test() {
		return ResponseEntity.ok("Test Passed");
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
