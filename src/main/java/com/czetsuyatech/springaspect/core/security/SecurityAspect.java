package com.czetsuyatech.springaspect.core.security;

import com.czetsuyatech.springaspect.core.security.exception.UserDoesNotExistsException;
import com.czetsuyatech.springaspect.core.security.exception.UserNotAuthorizedException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

  @Before(
      value = "@annotation(security)",
      argNames = "joinPoint,security"
  )
  public void methodAuth(
      JoinPoint joinPoint,
      Security security
  ) {
    auth(joinPoint, security);
  }

  @Before(
      value = "@within(security)",
      argNames = "joinPoint,security"
  )
  public void classAuth(
      JoinPoint joinPoint,
      Security security
  ) {
    auth(joinPoint, security);
  }

  private void auth(JoinPoint joinPoint, Security security) {

    CurrentUser currentUser = UserThreadLocalHolder.get();
    if (currentUser == null) {
      throw new UserDoesNotExistsException();

    } else if (currentUser.getPermissions() == null || !currentUser.getPermissions().contains(security.hasPermission())) {
      throw new UserNotAuthorizedException(currentUser.getUsername(),
          joinPoint.getSignature().getName());
    }
  }
}
