package com.flygram.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.flygram.Domain.AccountFollowship;
import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.PhotoPost;
import com.flygram.Domain.Post;
import com.flygram.Domain.PostComment;
import com.flygram.Domain.PostLike;
import com.flygram.Domain.VideoPost;
import com.flygram.service.IAccountFollowshipService;
import com.flygram.service.IAccountProfileService;
import com.flygram.service.IPostService;
import com.util.FlyGramConstant;
import com.util.UtilityService;

@RestController
public class PostController {
	private static final Logger LOGGER = Logger.getLogger(PostController.class);

	@Autowired
	IPostService service;

	@Autowired
	IAccountProfileService profileService;

	@Autowired
	IAccountFollowshipService followingService;

	@Autowired
	ServletContext servletContext;

	@Autowired
	HttpServletRequest request;

	private byte[] fileCOntent;
	private String fileType;
	private MultipartFile multipartFile;

	@PostMapping("/createPost1")
	public void createPost1(@RequestParam("file") MultipartFile file) {
		try {
			setFileCOntent(file.getBytes());
			setFileType(file.getContentType());
			setMultipartFile(file);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
	}

	@PostMapping("/createPost")
	public Post createPost(@RequestBody PostDTO post) throws Exception {
		Post object = null;
		try {

			if (fileType.startsWith("image")) {
				PhotoPost photo = new PhotoPost();
				photo.setCaption(post.getCaption());
				photo.setPath(UtilityService.saveFileToFolder(fileCOntent, multipartFile.getOriginalFilename()));
				object = service.createPost(photo);
			} else if (fileType.startsWith("video")) {
				VideoPost video = new VideoPost();
				video.setCaption(post.getCaption());
				video.setPath(UtilityService.saveFileToFolder(multipartFile));
				object = service.createPost(video);
			} else {
				throw new Exception("Unknown file format");
			}
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object;
	}

	@DeleteMapping("/deletePost{id}")
	public void deletePost(long id) {
		try {
			Post post = service.findPostById(id);
			service.deletePost(post);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
	}

	@GetMapping("/findPostById/{id}")
	public Post findPostById(@PathVariable("id") long id) {
		try {
			return service.findPostById(id);
		} catch (Exception ex) {
			LOGGER.debug(ex);
			return null;
		}
	}

	@GetMapping("/viewAllPostByAccount")
	public List<Post> findAllPostByAccount() {
		AccountProfile account = (AccountProfile) servletContext.getAttribute(FlyGramConstant.LOGGED_ACCOUNT_PROFILE);
		List<Post> list = new ArrayList<>();
		try {
			list = service.findAllPostByAccount(account);
			for (Post p : list) {
				p.setContent(UtilityService.readBytesFromFile(p.getPath()));
				p.getAccount().setProfilePic(UtilityService.readBytesFromFile(p.getAccount().getProfilePath()));
			}
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return list;
	}

	@GetMapping("/viewAllPost")
	public List<Post> findAllPost() {
		List<Post> list = new ArrayList<>();
		try {
			list = service.findAllPost();
			for (Post p : list)
				p.setContent(UtilityService.readBytesFromFile(p.getPath()));

		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return list;
	}

	@GetMapping("/viewAllFollowing")
	public List<Post> viewAllFollowing() {
		List<Post> list = new ArrayList<>();
		try {
			AccountProfile account = (AccountProfile) servletContext
					.getAttribute(FlyGramConstant.LOGGED_ACCOUNT_PROFILE);
			List<AccountFollowship> followingList = followingService.findByFollower(account);
			for (AccountFollowship p : followingList) {
				List<Post> listForOneAcct = service.findAllPostByAccount(p.getFollowing());
				for (Post post : listForOneAcct) {
					post.getAccount()
							.setProfilePic(UtilityService.readBytesFromFile(post.getAccount().getProfilePath()));
					list.add(post);
				}
			}
			for (Post p : list)
				p.setContent(UtilityService.readBytesFromFile(p.getPath()));
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return list;
	}

	@GetMapping("/findCommentByPost")
	public List<PostComment> findCommentByPost(@RequestBody Post post) {
		Post object = new Post();
		try {
			object = service.findPostById(post.getId());
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object.getPostCommentList();
	}

	@GetMapping("/findLikeByPost")
	public List<PostLike> findLikeByPost(@RequestBody Post post) {
		Post object = new Post();
		try {
			object = service.findPostById(post.getId());
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object.getPostLikeList();
	}

	@GetMapping("/findPostByLocation")
	public List<Post> findPostByLocation(@RequestBody String location) {
		List<Post> list = new ArrayList<Post>();
		try {
			service.findPostByLocation(location);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return list;
	}

	@GetMapping("/countAllPostByAccount")
	public long countAllPostByAccount(@RequestBody AccountProfile account) {
		List<Post> object = new ArrayList<>();
		try {
			AccountProfile acct = profileService.findAccountProfileById(account.getAccountId());
			object = service.findAllPostByAccount(acct);
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object.size();
	}

	@GetMapping("/countCommentByPost")
	public long countCommentByPost(@RequestBody Post post) {
		Post object = new Post();
		try {
			object = service.findPostById(post.getId());
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object.getPostCommentList().size();
	}

	@GetMapping("/countLikeByPost")
	public long countLikeByPost(@RequestBody Post post) {
		Post object = new Post();
		try {
			object = service.findPostById(post.getId());
		} catch (Exception ex) {
			LOGGER.debug(ex);
		}
		return object.getPostLikeList().size();
	}

	public byte[] getFileCOntent() {
		return fileCOntent;
	}

	public void setFileCOntent(byte[] fileCOntent) {
		this.fileCOntent = fileCOntent;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

}
