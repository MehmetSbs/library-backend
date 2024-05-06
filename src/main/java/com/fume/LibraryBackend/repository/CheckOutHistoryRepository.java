package com.fume.LibraryBackend.repository;

import com.fume.LibraryBackend.entity.CheckOutHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CheckOutHistoryRepository extends JpaRepository<CheckOutHistory, Long>,
    JpaSpecificationExecutor<CheckOutHistory> {

}
