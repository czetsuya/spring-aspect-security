package com.czetsuyatech.springaspect.core.security;

import com.czetsuyatech.springaspect.core.security.CurrentUser;

public class UserThreadLocalHolder {

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
