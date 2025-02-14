package com.psj.BlogApplicationrestapis.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psj.BlogApplicationrestapis.Entities.Comment;
import com.psj.BlogApplicationrestapis.Entities.Post;
import com.psj.BlogApplicationrestapis.exceptions.ResourceNotFoundException;
import com.psj.BlogApplicationrestapis.payloads.CommentDto;
import com.psj.BlogApplicationrestapis.repositories.CommentRepository;
import com.psj.BlogApplicationrestapis.repositories.PostRepository;
import com.psj.BlogApplicationrestapis.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto comment, Integer postId) {
		Optional<Post> postOptional = Optional.of(this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post id", postId)));
		Post post=postOptional.get();
		Comment comment1=this.modelMapper.map(comment, Comment.class);
		comment1.setPost(post);
		Comment saveComment=this.commentRepository.save(comment1);
		return this.modelMapper.map(saveComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Optional<Comment> CommentOptional = Optional.of(this.commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "Comment id", commentId)));
		Comment comment=CommentOptional.get();
		this.commentRepository.delete(comment);
	}

}
