package com.fume.LibraryBackend.repository;

import com.fume.LibraryBackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Long>,
    JpaSpecificationExecutor<User> {

}
