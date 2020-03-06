package com.flygram.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.flygram.Domain.AccountFollowship;
import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.User;

public class TestDataForEric {

	List<AccountProfile> accounts = new ArrayList<AccountProfile>();
	AccountProfile a1 = new AccountProfile();
	AccountProfile a2 = new AccountProfile();
	AccountProfile a3 = new AccountProfile();

	public TestDataForEric() {
		User u1 = new User();
		u1.setFullName("Emino");
		u1.setUserId(232322);

		User u2 = new User();
		u2.setFullName("Eric");
		u2.setUserId(242322);

		User u3 = new User();
		u3.setFullName("Didier");
		u3.setUserId(7772);

		User u4 = new User();
		u4.setFullName("asas");
		u4.setUserId(555);

		a1.setAccountId(12);
		a1.setUser(u1);
		a1.setGender("male");

		a2.setAccountId(22);
		a2.setUser(u2);
		a2.setGender("male");

		a3.setAccountId(32);
		a3.setUser(u3);
		a3.setGender("male");

		AccountProfile a4 = new AccountProfile();
		a4.setAccountId(77);
		a4.setUser(u4);
		a4.setGender("male");

		AccountFollowship f1 = new AccountFollowship();
		f1.setFollower(a1);
		f1.setFollowing(a2);
		a2.getFollowingList().add(f1);

		AccountFollowship f2 = new AccountFollowship();
		f2.setFollower(a2);
		f2.setFollowing(a1);
		a1.getFollowingList().add(f2);

		AccountFollowship f3 = new AccountFollowship();
		f3.setFollower(a3);
		f3.setFollowing(a2);
		a2.getFollowingList().add(f3);

		AccountFollowship f4 = new AccountFollowship();
		f4.setFollower(a1);
		f4.setFollowing(a2);
		a3.getFollowingList().add(f4);
		a2.setFollowerList(Arrays.asList(f3, f4));
		
		accounts.add(a1);
		accounts.add(a2);
		accounts.add(a3);
		accounts.add(a4);
	}
}
