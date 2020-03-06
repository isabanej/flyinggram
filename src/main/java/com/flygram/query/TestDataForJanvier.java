package com.flygram.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.flygram.Domain.AccountFollowship;
import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.PhotoPost;
import com.flygram.Domain.Post;
import com.flygram.Domain.PostComment;
import com.flygram.Domain.User;
import com.flygram.Domain.VideoPost;

public class TestDataForJanvier {

	List<AccountFollowship> followShip = new ArrayList<>();
	List<AccountProfile> accountList = new ArrayList<>();
	List<Post> post1 = new ArrayList<Post>();
	List<Post> post2 = new ArrayList<Post>();
	List<Post> post3 = new ArrayList<Post>();
	Post p4 = new VideoPost();
	Post p2 = new PhotoPost();
	AccountProfile ac3 = new AccountProfile();
	AccountProfile ac1 = new AccountProfile();
	AccountProfile ac2 = new AccountProfile();
	AccountProfile ac5 = new AccountProfile();
	List<PostComment> pcList1 = new ArrayList<>();
	List<PostComment> pcList2 = new ArrayList<>();
	List<PostComment> pcList3 = new ArrayList<>();
	Post p5 = new PhotoPost();

	public TestDataForJanvier() {
		User u1 = new User();
		u1.setFullName("Emino Janvier");
		u1.setEmail("isabanej@gmail.com");
		u1.setUserId(11);

		User u2 = new User();
		u2.setFullName("Didier IGIRANEZA");
		u2.setEmail("didier@gmail.com");
		u2.setUserId(22);

		User u3 = new User();
		u3.setFullName("Diana");
		u3.setEmail("mwe.diana@gmail.com");
		u3.setUserId(33);

		User u4 = new User();
		u4.setFullName("Jean de La Paix");
		u4.setEmail("dusenge@gmail.com");
		u4.setUserId(44);

		User u5 = new User();
		u5.setFullName("Eric Ntzui");
		u5.setEmail("ntzui@gmail.com");
		u5.setUserId(55);

		ac1.setAccountId(11);
		ac1.setUser(u1);

		ac2.setAccountId(22);
		ac2.setUser(u2);

		ac3.setAccountId(33);
		ac3.setUser(u3);

		AccountProfile ac4 = new AccountProfile();
		ac4.setAccountId(44);
		ac4.setUser(u4);

		ac5.setAccountId(55);
		ac5.setUser(u5);

		accountList = Arrays.asList(ac1, ac2, ac3, ac4, ac5);
		AccountFollowship af1 = new AccountFollowship();
		af1.setId(1);
		af1.setFollower(ac5);
		af1.setFollowing(ac1);

		AccountFollowship af2 = new AccountFollowship();
		af2.setId(2);
		af2.setFollower(ac5);
		af2.setFollowing(ac2);

		AccountFollowship af3 = new AccountFollowship();
		af3.setId(3);
		af3.setFollower(ac5);
		af3.setFollowing(ac3);

		followShip.add(af1);
		followShip.add(af2);
		followShip.add(af3);

		ac5.setFollowingList(followShip);

		PostComment pc1 = new PostComment();
		PostComment pc2 = new PostComment();
		PostComment pc3 = new PostComment();

		pcList1 = Arrays.asList(pc1, pc2, pc3);
		pcList2 = Arrays.asList(pc2, pc3);
		pcList3 = Arrays.asList(pc3);

		Post p1 = new PhotoPost();
		p1.setId(1);
		p1.setCaption("Test1");
		p1.setAccount(ac1);
		p1.setPostCommentList(pcList2);

		p2.setId(2);
		p2.setCaption("Test2");
		p2.setAccount(ac1);
		p2.setPostCommentList(pcList1);

		Post p3 = new PhotoPost();
		p3.setId(3);
		p3.setCaption("Test3");
		p3.setAccount(ac1);
		p3.setPostCommentList(pcList3);

		p5.setId(5);
		p5.setCaption("Test5");
		p5.setAccount(ac2);
		p5.setPostCommentList(pcList3);
		post3.add(p5);
		List<AccountFollowship> followingList1 = followShip;
		ac5.setFollowingList(followingList1);

		post1.add(p1);
		post1.add(p2);
		post1.add(p3);

		ac1.setPostList(post1);

		p4.setId(4);
		p4.setCaption("Test4");
		p4.setAccount(ac2);

		post2.add(p4);
		ac5.setPostList(post2);

	}

}
