package com.dvoraksw.cn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NanoIdTest {

  @Test
  void next() {
    // Testing method next
    assertEquals(21, NanoId.next().length());
    assertEquals(12, NanoId.next(12, "abcdefghijklmnopqrstuvwxyz").length());
  }
}
