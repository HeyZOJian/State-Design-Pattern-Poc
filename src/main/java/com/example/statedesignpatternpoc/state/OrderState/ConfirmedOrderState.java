package com.example.statedesignpatternpoc.state.OrderState;

import com.example.statedesignpatternpoc.context.OrderStateContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfirmedOrderState implements OrderState {
  private static ConfirmedOrderState singleton = new ConfirmedOrderState();

  private ConfirmedOrderState() {}

  public static OrderState getInstance() {
    return singleton;
  }

  @Override
  public void createOrder(OrderStateContext orderContext, boolean hasTrailerService) {
    log.error("操作错误，订单状态为已确认");
  }

  @Override
  public void reviewTrailer(OrderStateContext orderContext) {
    log.error("操作错误，订单状态为已确认");
  }

  @Override
  public void overduePayment(OrderStateContext context) {
    log.info("超时未支付");
    context.changeState(CancelledOrderState.getInstance());
  }

  @Override
  public String toString() {
    return "已确认";
  }
}
