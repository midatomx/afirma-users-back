package com.afirma.users.demo.controller.rest;

import com.afirma.users.demo.dto.UserDTO;
import com.afirma.users.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

  @Autowired
  IUserService userService;

  @GetMapping("")
  public List<UserDTO> getAll() {
    return userService.getAll();
  }

  @GetMapping("/{id}")
  public UserDTO getUser(@PathVariable("id") Long id) {
    return userService.get(id);
  }

  @PostMapping("/new")
  public UserDTO newUser(@RequestBody UserDTO userDTO) {
    return userService.save(userDTO);
  }

  @PutMapping("/update")
  public UserDTO updateUser(@RequestBody UserDTO userDTO) {
    return userService.save(userDTO);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable("id") Long id) {
    userService.delete(id);
  }

}
