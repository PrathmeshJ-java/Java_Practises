package com.psj.BlogApplicationrestapis.services;

import com.psj.BlogApplicationrestapis.Entities.Comment;
import com.psj.BlogApplicationrestapis.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto comment, Integer postId);
	
	void deleteComment(Integer commentId);
}
