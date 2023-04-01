package com.equipdevelop.gestiondestock.repository;

import java.util.List;
import java.util.Optional;

import com.equipdevelop.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

  Optional<Article> findArticleByCodeArticle(String codeArticle);

  List<Article> findAllByCategorieId(Integer idCategory);


}
