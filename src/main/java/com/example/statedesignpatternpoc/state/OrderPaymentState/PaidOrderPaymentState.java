package com.example.statedesignpatternpoc.state.OrderPaymentState;

import com.example.statedesignpatternpoc.constant.OrderPaymentStateConstant;
import com.example.statedesignpatternpoc.context.OrderPaymentStateContext;
import com.example.statedesignpatternpoc.entity.Order;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaidOrderPaymentState implements OrderPaymentState {
  private static PaidOrderPaymentState singleton = new PaidOrderPaymentState();

  private PaidOrderPaymentState() {}

  public static OrderPaymentState getInstance() {
    return singleton;
  }

  @Override
  public OrderPaymentStateConstant getOrderPaymentStateConstant() {
    return OrderPaymentStateConstant.PAID;
  }

  @Override
  public void pay(OrderPaymentStateContext context, BigDecimal amount, Order order) {
    log.error("支付失败，订单已支付完成");
  }

  @Override
  public void refund(OrderPaymentStateContext context, BigDecimal amount, Order order) {
    if (order.getPaidAmount().compareTo(amount) > 0) {
      log.info("退款成功");
      context.changeState(PartialPaidOrderPaymentState.getInstance());
    } else if (order.getPaidAmount().compareTo(amount) == 0) {
      log.info("退款成功");
      context.changeState(UnpaidOrderPaymentState.getInstance());
    } else {
      log.error("已付金额不足，退款失败");
    }
  }

  @Override
  public String toString() {
    return "已支付";
  }
}
