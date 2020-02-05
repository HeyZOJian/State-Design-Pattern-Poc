package com.example.statedesignpatternpoc.service;

import com.example.statedesignpatternpoc.constant.OrderPaymentStateConstant;
import com.example.statedesignpatternpoc.constant.OrderStateConstant;
import com.example.statedesignpatternpoc.context.OrderStateContext;
import com.example.statedesignpatternpoc.entity.Order;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

  public Order createOrder(boolean hasTrail) {
    Order order = new Order();
    if (hasTrail) {
      order.setOrderState(OrderStateConstant.REVIEWING);
    } else {
      order.setOrderState(OrderStateConstant.CONFIRMED);
    }
    order.setPaymentState(OrderPaymentStateConstant.UNPAID);
    order.setTotalAmount(BigDecimal.TEN);
    order.setHasTrailerService(hasTrail);
    log.info("订单创建成功，当前订单状态为：" + order.getOrderState()+", 支付状态为："+order.getPaymentState());
    return order;
  }

  public void reviewTrail(Order order) throws Exception {
    OrderStateContext orderStateContext = new OrderStateContext(order);
    orderStateContext.reviewTrailerService();
  }

  public void handleOverduePayment(Order order) throws Exception {
    OrderStateContext orderStateContext = new OrderStateContext(order);
    orderStateContext.overduePayment();
  }
}
