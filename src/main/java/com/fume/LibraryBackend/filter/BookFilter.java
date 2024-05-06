package com.fume.LibraryBackend.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookFilter {
  private String name;
  private String author;
  private String publisher;
  private Boolean isBorrowed;
}
