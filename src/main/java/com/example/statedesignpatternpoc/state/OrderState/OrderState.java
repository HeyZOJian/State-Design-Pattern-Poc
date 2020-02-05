package com.example.statedesignpatternpoc.state.OrderState;

import com.example.statedesignpatternpoc.constant.OrderStateConstant;
import com.example.statedesignpatternpoc.context.OrderStateContext;

public interface OrderState {
  OrderStateConstant getOrderStateConstant();

  void reviewTrailer(OrderStateContext orderContext) throws Exception;

  void overduePayment(OrderStateContext orderContext) throws Exception;
}
