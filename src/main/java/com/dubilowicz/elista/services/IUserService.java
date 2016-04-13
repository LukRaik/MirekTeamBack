package com.dubilowicz.elista.services;

import com.dubilowicz.elista.core.dto.UserDTO;

import java.util.List;

/**
 * Created by Pawel Dubilowicz on 2016-03-06.
 */
public interface IUserService {

    UserDTO findUserById(Long aId);
    List<UserDTO> findAllUsers();
    List<UserDTO> findUsersByName(String aName);
    List<UserDTO> findUsersByLastName(String aLastName);
    List<UserDTO> findUsersByNames(String aName, String aLastName);
    UserDTO saveUser(UserDTO aUserDTO);
    void deleteUser(Long aId);
}
