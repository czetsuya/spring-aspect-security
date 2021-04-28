package com.czetsuyatech.springaspect.core.security.exception;

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
