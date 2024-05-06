package com.fume.LibraryBackend.spec;

import com.fume.LibraryBackend.entity.User;
import com.fume.LibraryBackend.filter.UserFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

  public static Specification<User> filterByAll(UserFilter userFilter) {
    return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {

      List<Predicate> predicates = new ArrayList<>();

      if (userFilter.getNameSurname() != null && !userFilter.getNameSurname().isEmpty()) {
        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nameSurname")),
            "%" + userFilter.getNameSurname().toLowerCase() + "%"));
      }

      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };

  }
}
