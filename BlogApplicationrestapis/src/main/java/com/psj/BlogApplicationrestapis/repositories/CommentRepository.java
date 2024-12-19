package com.psj.BlogApplicationrestapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psj.BlogApplicationrestapis.Entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
