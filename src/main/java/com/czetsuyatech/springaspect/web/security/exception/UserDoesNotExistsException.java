package com.czetsuyatech.springaspect.web.security.exception;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
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
