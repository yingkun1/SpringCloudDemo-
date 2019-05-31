package com.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.article.entity.Article;
import com.article.service.ArticleService;

@RestController
public class ProducerService {

	@Value("${server.port}")
	String port;

	@Autowired
	ArticleService articleService;

	@GetMapping("/articles")
	public List<Article> getAllArticles() {
		System.out.printf(" getAllArticles is called in port: " + port + "\n");
		return articleService.getAllArticles();
	}

	@PostMapping(value = "/article", consumes = "application/json")
	public void publishArticle(@RequestBody Article article) {
		articleService.insertArticle(article);
		System.out.printf(" publishArticle is called in port: " + port + "\n");
	}
}
