package com.example.statedesignpatternpoc.state.OrderPaymentState;

import com.example.statedesignpatternpoc.constant.OrderPaymentStateConstant;
import com.example.statedesignpatternpoc.context.OrderPaymentStateContext;
import com.example.statedesignpatternpoc.entity.Order;
import java.math.BigDecimal;

public interface OrderPaymentState {
  OrderPaymentStateConstant getOrderPaymentStateConstant();

  void pay(OrderPaymentStateContext orderPaymentStateContext, BigDecimal amount, Order order);

  void refund(OrderPaymentStateContext orderPaymentStateContext, BigDecimal amount, Order order);
}
