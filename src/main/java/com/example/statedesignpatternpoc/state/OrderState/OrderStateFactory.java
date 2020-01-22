package com.example.statedesignpatternpoc.state.OrderState;

import com.example.statedesignpatternpoc.constant.OrderStateConstant;

public class OrderStateFactory {

  public static OrderState getInstance(OrderStateConstant orderStateConstant) throws Exception {
    if (OrderStateConstant.REVIEWING.equals(orderStateConstant)) {
      return ReviewingOrderState.getInstance();
    } else if (OrderStateConstant.CONFIRMED.equals(orderStateConstant)) {
      return ConfirmedOrderState.getInstance();
    } else if (OrderStateConstant.CANCELLED.equals(orderStateConstant)) {
      return CancelledOrderState.getInstance();
    } else {
      throw new Exception("找不到匹配的状态");
    }
  }
}
