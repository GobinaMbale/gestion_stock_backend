package com.equipdevelop.gestiondestock.repository;

import java.util.Optional;

import com.equipdevelop.gestiondestock.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

  Optional<Categorie> findCategorieByCode(String code);

}
