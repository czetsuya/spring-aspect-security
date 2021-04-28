package com.czetsuyatech.springaspect.core.security.exception;

public class UserDoesNotExistsException extends SecurityException {

  public UserDoesNotExistsException() {
    super();
  }

  public UserDoesNotExistsException(String message) {
    super(message);
  }

  public UserDoesNotExistsException(String message, Throwable t) {
    super(message, t);
  }
}
