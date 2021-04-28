package com.czetsuyatech.springaspect.core.security.exception;

public class UserNotAuthorizedException extends SecurityException {

  public UserNotAuthorizedException(String username, String methodName) {
    super(String.format("User [%s] is not authorized to access [%s]", username, methodName));
  }
}
