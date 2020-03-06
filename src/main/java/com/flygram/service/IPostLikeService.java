package com.flygram.service;
import java.util.List;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.PostComment;
import com.flygram.Domain.PostLike;
import com.flygram.Domain.User;

public interface IPostLikeService {
	
	public PostLike createPostLike(PostLike postLike);
	
	public PostLike findById(long id);



	public List<PostLike> findAll();
	
	
	public List<PostLike> findByAccount(AccountProfile account);

}
