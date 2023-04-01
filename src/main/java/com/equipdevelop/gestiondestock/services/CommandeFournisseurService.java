package com.equipdevelop.gestiondestock.services;


import com.equipdevelop.gestiondestock.dto.CommandeFournisseurDto;
import com.equipdevelop.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.equipdevelop.gestiondestock.model.enumeration.EtatCommande;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeFournisseurService {

  CommandeFournisseurDto save(CommandeFournisseurDto dto);

  CommandeFournisseurDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande);

  CommandeFournisseurDto updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite);

  CommandeFournisseurDto updateFournisseur(Integer idCommande, Integer idFournisseur);

  CommandeFournisseurDto updateArticle(Integer idCommande, Integer idLigneCommande, Integer idArticle);

  CommandeFournisseurDto deleteArticle(Integer idCommande, Integer idLigneCommande);

  CommandeFournisseurDto findById(Integer id);

  CommandeFournisseurDto findByCode(String code);

  List<CommandeFournisseurDto> findAll();

  List<LigneCommandeFournisseurDto> findAllLignesCommandesFournisseurByCommandeFournisseurId(Integer idCommande);

  void delete(Integer id);

}
