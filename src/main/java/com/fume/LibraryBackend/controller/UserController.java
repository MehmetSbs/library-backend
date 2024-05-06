package com.fume.LibraryBackend.controller;

import com.fume.LibraryBackend.entity.User;
import com.fume.LibraryBackend.filter.UserFilter;
import com.fume.LibraryBackend.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/")
  public User find(Long id){
    return userService.find(id);
  }

  @GetMapping("/list")
  public List<User> list(){
    return userService.list();
  }

  @PostMapping("/save")
  public User save(@RequestBody User user){
    return userService.save(user);
  }

  @GetMapping("/delete")
  public Boolean delete(Long id){
    return userService.delete(id);
  }

  @PostMapping("/filter")
  public List<User> filter(@RequestBody UserFilter filter){
    return userService.filter(filter);
  }



}
