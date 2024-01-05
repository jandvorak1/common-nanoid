package com.dvoraksw.cn;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.stream.IntStream;

public class NanoId {
  private static final String SECURE_RANDOM_ALGORITHM = "SHA1PRNG";
  private static final int LENGTH = 21;
  private static final int MASK = 0x3f;
  private static final char[] ALPHABET =
      "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".toCharArray();

  public static String next() {
    try {
      // Creating random bytes sequence
      var secureRandom = SecureRandom.getInstance(SECURE_RANDOM_ALGORITHM);
      var nanoId = new StringBuilder();
      byte[] bytes = new byte[LENGTH];
      secureRandom.nextBytes(bytes);
      IntStream.range(0, LENGTH)
          .forEachOrdered(index -> nanoId.append(ALPHABET[bytes[index] & MASK]));
      return nanoId.toString();
    } catch (NoSuchAlgorithmException e) {
      // Handling errors
      throw new RuntimeException(e);
    }
  }
}
