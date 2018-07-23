package com.redtrade.services.orderservice.interceptor;

import com.redtrade.services.orderservice.event.IncomingServiceRequest;
import com.redtrade.services.orderservice.event.OutgoingServiceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ServiceInterceptor extends HandlerInterceptorAdapter {

  private static final Logger LOGGER = LoggerFactory.getLogger(ServiceInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request,
      HttpServletResponse response, Object handler) throws InterruptedException {
    IncomingServiceRequest isr = new IncomingServiceRequest();
    isr.setRequestMethod(request.getMethod());
    isr.setRequestUri(request.getRequestURI());
    LOGGER.info("test");
    return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView modelAndView) {
    OutgoingServiceResponse osr = new OutgoingServiceResponse();
    osr.setRequestMethod(request.getMethod());
    osr.setRequestUri(request.getRequestURI());
    osr.setHttpStatus(new Integer(response.getStatus()).toString());
    LOGGER.info("othertest");
  }

}
