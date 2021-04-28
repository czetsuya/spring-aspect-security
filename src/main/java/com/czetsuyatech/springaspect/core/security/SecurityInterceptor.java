package com.czetsuyatech.springaspect.core.security;

import java.util.Arrays;
import java.util.HashSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class SecurityInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request,
      HttpServletResponse response, Object handler) throws Exception {

    CurrentUser currentUser = new CurrentUser();
    currentUser.setUsername("czetsuya");
    currentUser.setPermissions(new HashSet<>(Arrays.asList("employee", "book")));

    // catch null user here

    // use for security
    UserThreadLocalHolder.set(currentUser);

    // use to fetch the user info
    request.setAttribute("currentUserId", 1L);

    return true;
  }
}