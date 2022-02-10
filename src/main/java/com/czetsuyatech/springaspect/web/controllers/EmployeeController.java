package com.czetsuyatech.springaspect.web.controllers;

import com.czetsuyatech.springaspect.web.security.Security;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

  @Security(hasPermission = "list_employee")
  @GetMapping
  public String getEmployees(@RequestAttribute Long currentUserId) {
    return String.format("currentUserId=%d", currentUserId);
  }

  @Security(hasPermission = "read_employee")
  @GetMapping("/{id}")
  public String getEmployee(@PathVariable String id, @RequestAttribute Long currentUserId) {
    return String.format("currentUserId=%d", currentUserId);
  }
}