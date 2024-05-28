package com.fume.LibraryBackend.service;

import com.fume.LibraryBackend.entity.User;
import com.fume.LibraryBackend.filter.UserFilter;
import com.fume.LibraryBackend.repository.UserRepository;
import com.fume.LibraryBackend.spec.UserSpecification;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repo;
  private final CheckOutHistoryService checkOutHistoryService;

  public User find(Long id) {
    return repo.findById(id).get();
  }

  public List<User> list() {
    return repo.findAll();
  }

  public User save(User user) {
    return repo.save(user);
  }

  @Transactional
  public Boolean delete(Long id) {
    try {
      checkOutHistoryService.deleteAllByUserId(id);
      repo.deleteById(id);
      return true;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
  }

  public List<User> filter(UserFilter filter) {
    return repo.findAll(UserSpecification.filterByAll(filter));
  }


  public User pay(Long id) {
    User user = repo.findById(id).get();
    user.setDebt(0d);
    return repo.save(user);
  }
}
