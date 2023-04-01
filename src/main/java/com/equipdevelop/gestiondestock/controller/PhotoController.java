package com.equipdevelop.gestiondestock.controller;

import com.equipdevelop.gestiondestock.services.strategy.StrategyPhotoContext;
import com.equipdevelop.gestiondestock.controller.api.PhotoApi;
import com.flickr4java.flickr.FlickrException;
import java.io.IOException;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PhotoController implements PhotoApi {

  private final StrategyPhotoContext strategyPhotoContext;

  public PhotoController(StrategyPhotoContext strategyPhotoContext) {
    this.strategyPhotoContext = strategyPhotoContext;
  }

  @Override
  public Object savePhoto(String context, Integer id, MultipartFile photo, String title) throws IOException, FlickrException {
    return strategyPhotoContext.savePhoto(context, id, photo.getInputStream(), title);
  }
}
