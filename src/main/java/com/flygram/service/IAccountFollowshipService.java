package com.flygram.service;

import java.util.List;

import com.flygram.Domain.AccountFollowship;
import com.flygram.Domain.AccountProfile;

public interface IAccountFollowshipService {

	public AccountFollowship follow(AccountProfile follower, AccountProfile following);

	public AccountFollowship unFollow(AccountFollowship accountFollowship);

	public List<AccountFollowship> findFollowers(AccountProfile account);

	public List<AccountFollowship> findFollowing(AccountProfile account);

	public AccountFollowship findAccountFollowshipById(long id);

	public List<AccountFollowship> findByFollower(AccountProfile account);

	public List<AccountFollowship> findByFollowing(AccountProfile account);

	public AccountFollowship findByFollowerAndFollowing(AccountProfile follower, AccountProfile following);

	public AccountFollowship findByFollowingAndFollower(AccountProfile follower, AccountProfile following);

}
