package com.fume.LibraryBackend.spec;

import com.fume.LibraryBackend.entity.CheckOutHistory;
import com.fume.LibraryBackend.filter.CheckOutFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public class CheckOutHistorySpecification {

  public static Specification<CheckOutHistory> filterByAll(CheckOutFilter filter) {
    return (Root<CheckOutHistory> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {

      List<Predicate> predicates = new ArrayList<>();

      if (filter.getSearch() != null && !filter.getSearch().isEmpty()) {
        predicates.add(criteriaBuilder.or(
            criteriaBuilder.like(criteriaBuilder.lower(root.get("user").get("nameSurname")),
                "%" + filter.getSearch().toLowerCase() + "%"),
            criteriaBuilder.like(criteriaBuilder.lower(root.get("book").get("name")),
                "%" + filter.getSearch().toLowerCase() + "%"),
            criteriaBuilder.like(criteriaBuilder.lower(root.get("book").get("author")),
                "%" + filter.getSearch().toLowerCase() + "%"),
            criteriaBuilder.like(criteriaBuilder.lower(root.get("book").get("publisher")),
                "%" + filter.getSearch().toLowerCase() + "%")
        ));
      }

      if (filter.getStartDate() != null && !filter.getStartDate().toString().isEmpty()) {
        predicates.add(
            criteriaBuilder.like(root.get("startDate"), "%" + filter.getStartDate() + "%"));
      }
      if (filter.getDueDate() != null && !filter.getDueDate().toString().isEmpty()) {
        predicates.add(criteriaBuilder.equal(root.get("dueDate"), filter.getDueDate()));
      }
      if (filter.getDeliveryDate() != null && !filter.getDeliveryDate().toString().isEmpty()) {
        predicates.add(criteriaBuilder.equal(root.get("deliveryDate"), filter.getDeliveryDate()));
      }
      if (filter.getIsDelivered() != null) {
        predicates.add(criteriaBuilder.equal(root.get("isDelivered"), filter.getIsDelivered()));
      }

      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };

  }
}
