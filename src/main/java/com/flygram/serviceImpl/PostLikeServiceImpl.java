package com.flygram.serviceImpl;


import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.PostComment;
import com.flygram.Domain.PostLike;
import com.flygram.Domain.User;

import com.flygram.dao.PostLikeDao;
import com.flygram.service.IPostLikeService;

@Service
@Transactional
public class PostLikeServiceImpl   implements IPostLikeService{
	
	
	private static final Logger LOGGER = Logger.getLogger(PostLikeServiceImpl.class);

	@Autowired
	private PostLikeDao dao;

	@Override
	public PostLike createPostLike(PostLike postLike) {
		PostLike object = null;
		try {
			
			
			object = dao.save(postLike);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object;
	}

	
	@Override
	public PostLike findById(long id) {
		PostLike postLike = null;
		try {
			postLike = dao.findById(id);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return postLike;
	}
	
	
	
	@Override
	public List<PostLike> findByAccount(AccountProfile account) {
		List<PostLike> list = new ArrayList<>();
		try {
			list = dao.findByAccount(account);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return list;
	}
	
	
	
	@Override
	public List<PostLike> findAll()
	{
		
		List<PostLike> list = new ArrayList<>();
		try {
			list =  (List<PostLike>)dao.findAll();
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return list;
	}
	
	

}
