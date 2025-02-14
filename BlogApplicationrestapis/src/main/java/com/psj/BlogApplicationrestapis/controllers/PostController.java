package com.psj.BlogApplicationrestapis.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psj.BlogApplicationrestapis.payloads.ApiResponse;
import com.psj.BlogApplicationrestapis.payloads.PostDto;
import com.psj.BlogApplicationrestapis.payloads.PostResponse;
import com.psj.BlogApplicationrestapis.services.PostService;


@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/user/{userId}/category/{categoryId}/createpost")
	public ResponseEntity<PostDto> createPost(
			@RequestBody PostDto postDto,
			@PathVariable int userId,
			@PathVariable int categoryId){
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);	
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<PostResponse> getPostByUser(@PathVariable Integer userId,
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "2", required = false) Integer pageSize){
		PostResponse postresponse = this.postService.getPostByUser(userId, pageNumber, pageSize);
		return new ResponseEntity<PostResponse>(postresponse, HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<PostResponse> getPostbyCategory(@PathVariable Integer categoryId,
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "2", required = false) Integer pageSize){
		PostResponse post = this.postService.getPostByCategory(categoryId, pageNumber, pageSize);
		return new ResponseEntity<PostResponse>(post, HttpStatus.OK);
	}
	
	@GetMapping("/getallposts")
	public ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "2", required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = "title", required = false) String sortBy){
		PostResponse postresponse = this.postService.getAllPosts(pageNumber, pageSize, sortBy);
		return new ResponseEntity<PostResponse>(postresponse, HttpStatus.OK);
	}
	
	@GetMapping("/getpost/{postId}")
	public ResponseEntity<PostDto> getPost(@PathVariable int postId){
		PostDto postDto = this.postService.getPost(postId);
		return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/deletepost/{postId}")
	public ResponseEntity<ApiResponse> deletepost(@PathVariable int postId){
		this.postService.deletePost(postId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post deleted successfully...!", true), HttpStatus.OK);
	}
	
	@PutMapping("/updatepost/{postId}")
	public ResponseEntity<PostDto> updatepost(@RequestBody PostDto post, @PathVariable int postId){
		PostDto postDto = this.postService.updatePost(post, postId);
		return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
	}
	
	@GetMapping("/searchposts/{keywords}")
	public ResponseEntity<List<PostDto>> earchPost(@PathVariable String keywords){
		List<PostDto> result = this.postService.searchPosts(keywords);
		return new ResponseEntity<List<PostDto>>(result, HttpStatus.OK);
	}
}
