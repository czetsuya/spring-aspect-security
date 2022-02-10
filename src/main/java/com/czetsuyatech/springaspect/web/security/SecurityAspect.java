package com.czetsuyatech.springaspect.web.security;

import com.czetsuyatech.springaspect.web.security.exception.UserDoesNotExistsException;
import com.czetsuyatech.springaspect.web.security.exception.UserNotAuthorizedException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Aspect
@Component
public class SecurityAspect {

  @Before(
      value = "@annotation(security)",
      argNames = "joinPoint,security"
  )
  public void methodSecurity(
      JoinPoint joinPoint,
      Security security
  ) {
    authorize(joinPoint, security);
  }

  @Before(
      value = "@within(security)",
      argNames = "joinPoint,security"
  )
  public void classSecurity(
      JoinPoint joinPoint,
      Security security
  ) {
    authorize(joinPoint, security);
  }

  private void authorize(JoinPoint joinPoint, Security security) {

    CurrentUser currentUser = UserThreadLocalHolder.get();
    if (currentUser == null) {
      throw new UserDoesNotExistsException();

    } else if (currentUser.getPermissions() == null || !currentUser.getPermissions()
        .contains(security.hasPermission())) {
      throw new UserNotAuthorizedException(currentUser.getUsername(),
          joinPoint.getSignature().getName());
    }
  }
}
