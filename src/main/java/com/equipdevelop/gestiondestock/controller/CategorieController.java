package com.equipdevelop.gestiondestock.controller;

import com.equipdevelop.gestiondestock.services.CategorieService;
import com.equipdevelop.gestiondestock.controller.api.CategorieApi;
import com.equipdevelop.gestiondestock.dto.CategorieDto;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategorieController implements CategorieApi {

  private final CategorieService categoryService;

  public CategorieController(CategorieService categoryService) {
    this.categoryService = categoryService;
  }

  @Override
  public CategorieDto save(CategorieDto dto) {
    return categoryService.save(dto);
  }

  @Override
  public CategorieDto findById(Integer idCategory) {
    return categoryService.findById(idCategory);
  }

  @Override
  public CategorieDto findByCode(String codeCategory) {
    return categoryService.findByCode(codeCategory);
  }

  @Override
  public List<CategorieDto> findAll() {
    return categoryService.findAll();
  }

  @Override
  public void delete(Integer id) {
    categoryService.delete(id);
  }
}
