package com.fume.LibraryBackend.filter;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckOutFilter {

  private Boolean isDelivered;
  private Date startDate;
  private Date dueDate;
  private Date deliveryDate;

  private String search;
}
