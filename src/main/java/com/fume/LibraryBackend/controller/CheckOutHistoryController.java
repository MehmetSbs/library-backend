package com.fume.LibraryBackend.controller;

import com.fume.LibraryBackend.entity.CheckOutHistory;
import com.fume.LibraryBackend.filter.CheckOutFilter;
import com.fume.LibraryBackend.service.CheckOutHistoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("checkOutHistory")
@RequiredArgsConstructor
public class CheckOutHistoryController {

  private final CheckOutHistoryService checkOutHistoryService;

  @GetMapping("/")
  public CheckOutHistory find(@RequestParam Long id){
    return checkOutHistoryService.find(id);
  }

  @GetMapping("/list")
  public List<CheckOutHistory> list(){
    return checkOutHistoryService.list();
  }

  @PostMapping("/save")
  public CheckOutHistory save(@RequestBody CheckOutHistory checkOutHistory){
    return checkOutHistoryService.save(checkOutHistory);
  }

  @GetMapping("/delete")
  public Boolean delete(Long id){
    return checkOutHistoryService.delete(id);
  }

  @PostMapping("/filter")
  public List<CheckOutHistory> filter(@RequestBody CheckOutFilter filter){
    return checkOutHistoryService.filter(filter);
  }

  @GetMapping("/user")
  public List<CheckOutHistory> listByUserId(@RequestParam Long userId){
    return checkOutHistoryService.listByUserId(userId);
  }

  @GetMapping("/book")
  public List<CheckOutHistory> listByBookId(@RequestParam Long bookId){
    return checkOutHistoryService.listByBookId(bookId);
  }

  @GetMapping("/deliver")
  public CheckOutHistory deliver(@RequestParam Long id){
    return checkOutHistoryService.deliver(id);
  }



}
