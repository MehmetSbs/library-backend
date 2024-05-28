package com.fume.LibraryBackend.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookFilter {
  private String search;
  private Boolean isBorrowed;
}
