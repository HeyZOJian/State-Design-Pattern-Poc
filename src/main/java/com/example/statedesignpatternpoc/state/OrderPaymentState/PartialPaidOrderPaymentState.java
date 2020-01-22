package com.example.statedesignpatternpoc.state.OrderPaymentState;

import com.example.statedesignpatternpoc.constant.OrderPaymentStateConstant;
import com.example.statedesignpatternpoc.context.OrderPaymentStateContext;
import com.example.statedesignpatternpoc.entity.Order;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PartialPaidOrderPaymentState implements OrderPaymentState {
  private static PartialPaidOrderPaymentState singleton = new PartialPaidOrderPaymentState();

  private PartialPaidOrderPaymentState() {}

  public static OrderPaymentState getInstance() {
    return singleton;
  }

  @Override
  public OrderPaymentStateConstant getOrderPaymentStateConstant() {
    return OrderPaymentStateConstant.PARTIAL_PAID;
  }

  @Override
  public void pay(OrderPaymentStateContext context, BigDecimal amount, Order order) {
    if (order.getUnpaidAmount().compareTo(amount) >= 0) {
      log.info("尾款支付成功");
      context.changeState(PaidOrderPaymentState.getInstance());
    } else {
      log.error("尾款必须一次性支付");
    }
  }

  @Override
  public void refund(OrderPaymentStateContext context, BigDecimal amount, Order order) {
    if (order.getPaidAmount().compareTo(amount) > 0) {
      log.info("退款成功");
    } else if (order.getPaidAmount().compareTo(amount) == 0) {
      log.info("退款成功");
      context.changeState(UnpaidOrderPaymentState.getInstance());
    } else {
      log.error("已付金额不足，退款失败");
    }
  }

  @Override
  public String toString() {
    return "部分支付";
  }
}
