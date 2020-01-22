package com.example.statedesignpatternpoc.entity;

import com.example.statedesignpatternpoc.constant.OrderStateConstant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
  private OrderStateConstant orderState;
  private boolean hasTrailerService = false;
}
