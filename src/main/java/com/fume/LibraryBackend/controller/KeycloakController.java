package com.fume.LibraryBackend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("keycloak")
public class KeycloakController {

  @PostMapping("/save")
  public void save(@RequestBody Object object){

    System.out.println("SAVE" + object);

  }

}
