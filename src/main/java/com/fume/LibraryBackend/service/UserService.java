package com.fume.LibraryBackend.service;

import com.fume.LibraryBackend.entity.User;
import com.fume.LibraryBackend.filter.UserFilter;
import com.fume.LibraryBackend.repository.UserRepository;
import com.fume.LibraryBackend.spec.UserSpecification;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repo;

  public User find(Long id){
    return  repo.findById(id).get();
  }

  public List<User> list(){
    return repo.findAll();
  }

  public User save(User user){
    return repo.save(user);
  }

  public Boolean delete(Long id){
    try {
      repo.deleteById(id);
      return true;
    }catch (Exception e){
      System.out.println(e);
      return false;
    }
  }

  public List<User> filter(UserFilter filter){
    return repo.findAll(UserSpecification.filterByAll(filter));
  }


}
