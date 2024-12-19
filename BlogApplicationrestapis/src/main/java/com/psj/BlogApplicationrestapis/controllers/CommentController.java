package com.psj.BlogApplicationrestapis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psj.BlogApplicationrestapis.payloads.ApiResponse;
import com.psj.BlogApplicationrestapis.payloads.CommentDto;
import com.psj.BlogApplicationrestapis.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("/savecomment/{postId}")
	public ResponseEntity<?> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId){
		CommentDto saveComment = this.commentService.createComment(comment, postId);
		return new ResponseEntity<CommentDto>(saveComment, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletecomment/{commentId}")
	public ResponseEntity<?> deleteComment(@PathVariable Integer commentId){
		this.commentService.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted Successfully..!", true), HttpStatus.OK);
	}

}
