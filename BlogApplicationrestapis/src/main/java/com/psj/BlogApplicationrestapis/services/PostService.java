package com.psj.BlogApplicationrestapis.services;

import java.util.List;

import com.psj.BlogApplicationrestapis.Entities.Post;
import com.psj.BlogApplicationrestapis.payloads.PostDto;
import com.psj.BlogApplicationrestapis.payloads.PostResponse;

public interface PostService {

	PostDto createPost(PostDto post, int userId, int categoryId);
	
	PostDto updatePost(PostDto post, int postId);
	
	void deletePost(int postId);
	
	PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy); 
	
	PostDto getPost(int PostId);
	
    PostResponse getPostByCategory(Integer categoryId, Integer pageNumber, Integer pageSize);
    
    PostResponse getPostByUser(Integer userId, Integer pageNumber, Integer pageSize);
    
    List<PostDto> searchPosts(String keyword);
	
}
