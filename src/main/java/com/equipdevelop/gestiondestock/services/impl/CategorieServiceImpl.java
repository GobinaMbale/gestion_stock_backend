package com.equipdevelop.gestiondestock.services.impl;

import com.equipdevelop.gestiondestock.services.CategorieService;
import com.equipdevelop.gestiondestock.dto.CategorieDto;
import com.equipdevelop.gestiondestock.exception.EntityNotFoundException;
import com.equipdevelop.gestiondestock.exception.ErrorCodes;
import com.equipdevelop.gestiondestock.exception.InvalidEntityException;
import com.equipdevelop.gestiondestock.exception.InvalidOperationException;
import com.equipdevelop.gestiondestock.model.Article;
import com.equipdevelop.gestiondestock.repository.ArticleRepository;
import com.equipdevelop.gestiondestock.repository.CategorieRepository;
import com.equipdevelop.gestiondestock.validator.CategorieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategorieServiceImpl implements CategorieService {

    private final CategorieRepository categorieRepository;
    private final ArticleRepository articleRepository;

    public CategorieServiceImpl(CategorieRepository categorieRepository, ArticleRepository articleRepository) {
        this.categorieRepository = categorieRepository;
        this.articleRepository = articleRepository;
    }


    @Override
    public CategorieDto save(CategorieDto dto) {
        List<String> errors = CategorieValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("La categorie n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }
        return CategorieDto.fromEntity(
                categorieRepository.save(CategorieDto.toEntity(dto))
        );
    }

    @Override
    public CategorieDto findById(Integer id) {
        if (id == null) {
            log.error("categorie ID is null");
            return null;
        }
        return categorieRepository.findById(id)
                .map(CategorieDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune categorie avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND)
                );
    }

    @Override
    public CategorieDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("categorie CODE is null");
            return null;
        }
        return categorieRepository.findCategorieByCode(code)
                .map(CategorieDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune categorie avec le CODE = " + code + " n' ete trouve dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND)
                );
    }

    @Override
    public List<CategorieDto> findAll() {
        return categorieRepository.findAll().stream()
                .map(CategorieDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("categorie ID is null");
            return;
        }
        List<Article> articles = articleRepository.findAllByCategorieId(id);
        if (!articles.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer cette categorie qui est deja utilise",
                    ErrorCodes.CATEGORY_ALREADY_IN_USE);
        }
        categorieRepository.deleteById(id);
    }
}
