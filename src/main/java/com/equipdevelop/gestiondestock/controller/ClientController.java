package com.equipdevelop.gestiondestock.controller;

import com.equipdevelop.gestiondestock.services.ClientService;
import com.equipdevelop.gestiondestock.controller.api.ClientApi;
import com.equipdevelop.gestiondestock.dto.ClientDto;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController implements ClientApi {

  private final ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @Override
  public ClientDto save(ClientDto dto) {
    return clientService.save(dto);
  }

  @Override
  public ClientDto findById(Integer id) {
    return clientService.findById(id);
  }

  @Override
  public List<ClientDto> findAll() {
    return clientService.findAll();
  }

  @Override
  public void delete(Integer id) {
    clientService.delete(id);
  }
}
