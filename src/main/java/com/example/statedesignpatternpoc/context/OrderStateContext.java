package com.example.statedesignpatternpoc.context;

import com.example.statedesignpatternpoc.entity.Order;
import com.example.statedesignpatternpoc.state.OrderState.OrderState;
import com.example.statedesignpatternpoc.state.OrderState.OrderStateFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderStateContext{
  private OrderState state;
  private Order order;

  public OrderStateContext(Order order) throws Exception {
    this.state = OrderStateFactory.getInstance(order.getOrderState());
    this.order = order;
  }

  public void changeState(OrderState state) {
    log.warn("状态更新:从 " + this.state + " 状态变为了 " + state + " 状态。");
    this.state = state;
    order.setOrderState(state.getOrderStateConstant());
  }

  public void reviewTrailerService() throws Exception {
    this.state.reviewTrailer(this);
  }

  public void overduePayment() throws Exception {
    this.state.overduePayment(this);
  }
}
