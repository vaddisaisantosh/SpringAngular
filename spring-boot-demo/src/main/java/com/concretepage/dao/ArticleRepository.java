package com.concretepage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.concretepage.entity.Article;

public interface ArticleRepository extends CrudRepository<Article,Integer>{
	
	@Query(value="select a from Article a where a.title=:title and a.category=:category ")
	public List<Article> ExsisistedArticles(@Param(value="title")String title,@Param(value="category")String category);

}    
