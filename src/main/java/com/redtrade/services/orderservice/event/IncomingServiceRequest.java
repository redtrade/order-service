package com.redtrade.services.orderservice.event;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class IncomingServiceRequest {
  private String requestMethod;
  private String requestUri;
}
