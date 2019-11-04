package com.autodesk.www.services;

import java.util.List;
import java.util.Map;

import com.autodesk.www.model.Post;

public interface PostService {

	void createPost(Post post);
	
	void deletePost(Long postId);
	
	void updatePost(Post post);
	
	Map<String, Object> findPost(Long postId);
	
	List<Post> findAllPosts();
	
}