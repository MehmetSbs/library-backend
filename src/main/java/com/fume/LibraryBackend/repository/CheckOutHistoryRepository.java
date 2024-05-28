package com.fume.LibraryBackend.repository;

import com.fume.LibraryBackend.entity.CheckOutHistory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CheckOutHistoryRepository extends JpaRepository<CheckOutHistory, Long>,
    JpaSpecificationExecutor<CheckOutHistory> {

  List<CheckOutHistory> findByUser_Id(Long id);
  List<CheckOutHistory> findByBook_Id(Long id);


}
