package com.psj.BlogApplicationrestapis.repositories;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psj.BlogApplicationrestapis.Entities.Category;
import com.psj.BlogApplicationrestapis.Entities.Post;
import com.psj.BlogApplicationrestapis.Entities.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	
	Page<Post> findByUser(User user, Pageable pagerequest);
	
	Page<Post> findByCategory(Category categeory, Pageable pagerequest);

	List<Post> findByTitleContaining(String title);

}
