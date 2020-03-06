package com.flygram.query;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.PhotoPost;
import com.flygram.Domain.Post;
import com.flygram.Domain.PostComment;
import com.flygram.Domain.PostLike;
import com.flygram.Domain.User;
import com.flygram.Domain.VideoPost;

public class TestDataForJado {
	List<Post> expectedOldestPost;
	List<AccountProfile> expectedTopCommenters;
	List<String> expectedTopUsedWords;
	List<Post> postList;
	List<PostComment> commentList;
	List<AccountProfile> allAccountsProfile;

	public TestDataForJado() {
		User user1 = new User();
		user1.setUserId(1);
		user1.setFullName("Dusenge John");
		user1.setEmail("dusengea@gmail.com");

		User user2 = new User();
		user2.setUserId(2);
		user2.setFullName("Kamana Gilbert");
		user2.setEmail("Kamana@gmail.com");
		// Creating account profiles
		AccountProfile acc1 = new AccountProfile();
		acc1.setAccountId(1);
		acc1.setUser(user1);

		AccountProfile acc2 = new AccountProfile();
		acc2.setAccountId(2);
		acc2.setUser(user2);

		// Posts for acc1
		Post post1 = new PhotoPost();
		post1.setId(1);
		post1.setCaption("My post is cool");
		post1.setAccount(acc1);
		post1.setPostDate(LocalDateTime.of(2017, 5, 30, 9, 30));

		Post post2 = new PhotoPost();
		post2.setId(2);
		post2.setCaption("My post is very good");
		post2.setAccount(acc1);
		post2.setPostDate(LocalDateTime.of(2018, 5, 30, 9, 30));

		Post post3 = new PhotoPost();
		post3.setId(3);
		post3.setCaption("Wow, let us do this...");
		post3.setAccount(acc2);
		post3.setPostDate(LocalDateTime.of(2010, 5, 30, 9, 30));

		Post post4 = new VideoPost();
		post4.setId(4);
		post4.setCaption("Wow, let us do this...");
		post4.setAccount(acc1);
		post4.setPostDate(LocalDateTime.of(2016, 5, 30, 9, 30));

		// List of Post for account 1
		List<Post> postForAccount1 = new ArrayList<>();
		postForAccount1.add(post1);
		postForAccount1.add(post2);
		postForAccount1.add(post3);
		postForAccount1.add(post4);
		acc1.setPostList(postForAccount1);

		// Posts for acc2
		Post post5 = new PhotoPost();
		post5.setId(5);
		post5.setCaption("Great thing, is to live great people");
		post5.setAccount(acc2);
		post5.setPostDate(LocalDateTime.of(2014, 5, 30, 9, 30));

		Post post6 = new VideoPost();
		post6.setId(6);
		post6.setCaption("Good good");
		post6.setAccount(acc2);
		post6.setPostDate(LocalDateTime.of(2017, 10, 30, 9, 30));

		Post post7 = new PhotoPost();
		post7.setId(7);
		post7.setCaption("Hey buddy***");
		post7.setAccount(acc2);
		post7.setPostDate(LocalDateTime.of(2008, 5, 30, 9, 30));

		Post post8 = new VideoPost();
		post8.setId(8);
		post8.setCaption("Cool video Guys");
		post8.setAccount(acc2);
		post8.setPostDate(LocalDateTime.of(2015, 5, 30, 9, 30));

		// List of Post for account 2
		List<Post> postForAccount2 = new ArrayList<>();
		postForAccount2.add(post5);
		postForAccount2.add(post5);
		postForAccount2.add(post5);
		postForAccount2.add(post5);
		acc2.setPostList(postForAccount2);

		// Comment Information

		commentList = new ArrayList<>();
		PostComment comment1 = new PostComment();
		comment1.setId(1);
		comment1.setAccount(acc1);
		comment1.setPost(post1);
		comment1.setDescription("Eh! My God I really like that one, good");
		commentList.add(comment1);

		PostComment comment2 = new PostComment();
		comment2.setId(2);
		comment2.setAccount(acc1);
		comment2.setPost(post2);
		comment2.setDescription("Wow what a beatiful picture");
		commentList.add(comment2);

		PostComment comment3 = new PostComment();
		comment3.setId(3);
		comment3.setAccount(acc2);
		comment3.setPost(post2);
		comment3.setDescription("Very frustrating, oh! good");
		commentList.add(comment3);

		PostComment comment4 = new PostComment();
		comment4.setId(4);
		comment4.setAccount(acc1);
		comment4.setPost(post5);
		comment4.setDescription("Very much things but not looking good really.");
		commentList.add(comment4);

		// Account1 comments
		List<PostComment> commentAccount1 = new ArrayList<>();
		commentAccount1.add(comment1);
		commentAccount1.add(comment2);
		commentAccount1.add(comment4);
		acc1.setPostCommentList(commentAccount1);

		List<PostComment> commentAccount2 = new ArrayList<>();
		commentAccount2.add(comment3);
		acc2.setPostCommentList(commentAccount2);

		// List for posts
		postList = new ArrayList<>();
		postList.add(post1);
		postList.add(post2);
		postList.add(post3);
		postList.add(post4);
		postList.add(post5);
		postList.add(post6);
		postList.add(post7);
		postList.add(post8);

		PostLike postLike = new PostLike();
		postLike.setAccount(acc1);
		postLike.setDate(LocalDateTime.now());
		postLike.setId(1);
		postLike.setPost(post1);
		postLike.setPyasu(true);

		List<PostLike> postLikes1 = new ArrayList<>();
		postLikes1.add(postLike);
		post1.setPostLikeList(postLikes1);

		PostLike postLike2 = new PostLike();
		postLike.setAccount(acc1);
		postLike.setDate(LocalDateTime.now());
		postLike.setId(2);
		postLike.setPost(post2);
		postLike.setPyasu(true);

		List<PostLike> postLikes2 = new ArrayList<>();
		postLikes2.add(postLike2);
//		post2.setPostLikeList(postLikes2);

		allAccountsProfile = new ArrayList<>();
		allAccountsProfile.add(acc1);
		allAccountsProfile.add(acc2);

		expectedOldestPost = new ArrayList<>();
		expectedOldestPost.add(post7);
		expectedOldestPost.add(post3);

		expectedTopCommenters = new ArrayList<>();
		expectedTopCommenters.add(acc1);

		expectedTopUsedWords = new ArrayList<>();
		expectedTopUsedWords.add("good");
		expectedTopUsedWords.add("Very");
	}

}
