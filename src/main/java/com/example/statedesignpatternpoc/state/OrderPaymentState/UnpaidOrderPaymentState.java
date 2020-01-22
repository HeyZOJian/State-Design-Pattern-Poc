package com.example.statedesignpatternpoc.state.OrderPaymentState;

import com.example.statedesignpatternpoc.constant.OrderPaymentStateConstant;
import com.example.statedesignpatternpoc.context.OrderPaymentStateContext;
import com.example.statedesignpatternpoc.entity.Order;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnpaidOrderPaymentState implements OrderPaymentState {
  private static UnpaidOrderPaymentState singleton = new UnpaidOrderPaymentState();

  private UnpaidOrderPaymentState() {}

  public static OrderPaymentState getInstance() {
    return singleton;
  }

  @Override
  public OrderPaymentStateConstant getOrderPaymentStateConstant() {
    return OrderPaymentStateConstant.UNPAID;
  }

  @Override
  public void pay(OrderPaymentStateContext context, BigDecimal amount, Order order) {
    if (order.getTotalAmount().compareTo(amount) > 0) {
      log.info("首付款百分比支付");
      context.changeState(PartialPaidOrderPaymentState.getInstance());
    } else {
      log.info("全款支付");
      context.changeState(PaidOrderPaymentState.getInstance());
    }
  }

  @Override
  public void refund(OrderPaymentStateContext context, BigDecimal amount, Order order) {
    log.error("退款失败，订单未支付");
  }

  @Override
  public String toString() {
    return "未支付";
  }
}
