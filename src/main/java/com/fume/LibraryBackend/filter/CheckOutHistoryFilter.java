package com.fume.LibraryBackend.filter;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckOutHistoryFilter {

  private Boolean isDelivered;
  private Date startDate;
  private Date dueDate;
  private Date deliveryDate;

  private String bookName;
  private String bookAuthor;
  private String bookPublisher;

  private String userNameSurname;
}
