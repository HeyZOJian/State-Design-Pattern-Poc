package com.example.statedesignpatternpoc;

import com.example.statedesignpatternpoc.constant.OrderPaymentStateConstant;
import com.example.statedesignpatternpoc.constant.OrderStateConstant;
import com.example.statedesignpatternpoc.context.OrderPaymentStateContext;
import com.example.statedesignpatternpoc.entity.Order;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("订单支付状态转换测试")
public class OrderPaymentStateTest {
  private Order order;
  private OrderPaymentStateContext paymentStateContext;

  @BeforeEach
  public void setUp() throws Exception {
    order = new Order();
    order.setOrderState(OrderStateConstant.CONFIRMED);
    order.setPaymentState(OrderPaymentStateConstant.UNPAID);
    order.setTotalAmount(BigDecimal.valueOf(10));
    paymentStateContext = new OrderPaymentStateContext(order);
  }

  @Test
  public void testPayAll() {
    paymentStateContext.pay(BigDecimal.valueOf(10));
    Assertions.assertEquals(order.getPaymentState(), OrderPaymentStateConstant.PAID);
  }

  @Test
  public void testPayPartial() {
    paymentStateContext.pay(BigDecimal.valueOf(1));
    Assertions.assertEquals(order.getPaymentState(), OrderPaymentStateConstant.PARTIAL_PAID);
  }

    @Test
    public void testRefund() {
        paymentStateContext.refund(BigDecimal.valueOf(1));
        Assertions.assertEquals(order.getPaymentState(), OrderPaymentStateConstant.UNPAID);
    }

}
