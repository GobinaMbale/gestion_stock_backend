package com.equipdevelop.gestiondestock.services;


import com.equipdevelop.gestiondestock.dto.ChangerMotDePasseUtilisateurDto;
import com.equipdevelop.gestiondestock.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {

  UtilisateurDto save(UtilisateurDto dto);

  UtilisateurDto findById(Integer id);

  List<UtilisateurDto> findAll();

  void delete(Integer id);

  UtilisateurDto findByEmail(String email);

  UtilisateurDto changePassword(ChangerMotDePasseUtilisateurDto dto);

  UtilisateurDto currentUser();


}
