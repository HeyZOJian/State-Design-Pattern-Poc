package com.example.statedesignpatternpoc.state.OrderPaymentState;

import com.example.statedesignpatternpoc.constant.OrderPaymentStateConstant;

public class OrderPaymentStateFactory {
  public static OrderPaymentState getInstance(OrderPaymentStateConstant orderPaymentStateConstant)
      throws Exception {
    if (OrderPaymentStateConstant.UNPAID.equals(orderPaymentStateConstant)) {
      return UnpaidOrderPaymentState.getInstance();
    } else if (OrderPaymentStateConstant.PARTIAL_PAID.equals(orderPaymentStateConstant)) {
      return PartialPaidOrderPaymentState.getInstance();
    } else if (OrderPaymentStateConstant.PAID.equals(orderPaymentStateConstant)) {
      return PaidOrderPaymentState.getInstance();
    } else {
      throw new Exception("找不到匹配的订单支付状态");
    }
  }
}
