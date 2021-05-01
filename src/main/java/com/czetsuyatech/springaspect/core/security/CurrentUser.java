package com.czetsuyatech.springaspect.core.security;

import java.util.Set;
import lombok.Data;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Data
public class CurrentUser {

  private String username;
  private Set<String> permissions;
}
