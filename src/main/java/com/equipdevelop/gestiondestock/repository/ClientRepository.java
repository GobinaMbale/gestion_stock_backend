package com.equipdevelop.gestiondestock.repository;

import com.equipdevelop.gestiondestock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
