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
  public void createOrder(OrderStateContext context, boolean hasTrailerService) {
    if (!hasTrailerService) {
      log.info("订单没有包含拖车服务");
      context.changeState(ConfirmedOrderState.getInstance());
    } else {
      log.info("订单包含拖车服务");
      context.changeState(ReviewingOrderState.getInstance());
    }
  }

  @Override
  public void reviewTrailer(OrderStateContext context) {
    log.info("拖车审核成功");
    context.changeState(ConfirmedOrderState.getInstance());
  }

  @Override
  public void overduePayment(OrderStateContext context) {
    log.info("超时未支付");
    context.changeState(CancelledOrderState.getInstance());
  }

  @Override
  public String toString() {
    return "待审核";
  }
}
