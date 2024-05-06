package com.fume.LibraryBackend.spec;

import com.fume.LibraryBackend.entity.Book;
import com.fume.LibraryBackend.filter.BookFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

  public static Specification<Book> filterByAll(BookFilter bookFilter) {
    return (Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {

      List<Predicate> predicates = new ArrayList<>();

      if (bookFilter.getName() != null && !bookFilter.getName().isEmpty()) {
        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
            "%" + bookFilter.getName().toLowerCase() + "%"));
      }
      if (bookFilter.getAuthor() != null && !bookFilter.getAuthor().isEmpty()) {
        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("author")),
            "%" + bookFilter.getAuthor().toLowerCase() + "%"));
      }
      if (bookFilter.getPublisher() != null && !bookFilter.getPublisher().isEmpty()) {
        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("publisher")),
            "%" + bookFilter.getPublisher().toLowerCase() + "%"));
      }if (bookFilter.getIsBorrowed() != null) {
        predicates.add(criteriaBuilder.equal(root.get("isBorrowed"), bookFilter.getIsBorrowed()));
      }

      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };

  }
}
