package com.revature.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Posts")
public class Post {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	@Column
	private String title;
	@Column
	private String body;
	@Column
	private String timestamp;
	@Column
	private String location;
	@Column
	private boolean like;
	@Column
	private int userId;
	@OneToMany(mappedBy = "commentList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Comments> comments;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(String title, String body, String timestamp, String location, boolean like, int userId,
			Set<Comments> comments) {
		super();
		this.title = title;
		this.body = body;
		this.timestamp = timestamp;
		this.location = location;
		this.like = like;
		this.userId = userId;
		this.comments = comments;
	}

	public Post(int postId, String title, String body, String timestamp, String location, boolean like, int userId,
			Set<Comments> comments) {
		super();
		this.postId = postId;
		this.title = title;
		this.body = body;
		this.timestamp = timestamp;
		this.location = location;
		this.like = like;
		this.userId = userId;
		this.comments = comments;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isLike() {
		return like;
	}

	public void setLike(boolean like) {
		this.like = like;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Set<Comments> getComments() {
		return comments;
	}

	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", body=" + body + ", timestamp=" + timestamp
				+ ", location=" + location + ", like=" + like + ", userId=" + userId + ", comments=" + comments + "]";
	}

}
