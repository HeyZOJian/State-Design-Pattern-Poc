package com.example.statedesignpatternpoc;

import com.example.statedesignpatternpoc.constant.OrderStateConstant;
import com.example.statedesignpatternpoc.context.OrderStateContext;
import com.example.statedesignpatternpoc.entity.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("订单状态变换测试")
public class OrderStateTest {
  @DisplayName("测试创建包含拖车服务的订单，订单状态应该为待审核")
  @Test
  public void testCreateOrderWithTrailerService() throws Exception {
    Order order = new Order();
    order.setHasTrailerService(true);
    order.setOrderState(OrderStateConstant.REVIEWING);
    OrderStateContext orderStateContext = new OrderStateContext(order);
    orderStateContext.createOrder();
    Assertions.assertEquals(order.getOrderState(), OrderStateConstant.REVIEWING);
  }

  @DisplayName("测试创建不包含拖车服务的订单，订单状态应该为已确认")
  @Test
  public void testCreateOrderWithoutTrailerService() throws Exception {
    Order order = new Order();
    order.setHasTrailerService(false);
    order.setOrderState(OrderStateConstant.REVIEWING);
    OrderStateContext orderStateContext = new OrderStateContext(order);
    orderStateContext.createOrder();
    Assertions.assertEquals(order.getOrderState(), OrderStateConstant.CONFIRMED);
  }

  @DisplayName("测试创建包含拖车服务的订单并进行审核，订单状态应该为已确认")
  @Test
  public void testCreateOrderWithTrailerServiceAndReviewIt() throws Exception {
    Order order = new Order();
    order.setHasTrailerService(true);
    order.setOrderState(OrderStateConstant.REVIEWING);
    OrderStateContext orderStateContext = new OrderStateContext(order);
    orderStateContext.createOrder();
    orderStateContext.reviewTrailerService();
    Assertions.assertEquals(order.getOrderState(), OrderStateConstant.CONFIRMED);
  }

  @DisplayName("测试待审核中的订单超时未支付，订单状态应该为已取消")
  @Test
  public void testConfirmedOrderOverTimePayment() throws Exception {
    Order order = new Order();
    order.setHasTrailerService(false);
    order.setOrderState(OrderStateConstant.REVIEWING);
    OrderStateContext orderStateContext = new OrderStateContext(order);
    orderStateContext.createOrder();
    orderStateContext.overduePayment();
    Assertions.assertEquals(order.getOrderState(), OrderStateConstant.CANCELLED);
  }

  @DisplayName("测试已确认的订单超时未支付，订单状态应该为已取消")
  @Test
  public void testReviewingOrderOverTimePayment() throws Exception {
    Order order = new Order();
    order.setHasTrailerService(true);
    order.setOrderState(OrderStateConstant.REVIEWING);
    OrderStateContext orderStateContext = new OrderStateContext(order);
    orderStateContext.createOrder();
    orderStateContext.overduePayment();
    Assertions.assertEquals(order.getOrderState(), OrderStateConstant.CANCELLED);
  }
}
