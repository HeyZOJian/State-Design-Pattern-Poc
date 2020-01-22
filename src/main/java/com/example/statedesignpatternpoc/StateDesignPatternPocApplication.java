package com.example.statedesignpatternpoc;

import com.example.statedesignpatternpoc.constant.OrderStateConstant;
import com.example.statedesignpatternpoc.context.OrderStateContext;
import com.example.statedesignpatternpoc.entity.Order;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StateDesignPatternPocApplication {

  public static void main(String[] args) throws Exception {
//    SpringApplication.run(StateDesignPatternPocApplication.class, args);
    Order order = new Order();
    order.setHasTrailerService(true);
    order.setOrderState(OrderStateConstant.REVIEWING);
    OrderStateContext orderStateContext = new OrderStateContext(order);
    orderStateContext.createOrder();
    orderStateContext.reviewTrailerService();
    orderStateContext.overduePayment();
  }
}
