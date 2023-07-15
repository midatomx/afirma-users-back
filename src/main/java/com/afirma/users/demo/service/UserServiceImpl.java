package com.afirma.users.demo.service;

import com.afirma.users.demo.dto.UserDTO;
import com.afirma.users.demo.model.User;
import com.afirma.users.demo.repository.IUserJpaRepository;
import com.afirma.users.demo.service.exception.TechnicalException;
import com.afirma.users.demo.service.exception.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class UserServiceImpl implements IUserService {

  @Autowired
  private IUserJpaRepository repository;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public List<UserDTO> getAll() {
    List<User> listUserEntity = repository.findAll();
    List<UserDTO> listUserDto = listUserEntity.stream()
        .map(user -> modelMapper.map(user, UserDTO.class))
        .collect(Collectors.toList());
    return listUserDto;
  }

  @Override
  public UserDTO get(Long id) throws UserNotFoundException, TechnicalException {
    UserDTO userDTO;
    try {
//      User userEntity = repository.getOne(id); // deprecated
      User userEntity = repository.findById(id).get();
      userEntity.getNombre();
      userDTO = modelMapper.map(userEntity, UserDTO.class);
    } catch (UserNotFoundException e) {
      throw new UserNotFoundException(id, e);
    } catch (Exception e) {
      throw new TechnicalException(e);
    }
    return userDTO;
  }

  @Override
  public UserDTO save(UserDTO userDTO) {
    User userEntity = modelMapper.map(userDTO, User.class);

    if (userDTO.getId() != null) {
      userEntity.setId(userDTO.getId());
    }
    userEntity = repository.save(userEntity);
    return modelMapper.map(userEntity, UserDTO.class);
  }

  @Override
  public void delete(Long id) {
    try {
      repository.deleteById(id);
    } catch (EmptyResultDataAccessException e) {
      throw new UserNotFoundException(id, e);
    } catch (Exception e) {
      throw new TechnicalException(e);
    }
  }

}
