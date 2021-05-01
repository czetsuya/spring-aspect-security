package com.czetsuyatech.springaspect.core.security.exception;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
public class SecurityException extends RuntimeException {

  public SecurityException() {
    super();
  }

  public SecurityException(String message) {
    super(message);
  }

  public SecurityException(String message, Throwable t) {
    super(message, t);
  }
}
