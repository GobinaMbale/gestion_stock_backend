package com.equipdevelop.gestiondestock.services.auth;

import com.equipdevelop.gestiondestock.dto.UtilisateurDto;
import com.equipdevelop.gestiondestock.exception.EntityNotFoundException;
import com.equipdevelop.gestiondestock.exception.ErrorCodes;
import com.equipdevelop.gestiondestock.model.auth.ExtendedUser;
import com.equipdevelop.gestiondestock.repository.UtilisateurRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

  private final UtilisateurRepository utilisateurRepository;

  public ApplicationUserDetailsService(UtilisateurRepository utilisateurRepository) {
    this.utilisateurRepository = utilisateurRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    UtilisateurDto utilisateur = utilisateurRepository.findUtilisateurByEmail(email)
            .map(UtilisateurDto::fromEntity)
            .orElseThrow(() -> new EntityNotFoundException(
                            "Aucun utilisateur avec l'email " + email + " n'a été trouvé dans la base de données",
                            ErrorCodes.UTILISATEUR_NOT_FOUND));

    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    utilisateur.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));

    return new ExtendedUser(utilisateur.getEmail(), utilisateur.getMoteDePasse(), utilisateur.getEntreprise().getId(), authorities);
  }
}
