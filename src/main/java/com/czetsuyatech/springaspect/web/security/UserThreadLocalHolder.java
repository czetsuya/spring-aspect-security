package com.czetsuyatech.springaspect.web.security;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
public class UserThreadLocalHolder {

  private UserThreadLocalHolder() {

  }

  private static ThreadLocal<CurrentUser> threadLocal = new ThreadLocal<>();

  public static void set(CurrentUser currentUser) {
    threadLocal.set(currentUser);
  }

  public static CurrentUser get() {
    return threadLocal.get();
  }

  public static void remove() {
    threadLocal.remove();
  }
}
