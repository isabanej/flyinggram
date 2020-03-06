package com.flygram.query;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.flygram.Domain.AccountFollowship;
import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.Post;
import com.flygram.Domain.PostLike;
import com.flygram.Domain.User;

public class TestDataForClaude {
	List<AccountProfile> listOfProfile = new ArrayList<>();
	List<Post> listOfPost = new ArrayList<>();
	AccountProfile account1 = new AccountProfile();
	AccountProfile account2 = new AccountProfile();
	AccountProfile account3 = new AccountProfile();
	AccountProfile account5 = new AccountProfile();

	public TestDataForClaude() {

		User user1 = new User();
		user1.setUserId(Long.valueOf(1));
		user1.setFullName("Jean Claude");

		account1.setAccountId(Long.valueOf(1));
		account1.setUser(user1);
		account1.setCreationDate(LocalDateTime.of(2019, 10, 20, 00, 00, 00));

		User user2 = new User();
		user2.setUserId(Long.valueOf(2));
		user2.setFullName("Eric Nkurikiyimana");

		account2.setAccountId(Long.valueOf(2));
		account2.setUser(user2);
		account2.setCreationDate(LocalDateTime.of(2019, 10, 15, 00, 00, 00));

		User user3 = new User();
		user3.setUserId(Long.valueOf(3));
		user3.setFullName("Jado Dusenge");

		account3.setAccountId(Long.valueOf(3));
		account3.setUser(user3);
		account3.setCreationDate(LocalDateTime.of(2019, 10, 14, 00, 00, 00));

		AccountProfile account4 = new AccountProfile();
		User user4 = new User();
		user4.setUserId(Long.valueOf(4));
		user4.setFullName("Emino Janvier");

		account4.setAccountId(Long.valueOf(4));
		account4.setUser(user4);
		account4.setCreationDate(LocalDateTime.of(2019, 10, 13, 00, 00, 00));

		User user5 = new User();
		user5.setUserId(Long.valueOf(5));
		user5.setFullName("Felix Didier");

		account5.setAccountId(Long.valueOf(5));
		account5.setUser(user5);
		account5.setCreationDate(LocalDateTime.of(2019, 10, 20, 00, 00, 00));

		AccountProfile account6 = new AccountProfile();
		User user6 = new User();
		user6.setUserId(Long.valueOf(6));
		user6.setFullName("Jean Didier");

		account6.setAccountId(Long.valueOf(6));
		account6.setUser(user6);
		account6.setCreationDate(LocalDateTime.of(2019, 10, 21, 00, 00, 00));

		listOfProfile = Arrays.asList(account1, account2, account3, account4, account5, account6);

		// LIKES
		PostLike like1 = new PostLike();
		like1.setId(Long.valueOf(1));
		like1.setDate(LocalDateTime.of(2019, 10, 21, 00, 00, 00));
		like1.setAccount(account1);

		PostLike like2 = new PostLike();
		like2.setId(Long.valueOf(2));
		like2.setDate(LocalDateTime.of(2019, 10, 24, 00, 00, 00));
		like2.setAccount(account2);

		PostLike like3 = new PostLike();
		like3.setId(Long.valueOf(3));
		like3.setDate(LocalDateTime.of(2019, 10, 10, 00, 00, 00));
		like3.setAccount(account3);

		PostLike like4 = new PostLike();
		like4.setId(Long.valueOf(4));
		like4.setDate(LocalDateTime.of(2019, 10, 13, 00, 00, 00));
		like4.setAccount(account4);

		PostLike like5 = new PostLike();
		like5.setId(Long.valueOf(5));
		like5.setDate(LocalDateTime.of(2019, 10, 30, 00, 00, 00));
		like5.setAccount(account5);

		// POST
		Post post1 = new Post();
		post1.setAccount(account1);
		post1.setPostLikeList(Arrays.asList(like5, like2));
		Post post2 = new Post();
		post2.setAccount(account1);
		post2.setPostLikeList(Arrays.asList(like5, like3));
		Post post3 = new Post();
		post3.setAccount(account1);
		post3.setPostLikeList(Arrays.asList(like1, like5, like2));
		Post post4 = new Post();
		post4.setAccount(account2);
		post4.setPostLikeList(Arrays.asList(like3, like5));
		Post post5 = new Post();
		post5.setAccount(account3);
		post4.setPostLikeList(Arrays.asList(like3, like4));
		Post post6 = new Post();
		post6.setAccount(account3);
		Post post7 = new Post();
		post7.setAccount(account4);
		post3.setPostLikeList(Arrays.asList(like3, like5));

		listOfPost = Arrays.asList(post1, post2, post3, post4, post5, post6, post7);
		
		AccountFollowship f1 = new AccountFollowship();
		f1.setFollowing(account1);
		f1.setFollower(account2);
		
		AccountFollowship f2 = new AccountFollowship();
		f2.setFollowing(account1);
		f2.setFollower(account3);
		
		AccountFollowship f3 = new AccountFollowship();
		f3.setFollowing(account1);
		f3.setFollower(account4);
		
		account1.getFollowerList().add(f1);
		account1.getFollowerList().add(f2);
		account1.getFollowerList().add(f3);
		
		AccountFollowship f4 = new AccountFollowship();
		f4.setFollowing(account2);
		f4.setFollower(account1);
		
		AccountFollowship f5 = new AccountFollowship();
		f5.setFollowing(account2);
		f5.setFollower(account3);
		
		AccountFollowship f6 = new AccountFollowship();
		f6.setFollowing(account2);
		f6.setFollower(account4);
		
		account2.getFollowerList().add(f4);
		account2.getFollowerList().add(f5);
		account2.getFollowerList().add(f6);
		
		AccountFollowship f7 = new AccountFollowship();
		f7.setFollowing(account3);
		f7.setFollower(account4);
		
		AccountFollowship f8 = new AccountFollowship();
		f8.setFollowing(account3);
		f8.setFollower(account2);
		
		AccountFollowship f9 = new AccountFollowship();
		f9.setFollowing(account3);
		f9.setFollower(account1);
		
		account3.getFollowerList().add(f7);
		account3.getFollowerList().add(f8);
		account3.getFollowerList().add(f9);
		
		
		AccountFollowship f10 = new AccountFollowship();
		f10.setFollowing(account4);
		f10.setFollower(account5);
		
		AccountFollowship f11 = new AccountFollowship();
		f11.setFollowing(account4);
		f11.setFollower(account3);
		
		AccountFollowship f12 = new AccountFollowship();
		f12.setFollowing(account4);
		f12.setFollower(account2);
		
		account4.getFollowerList().add(f10);
		account4.getFollowerList().add(f11);
		account4.getFollowerList().add(f12);
		
		
		AccountFollowship f13 = new AccountFollowship();
		f13.setFollowing(account5);
		f13.setFollower(account6);
		
		AccountFollowship f14 = new AccountFollowship();
		f14.setFollowing(account5);
		f14.setFollower(account3);
		
		AccountFollowship f15 = new AccountFollowship();
		f15.setFollowing(account5);
		f15.setFollower(account1);
		
		account5.getFollowerList().add(f13);
		account5.getFollowerList().add(f14);
		account5.getFollowerList().add(f15);
		
		
		AccountFollowship f16 = new AccountFollowship();
		f16.setFollowing(account6);
		f16.setFollower(account2);
		
		AccountFollowship f17 = new AccountFollowship();
		f17.setFollowing(account6);
		f17.setFollower(account3);
		
		AccountFollowship f18 = new AccountFollowship();
		f18.setFollowing(account6);
		f18.setFollower(account1);
		
		account6.getFollowerList().add(f16);
		account6.getFollowerList().add(f17);
		account6.getFollowerList().add(f18);
		
	}

}
