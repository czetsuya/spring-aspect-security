package com.czetsuyatech.springaspect.core.security.exception;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
public class UserNotAuthorizedException extends SecurityException {

  public UserNotAuthorizedException(String username, String methodName) {
    super(String.format("User [%s] is not authorized to access [%s]", username, methodName));
  }
}
