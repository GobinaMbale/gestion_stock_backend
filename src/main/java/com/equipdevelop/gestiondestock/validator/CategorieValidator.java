package com.equipdevelop.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import com.equipdevelop.gestiondestock.dto.CategorieDto;
import org.springframework.util.StringUtils;

public class CategorieValidator {

  public static List<String> validate(CategorieDto categoryDto) {
    List<String> errors = new ArrayList<>();

    if (categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())) {
      errors.add("Veuillez renseigner le code de la categorie");
    }
    return errors;
  }

}
