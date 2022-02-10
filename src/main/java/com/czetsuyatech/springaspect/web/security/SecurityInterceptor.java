package com.czetsuyatech.springaspect.web.security;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
public class SecurityInterceptor implements HandlerInterceptor {

  private static final Pattern AUTH_HEADER_PATTERN = Pattern.compile("Bearer (\\S+)");

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    // get the bearer token
    //    String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
    //
    //    if (StringUtils.hasLength(authorization)) {
    //      throw new AccessDeniedException("Authorization header is empty");
    //    }
    //    Matcher matcher = AUTH_HEADER_PATTERN.matcher(authorization);
    //    if (!matcher.matches()) {
    //      throw new AccessDeniedException(String.format("Invalid authorization header: [%s]", authorization));
    //    }
    //    String accessToken = matcher.group(1);

    // get the user from the bearer token
    // Long userId = getUserIdByAccessToken(accessToken);

    CurrentUser currentUser = new CurrentUser();
    currentUser.setUsername("czetsuyatech.com");
    currentUser.setPermissions(new HashSet<>(Arrays.asList("list_employee")));

    // catch null user here

    // use for security
    UserThreadLocalHolder.set(currentUser);

    // use to fetch the user info
    request.setAttribute("currentUserId", 1L);

    return true;
  }
}
