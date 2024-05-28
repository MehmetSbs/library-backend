package com.fume.LibraryBackend.service;


import com.fume.LibraryBackend.entity.CheckOutHistory;
import com.fume.LibraryBackend.filter.CheckOutFilter;
import com.fume.LibraryBackend.repository.CheckOutHistoryRepository;
import com.fume.LibraryBackend.spec.CheckOutHistorySpecification;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckOutHistoryService {

  private final CheckOutHistoryRepository repo;
  private final BookService bookService;

  public CheckOutHistory find(Long id) {
    return repo.findById(id).get();
  }

  public List<CheckOutHistory> list() {
    return repo.findAll();
  }

  public CheckOutHistory save(CheckOutHistory checkOut) {

    checkOut.setStartDate(Date.valueOf(LocalDate.now()));
    checkOut.setDueDate(Date.valueOf(LocalDate.now().plusWeeks(3)));

    bookService.setIsBorrowed(checkOut.getBook().getId(), true);

    return repo.save(checkOut);
  }

  public Boolean delete(Long id) {
    try {
      repo.deleteById(id);
      return true;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
  }

  public List<CheckOutHistory> filter(CheckOutFilter filter) {
    return repo.findAll(CheckOutHistorySpecification.filterByAll(filter));
  }


  public CheckOutHistory deliver(Long id) {

    CheckOutHistory checkOutHistory = find(id);
    checkOutHistory.setIsDelivered(true);
    checkOutHistory.setDeliveryDate(Date.valueOf(LocalDate.now()));

    bookService.setIsBorrowed(checkOutHistory.getBook().getId(), false);

    return repo.save(checkOutHistory);
  }

  public List<CheckOutHistory> listByUserId(Long userId) {

    return repo.findByUser_Id(userId);
  }

  public List<CheckOutHistory> listByBookId(Long bookId) {
    return repo.findByBook_Id(bookId);
  }

  public void deleteAllByUserId(Long id) {
      repo.deleteAllByUser_Id(id);
  }

  public void deleteAllByBookId(Long id) {
    repo.deleteAllByBook_Id(id);
  }
}
