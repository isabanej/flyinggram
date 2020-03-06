package com.flygram.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.PostComment;
import com.flygram.Domain.PostLike;
import com.flygram.Domain.User;

public interface PostLikeDao extends CrudRepository<PostLike, Long> {

	public PostLike findById(long id);

	public List<PostLike> findByAccount(AccountProfile account);

	

	public List<PostLike> findAll();

	

}
