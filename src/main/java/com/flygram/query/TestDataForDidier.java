package com.flygram.query;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.EAccountPrivacy;
import com.flygram.Domain.Post;
import com.flygram.Domain.PostLike;
import com.flygram.Domain.User;

public class TestDataForDidier {

	List<AccountProfile> listAccount = new ArrayList<>();
	AccountProfile acc1 = new AccountProfile();
	AccountProfile acc2 = new AccountProfile();
	List<Post> postList = new ArrayList<>();
	List<PostLike> postLikeList = new ArrayList<>();
	User user1 = new User();
	Post post1 = new Post();
	Post post2 = new Post();

	public TestDataForDidier() {
		user1.setFullName("didier nikubwimana");
		user1.setUserId(10);

		User user2 = new User();
		user2.setFullName("karangwa paul");
		user2.setUserId(11);

		User user3 = new User();
		user3.setFullName("bizimana j");
		user3.setUserId(1);

		post1.setId(30);
		post1.setAccount(acc1);
		post1.setCaption("hhhhhh");

		postList.add(post1);

		post2.setId(31);
		post2.setAccount(acc1);
		post2.setCaption("yyyyyyy");
		// List<Post> postList=new ArrayList<>();
		postList.add(post2);
		AccountProfile acc2 = new AccountProfile();
		acc2.setUser(user2);
		acc2.setAccountId(22);
		acc2.setGender("M");
		acc2.setCreationDate(LocalDateTime.of(2016, 1, 1, 11, 40));
		acc2.setPostList(postList);
		acc2.setPrivacy(EAccountPrivacy.PUBLIC);

		acc1.setUser(user1);
		acc1.setAccountId(20);
		acc1.setGender("M");
		acc1.setCreationDate(LocalDateTime.of(2015, 1, 1, 11, 40));
		acc1.setPostList(postList);
		acc1.setPrivacy(EAccountPrivacy.PUBLIC);

		listAccount.add(acc2);
		listAccount.add(acc1);
		PostLike pl1 = new PostLike();

		pl1.setAccount(acc1);
		pl1.setId(20);
		pl1.setPost(post1);

		PostLike pl2 = new PostLike();
		pl2.setAccount(acc2);
		pl2.setId(90);
		pl2.setPost(post2);

		postLikeList.add(pl1);
		postLikeList.add(pl2);

		post2.setPostLikeList(postLikeList);

	}
}
