package com.concretepage.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.ArticleRepository;
import com.concretepage.dao.IArticleDAO;
import com.concretepage.entity.Article;
@Service
public class ArticleService implements IArticleService {
	@Autowired
	private IArticleDAO articleDAO;
	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public Article getArticleById(int articleId) {
		Article obj = articleDAO.getArticleById(articleId);
		return obj;
	}	
	@Override
	public List<Article> getAllArticles(){
		return articleDAO.getAllArticles();
	}
	@Override
	public synchronized boolean createArticle(Article article){
		 
		SimpleDateFormat formatter =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date=new Date();
		article.setDate(date);
		
		articleRepository.save(article);

		/*if((articleRepository.ExsisistedArticles(article.getTitle(), article.getCategory())).size()>0)
		{
			return false;
		}


		else
		{
			 articleRepository.save(article);
			 return true;
		}*/
		 return true;
		
	}
	@Override
	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);
	}
	@Override
	public void deleteArticle(int articleId) {
		articleDAO.deleteArticle(articleId);
	}
}
