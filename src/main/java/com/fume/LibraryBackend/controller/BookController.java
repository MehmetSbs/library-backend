package com.fume.LibraryBackend.controller;

import com.fume.LibraryBackend.entity.Book;
import com.fume.LibraryBackend.filter.BookFilter;
import com.fume.LibraryBackend.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @GetMapping("/")
  public Book find(Long id){
    return bookService.find(id);
  }

  @GetMapping("/list")
  public List<Book> list(){
    return bookService.list();
  }

  @PostMapping("/save")
  public Book save(@RequestBody Book book){
    return bookService.save(book);
  }

  @GetMapping("/delete")
  public Boolean delete(Long id){
    return bookService.delete(id);
  }

  @PostMapping("/filter")
  public List<Book> filter(@RequestBody BookFilter filter){
    return bookService.filter(filter);
  }



}
