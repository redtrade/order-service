package com.redtrade.services.orderservice.event;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OutgoingServiceResponse {
  private String requestUri;
  private String requestMethod;
  private String httpStatus;

}
