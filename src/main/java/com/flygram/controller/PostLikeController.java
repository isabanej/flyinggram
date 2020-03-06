package com.flygram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.PostLike;
import com.flygram.service.IPostLikeService;

@RestController
@RequestMapping("/api")
public class PostLikeController {
	@Autowired
	IPostLikeService service;

	@PostMapping("/createPostLike")
	public PostLike createPostLike(@RequestBody PostLike postLike) {
		PostLike object = null;
		try {
			return service.createPostLike(postLike);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

@GetMapping("/findById/{id}")
public PostLike findById(@PathVariable long id) {
	try {
		return service.findById(id);
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}
@GetMapping("/findByAccount")
public List<PostLike> findByAccount(@RequestBody AccountProfile account)
 {
	try {
		return service.findByAccount(account);
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}


@GetMapping("/findAll")
public List<PostLike> findAll() {
	return service.findAll();
}

}

