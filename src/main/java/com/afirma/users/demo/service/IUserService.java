package com.afirma.users.demo.service;

import com.afirma.users.demo.dto.UserDTO;

import javax.validation.Valid;
import java.util.List;

public interface IUserService {

  public UserDTO save(@Valid UserDTO user);

  public UserDTO get(Long id);

  public List<UserDTO> getAll();

  public void delete(Long id);

}
