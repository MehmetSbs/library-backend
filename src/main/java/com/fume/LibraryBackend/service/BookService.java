package com.fume.LibraryBackend.service;

import com.fume.LibraryBackend.entity.Book;
import com.fume.LibraryBackend.filter.BookFilter;
import com.fume.LibraryBackend.repository.BookRepository;
import com.fume.LibraryBackend.repository.CheckOutHistoryRepository;
import com.fume.LibraryBackend.spec.BookSpecification;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository repo;
  private final CheckOutHistoryRepository checkOutHistoryRepository;

  public Book find(Long id){
    return  repo.findById(id).get();
  }

  public List<Book> list(){
    return repo.findAll();
  }

  public Book save(Book book){
    return repo.save(book);
  }

  @Transactional
  public Boolean delete(Long id){
    try {
      checkOutHistoryRepository.deleteAllByBook_Id(id);
      repo.deleteById(id);
      return true;
    }catch (Exception e){
      System.out.println(e);
      return false;
    }
  }

  public List<Book> filter(BookFilter filter){
    return repo.findAll(BookSpecification.filterByAll(filter));
  }

  public Book setIsBorrowed(Long id, Boolean isBorrowed){
    Book book = repo.findById(id).get();
    book.setIsBorrowed(isBorrowed);
    return repo.save(book);
  }


}
