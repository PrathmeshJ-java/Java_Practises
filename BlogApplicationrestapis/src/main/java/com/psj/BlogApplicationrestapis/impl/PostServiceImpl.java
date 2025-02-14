package com.psj.BlogApplicationrestapis.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.This;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.psj.BlogApplicationrestapis.Entities.Category;
import com.psj.BlogApplicationrestapis.Entities.Post;
import com.psj.BlogApplicationrestapis.Entities.User;
import com.psj.BlogApplicationrestapis.exceptions.ResourceNotFoundException;
import com.psj.BlogApplicationrestapis.payloads.PostDto;
import com.psj.BlogApplicationrestapis.payloads.PostResponse;
import com.psj.BlogApplicationrestapis.repositories.CategoryRepository;
import com.psj.BlogApplicationrestapis.repositories.PostRepository;
import com.psj.BlogApplicationrestapis.repositories.UserRepository;
import com.psj.BlogApplicationrestapis.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public PostDto createPost(PostDto post, int userId, int categoryId) {
		Optional<User> userOptional = Optional.of(this.userRepository.findById(userId).
				                           orElseThrow(()-> new ResourceNotFoundException("User", "user_id", userId)));
		User user= userOptional.get();
		Optional<Category> categoryOptional = Optional.of(this.categoryRepository.findById(categoryId).
                                                   orElseThrow(()-> new ResourceNotFoundException("Category", "category id", categoryId)));
        Category category= categoryOptional.get();
		Post addPost = this.modelMapper.map(post, Post.class);
		addPost.setImageName("default.png");
		addPost.setAddDate(new Date());
		addPost.setCategory(category);
		addPost.setUser(user);
		
		Post newPost = this.postRepository.save(addPost);
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto post, int postId) {
		Optional<Post> postOptional = Optional.of(this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post id", postId)));
		Post existingPost = postOptional.get();
		existingPost.setTitle(post.getTitle());
		existingPost.setContent(post.getContent());
		existingPost.setImageName(post.getImageName());		
		Post updatedPost = this.postRepository.save(existingPost);
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(int postId) {
		Optional<Post> postOptional = Optional.of(this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post id", postId)));
		if(postOptional.isPresent()) {
			this.postRepository.deleteById(postId);
		}
	}

	@Override
	public PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy) { 
		Pageable p = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
		Page<Post> pagePost = this.postRepository.findAll(p);
		List<Post> posts = pagePost.getContent();
//		List<Post> posts = this.postRepository.findAll();
		List<PostDto> postDtos = posts.stream().map((Post)-> this.modelMapper.map(Post, PostDto.class)).collect(Collectors.toList());
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(postDtos);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElement(pagePost.getTotalElements());
		postResponse.setTotalpages(pagePost.getTotalPages());
		postResponse.setLastpage(pagePost.isLast());
		System.out.println(postResponse.getTotalElement());		
		return postResponse;
	}

	@Override
	public PostDto getPost(int PostId) {
		Optional<Post> postOptional = Optional.of(this.postRepository.findById(PostId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post id", PostId)));
		Post post = postOptional.get();	
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostResponse getPostByCategory(Integer categoryId, Integer pageNumber, Integer pageSize) {
		Optional<Category> categoryOptional = Optional.of(this.categoryRepository.findById(categoryId).
                orElseThrow(()-> new ResourceNotFoundException("Category", "category id", categoryId)));
		Category category = categoryOptional.get();
		Pageable pageRequest = PageRequest.of(pageNumber, pageSize);
		Page<Post> postPage = this.postRepository.findByCategory(category, pageRequest);
        List<Post> posts = postPage.getContent();		
        List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        PostResponse response = new PostResponse();
        response.setContent(postDtos);
        response.setPageNumber(postPage.getNumber());
        response.setPageSize(postPage.getSize());
        response.setTotalElement(postPage.getTotalElements());
        response.setTotalpages(postPage.getTotalPages());
        response.setLastpage(postPage.isLast());
        return response;
	}

	@Override
	public PostResponse getPostByUser(Integer userId, Integer pageNumber, Integer pageSize) {
		Optional<User> userOptional = Optional.of(this.userRepository.findById(userId).
                orElseThrow(()-> new ResourceNotFoundException("User", "user_id", userId)));
		User user=userOptional.get();
		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
		Page<Post> postPage = this.postRepository.findByUser(user, pageRequest);
//		System.out.println(user.getName());
		List<Post> posts = postPage.getContent();
//		for (Post post : posts) {
//			System.out.println(post.getTitle());
//		}
		List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
//		for (PostDto post : postDtos) {
//			System.out.println(post.getTitle());
//		}
		PostResponse response = new PostResponse();
        response.setContent(postDtos);
        response.setPageNumber(postPage.getNumber());
        response.setPageSize(postPage.getSize());
        response.setTotalElement(postPage.getTotalElements());
        response.setTotalpages(postPage.getTotalPages());
        response.setLastpage(postPage.isLast());
        return response;
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		List<Post> posts = this.postRepository.findByTitleContaining(keyword);
		List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());		
		return postDtos;
	}

}
