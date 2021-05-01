package com.czetsuyatech.springaspect.controller;

import com.czetsuyatech.springaspect.core.security.Security;
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
@Security(hasPermission = "employee")
public class EmployeeController {

  @GetMapping
  public void getEmployees(@RequestAttribute Long currentUserId) {
    System.out.println("currentUserId=" + currentUserId);
  }

  @Security(hasPermission = "read_employee")
  @GetMapping("/{id}")
  public void getEmployee(@PathVariable String id, @RequestAttribute Long currentUserId) {
    System.out.println("currentUserId=" + currentUserId + ", id=" + id);
  }
}
