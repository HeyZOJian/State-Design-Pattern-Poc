package com.example.statedesignpatternpoc.state.OrderState;

import com.example.statedesignpatternpoc.constant.OrderStateConstant;
import com.example.statedesignpatternpoc.context.OrderStateContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CancelledOrderState implements OrderState {
  private static CancelledOrderState singleton = new CancelledOrderState();

  private CancelledOrderState() {}

  public static OrderState getInstance() {
    return singleton;
  }

  @Override
  public OrderStateConstant getOrderStateConstant() {
    return OrderStateConstant.CANCELLED;
  }


  @Override
  public void reviewTrailer(OrderStateContext orderContext) throws Exception {
    log.error("操作错误，订单状态为已取消");
    throw new Exception("操作错误，订单状态为已取消");
  }

  @Override
  public void overduePayment(OrderStateContext orderContext) throws Exception {
    log.error("操作错误，订单状态为已取消");
    throw new Exception("操作错误，订单状态为已取消");
  }

  @Override
  public String toString() {
    return "已取消";
  }
}
