package com.flygram.serviceImpl;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.flygram.Domain.AccountProfile;
import com.util.UtilityService;

public class Main {

	public static void main(String[] args) throws Exception {
//		File file = new File(UtilityService.getSystemFilePath() + "me.jpg");
//		UtilityService.readBytesFromFile("me.jpg");
//		MultipartFile part = null;
//		UtilityService.saveFileToFolder(part);
//		AccountProfileServiceImpl a = new AccountProfileServiceImpl();
//		AccountProfile account = new AccountProfile();
//		account.setBiography("ddddd");
//		a.createAccountProfile(account);
		java.awt.Desktop.getDesktop().browse(new java.net.URI("file:///D:/fly/flyinggram/src/flyGram_UI/newsfeed.html"));
	}

}
