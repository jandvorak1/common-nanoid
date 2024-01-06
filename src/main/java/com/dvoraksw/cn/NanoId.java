package com.dvoraksw.cn;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.stream.IntStream;

/** The class implements NanoId generator. */
public class NanoId {
  private static final String SECURE_RANDOM_ALGORITHM = "SHA1PRNG";
  private static final int DEFAULT_LENGTH = 21;
  private static final String DEFAULT_ALPHABET =
      "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";

  /**
   * Creates a new instance of the NanoId generator.
   *
   * @since 0.1.0
   */
  protected NanoId() {}

  /**
   * Returns a URL-friendly NanoId with a length of 21 characters."
   *
   * @return String containing NanoId
   * @since 0.1.0
   */
  public static String next() {
    try {
      // Generating nanoid with default setting
      var secureRandom = SecureRandom.getInstance(SECURE_RANDOM_ALGORITHM);
      var chars = DEFAULT_ALPHABET.toCharArray();
      var nanoId = new StringBuilder();
      byte[] bytes = new byte[DEFAULT_LENGTH];
      secureRandom.nextBytes(bytes);
      IntStream.range(0, DEFAULT_LENGTH)
          .forEachOrdered(index -> nanoId.append(chars[bytes[index] & chars.length - 1]));
      return nanoId.toString();
    } catch (NoSuchAlgorithmException e) {
      // Handling errors
      throw new RuntimeException(e);
    }
  }

  /**
   * Returns a NanoId with custom settings."
   *
   * @param length Desired length of NanoId
   * @param alphabet Character sequence for generating NanoId
   * @return String containing NanoId
   * @since 0.1.0
   */
  public static String next(int length, String alphabet) {
    try {
      // Generating nanoid with custom settings
      var secureRandom = SecureRandom.getInstance(SECURE_RANDOM_ALGORITHM);
      var chars = alphabet.toCharArray();
      var nanoId = new StringBuilder();
      byte[] bytes = new byte[length];
      secureRandom.nextBytes(bytes);
      IntStream.range(0, length)
          .forEachOrdered(index -> nanoId.append(chars[bytes[index] & chars.length - 1]));
      return nanoId.toString();
    } catch (NoSuchAlgorithmException e) {
      // Handling errors
      throw new RuntimeException(e);
    }
  }
}
