package com.example.statedesignpatternpoc.entity;

import com.example.statedesignpatternpoc.constant.OrderPaymentStateConstant;
import com.example.statedesignpatternpoc.constant.OrderStateConstant;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
  private OrderStateConstant orderState;
  private OrderPaymentStateConstant paymentState;
  private boolean hasTrailerService = false;
  private BigDecimal totalAmount = BigDecimal.ZERO;
  private BigDecimal paidAmount = BigDecimal.ZERO;
  private BigDecimal unpaidAmount = BigDecimal.ZERO;
}
