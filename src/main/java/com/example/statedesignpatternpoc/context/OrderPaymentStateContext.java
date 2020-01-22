package com.example.statedesignpatternpoc.context;

import com.example.statedesignpatternpoc.constant.OrderStateConstant;
import com.example.statedesignpatternpoc.entity.Order;
import com.example.statedesignpatternpoc.state.OrderPaymentState.OrderPaymentState;
import com.example.statedesignpatternpoc.state.OrderPaymentState.OrderPaymentStateFactory;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderPaymentStateContext {
  private OrderPaymentState state;
  private Order order;

  public OrderPaymentStateContext(Order order) throws Exception {
    this.state = OrderPaymentStateFactory.getInstance(order.getPaymentState());
    this.order = order;
  }

  public void changeState(OrderPaymentState state) {
    log.warn("支付状态更新:从 " + this.state + " 状态变为了 " + state + " 状态。");
    this.state = state;
    order.setPaymentState(state.getOrderPaymentStateConstant());
  }

  public void pay(BigDecimal amount) {
    if (order.getOrderState().equals(OrderStateConstant.CONFIRMED)) {
      this.state.pay(this, amount, order);
    } else {
      log.error("订单状态有误，支付失败");
    }
  }

  public void refund(BigDecimal amount) {
    if (order.getOrderState().equals(OrderStateConstant.CONFIRMED)) {
      this.state.refund(this, amount, order);
    } else {
      log.error("订单状态有误，退款失败");
    }
  }
}
