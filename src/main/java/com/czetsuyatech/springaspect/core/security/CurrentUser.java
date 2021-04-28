package com.czetsuyatech.springaspect.core.security;

import java.util.Set;
import lombok.Data;

@Data
public class CurrentUser {

  private String username;
  private Set<String> permissions;
}
