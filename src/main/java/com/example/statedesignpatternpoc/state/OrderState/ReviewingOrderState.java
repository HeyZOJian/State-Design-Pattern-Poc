package com.example.statedesignpatternpoc.state.OrderState;

import com.example.statedesignpatternpoc.constant.OrderStateConstant;
import com.example.statedesignpatternpoc.context.OrderStateContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReviewingOrderState implements OrderState {
  private static ReviewingOrderState singleton = new ReviewingOrderState();

  private ReviewingOrderState() {}

  public static OrderState getInstance() {
    return singleton;
  }

  @Override
  public OrderStateConstant getOrderStateConstant() {
    return OrderStateConstant.REVIEWING;
  }

  @Override
  public void reviewTrailer(OrderStateContext context) {
    log.info("执行拖车审核的逻辑...拖车审核成功");
    context.changeState(ConfirmedOrderState.getInstance());
  }

  @Override
  public void overduePayment(OrderStateContext context) {
    log.info("超时未支付...");
    context.changeState(CancelledOrderState.getInstance());
  }

  @Override
  public String toString() {
    return "待审核";
  }
}
