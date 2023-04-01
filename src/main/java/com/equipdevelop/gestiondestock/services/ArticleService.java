package com.equipdevelop.gestiondestock.services;

import com.equipdevelop.gestiondestock.dto.ArticleDto;
import com.equipdevelop.gestiondestock.dto.LigneCommandeClientDto;
import com.equipdevelop.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.equipdevelop.gestiondestock.dto.LigneVenteDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto dto);

    ArticleDto findById(Integer id);

    ArticleDto findByCodeArticle(String codeArticle);

    List<ArticleDto> findAll();

    List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

    List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle);

    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

    List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);

    void delete(Integer id);
}
