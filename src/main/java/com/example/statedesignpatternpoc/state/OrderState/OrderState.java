package com.example.statedesignpatternpoc.state.OrderState;

import com.example.statedesignpatternpoc.constant.OrderStateConstant;
import com.example.statedesignpatternpoc.context.OrderStateContext;

public interface OrderState {
  OrderStateConstant getOrderStateConstant();

  void createOrder(OrderStateContext orderContext, boolean hasTrailerService);

  void reviewTrailer(OrderStateContext orderContext);

  void overduePayment(OrderStateContext orderContext);
}
