package org.spring.springboot.service;


import org.spring.springboot.domain.Article;

import java.util.List;

public interface IArticleService {

    List<Article> findArticleByUserName(String userName);

    List<Article> findArticleLikeName(String name);

    Article findArticleById(int id);
}
