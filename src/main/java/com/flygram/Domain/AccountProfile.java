package com.flygram.Domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AccountProfile {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accountId;

	private String website;
	private String biography;
	private String gender;

	@Lob
	private byte[] profilePic;

	private String profilePath;

	private LocalDateTime creationDate;

	@OneToOne
	@JoinColumn(name = "user")
	private User user;

	private EAccountPrivacy privacy;

	private EAccountProfileStatus status;

	@OneToMany(mappedBy = "account")
	@JsonIgnore
	private List<PostLike> postLikeList = new ArrayList<>();

	@OneToMany(mappedBy = "account")
	@JsonIgnore
	private List<PostComment> postCommentList = new ArrayList<>();

	@OneToMany(mappedBy = "account")
	@JsonIgnore
	private List<Post> postList = new ArrayList<>();

	@OneToMany(mappedBy = "account")
	@JsonIgnore
	private List<CommentReply> commentReplyList = new ArrayList<>();

	@OneToMany(mappedBy = "account")
	@JsonIgnore
	private List<AccountProfileStatus> accountStatusList = new ArrayList<>();

	@OneToMany(mappedBy = "account")
	@JsonIgnore
	private List<AccountPrivacy> privacyList = new ArrayList<>();

	@OneToMany(mappedBy = "following")
	@JsonIgnore
	private List<AccountFollowship> followingList = new ArrayList<>();

	@OneToMany(mappedBy = "follower")
	@JsonIgnore
	private List<AccountFollowship> followerList = new ArrayList<>();

	@OneToMany(mappedBy = "toAccount")
	@JsonIgnore
	private List<AccountMessages> userMessageList;

	@OneToMany(mappedBy = "fromAccount")
	@JsonIgnore
	private List<AccountMessages> userMessageList1;

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getBiography() {
		return biography;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public byte[] getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(byte[] profilePic) {
		this.profilePic = profilePic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EAccountPrivacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(EAccountPrivacy privacy) {
		this.privacy = privacy;
	}

	public EAccountProfileStatus getStatus() {
		return status;
	}

	public void setStatus(EAccountProfileStatus status) {
		this.status = status;
	}

	public List<AccountFollowship> getFollowingList() {
		return followingList;
	}

	public void setFollowingList(List<AccountFollowship> followingList) {
		this.followingList = followingList;
	}

	public List<AccountFollowship> getFollowerList() {
		return followerList;
	}

	public void setFollowerList(List<AccountFollowship> followerList) {
		this.followerList = followerList;
	}

	public List<AccountPrivacy> getPrivacyList() {
		return privacyList;
	}

	public void setPrivacyList(List<AccountPrivacy> privacyList) {
		this.privacyList = privacyList;
	}

	public List<AccountProfileStatus> getAccountStatusList() {
		return accountStatusList;
	}

	public void setAccountStatusList(List<AccountProfileStatus> accountStatusList) {
		this.accountStatusList = accountStatusList;
	}

	public List<PostComment> getPostCommentList() {
		return postCommentList;
	}

	public void setPostCommentList(List<PostComment> postCommentList) {
		this.postCommentList = postCommentList;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	public List<CommentReply> getCommentReplyList() {
		return commentReplyList;
	}

	public void setCommentReplyList(List<CommentReply> commentReplyList) {
		this.commentReplyList = commentReplyList;
	}

	public List<PostLike> getPostLikeList() {
		return postLikeList;
	}

	public void setPostLikeList(List<PostLike> postLikeList) {
		this.postLikeList = postLikeList;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public String getProfilePath() {
		return profilePath;
	}

	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}

	public List<AccountMessages> getUserMessageList() {
		return userMessageList;
	}

	public void setUserMessageList(List<AccountMessages> userMessageList) {
		this.userMessageList = userMessageList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountId ^ (accountId >>> 32));
		result = prime * result + ((accountStatusList == null) ? 0 : accountStatusList.hashCode());
		result = prime * result + ((biography == null) ? 0 : biography.hashCode());
		result = prime * result + ((commentReplyList == null) ? 0 : commentReplyList.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((followerList == null) ? 0 : followerList.hashCode());
		result = prime * result + ((followingList == null) ? 0 : followingList.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((postCommentList == null) ? 0 : postCommentList.hashCode());
		result = prime * result + ((postLikeList == null) ? 0 : postLikeList.hashCode());
		result = prime * result + ((postList == null) ? 0 : postList.hashCode());
		result = prime * result + ((privacy == null) ? 0 : privacy.hashCode());
		result = prime * result + ((privacyList == null) ? 0 : privacyList.hashCode());
		result = prime * result + ((profilePath == null) ? 0 : profilePath.hashCode());
		result = prime * result + Arrays.hashCode(profilePic);
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((website == null) ? 0 : website.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountProfile other = (AccountProfile) obj;
		if (accountId != other.accountId)
			return false;
		if (accountStatusList == null) {
			if (other.accountStatusList != null)
				return false;
		} else if (!accountStatusList.equals(other.accountStatusList))
			return false;
		if (biography == null) {
			if (other.biography != null)
				return false;
		} else if (!biography.equals(other.biography))
			return false;
		if (commentReplyList == null) {
			if (other.commentReplyList != null)
				return false;
		} else if (!commentReplyList.equals(other.commentReplyList))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (followerList == null) {
			if (other.followerList != null)
				return false;
		} else if (!followerList.equals(other.followerList))
			return false;
		if (followingList == null) {
			if (other.followingList != null)
				return false;
		} else if (!followingList.equals(other.followingList))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (postCommentList == null) {
			if (other.postCommentList != null)
				return false;
		} else if (!postCommentList.equals(other.postCommentList))
			return false;
		if (postLikeList == null) {
			if (other.postLikeList != null)
				return false;
		} else if (!postLikeList.equals(other.postLikeList))
			return false;
		if (postList == null) {
			if (other.postList != null)
				return false;
		} else if (!postList.equals(other.postList))
			return false;
		if (privacy != other.privacy)
			return false;
		if (privacyList == null) {
			if (other.privacyList != null)
				return false;
		} else if (!privacyList.equals(other.privacyList))
			return false;
		if (profilePath == null) {
			if (other.profilePath != null)
				return false;
		} else if (!profilePath.equals(other.profilePath))
			return false;
		if (!Arrays.equals(profilePic, other.profilePic))
			return false;
		if (status != other.status)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (website == null) {
			if (other.website != null)
				return false;
		} else if (!website.equals(other.website))
			return false;
		return true;
	}

	public List<AccountMessages> getUserMessageList1() {
		return userMessageList1;
	}

	public void setUserMessageList1(List<AccountMessages> userMessageList1) {
		this.userMessageList1 = userMessageList1;
	}

}
