package com.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Calculates shipping charges. */
public class ShippingCalculator {
  private static final Logger LOGGER = LoggerFactory.getLogger(ShippingCalculator.class);
  private static final String EXPRESS = "EXPRESS";
  private static final String STANDARD = "STANDARD";

  /** Calculates the price for a shipment. */
  public double calculate(double weight, String type) {
    if (weight <= 0) {
      throw new IllegalArgumentException("Weight must be positive");
    }
    double price;
    if (EXPRESS.equals(type)) {
      price = weight * 5000 + 20000;
    } else if (STANDARD.equals(type)) {
      price = weight * 3000;
    } else {
      throw new IllegalArgumentException("Unknown type: " + type);
    }
    LOGGER.info("Shipping calculated: weight={}, type={}, price={}", weight, type, price);
    return price;
  }
}
