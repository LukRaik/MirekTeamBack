package com.dubilowicz.elista.services.impl;

import com.dubilowicz.elista.core.dto.UserDTO;
import com.dubilowicz.elista.data.ob.UserOB;
import com.dubilowicz.elista.data.repository.IUserRepository;
import com.dubilowicz.elista.services.IUserService;
import com.dubilowicz.elista.utils.converters.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel Dubilowicz on 2016-03-06.
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public UserDTO findUserById(Long aId) {
        UserOB pUserOB = iUserRepository.findOne(aId);
        if (pUserOB == null) {
            return null;
        }
        return UserConverter.userOBtoDTO(pUserOB);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<UserDTO> pResult = new ArrayList<>();
        List<UserOB> pUserList = iUserRepository.findAll();
        for (UserOB user : pUserList) {
            pResult.add(UserConverter.userOBtoDTO(user));
        }
        return pResult;
    }

    @Override
    public List<UserDTO> findUsersByName(String aName) {
        List<UserDTO> pResult = new ArrayList<>();
        List<UserOB> pUserList = iUserRepository.findByNameStartsWith(aName);
        for (UserOB user : pUserList) {
            pResult.add(UserConverter.userOBtoDTO(user));
        }
        return pResult;
    }

    @Override
    public List<UserDTO> findUsersByLastName(String aLastName) {
        List<UserDTO> pResult = new ArrayList<>();
        List<UserOB> pUserList = iUserRepository.findByLastNameStartsWith(aLastName);
        for (UserOB user : pUserList) {
            pResult.add(UserConverter.userOBtoDTO(user));
        }
        return pResult;
    }

    @Override
    public List<UserDTO> findUsersByNames(String aName, String aLastName) {
        List<UserDTO> pResult = new ArrayList<>();
        List<UserOB> pUserList = iUserRepository.findByFullName(aName, aLastName);
        for (UserOB user : pUserList) {
            pResult.add(UserConverter.userOBtoDTO(user));
        }
        return pResult;
    }

    @Override
    public UserDTO saveUser(UserDTO aUserDTO) {
        if (aUserDTO == null) {
            return null;
        }
        // sprawdzenie czy rekord juz istnieje
        UserOB pUserOB = aUserDTO.getId() == null ? null : iUserRepository.findOne(aUserDTO.getId());
        // zapis nowego
        if (pUserOB == null) {
            return UserConverter.userOBtoDTO(iUserRepository.save(UserConverter.userDTOtoOB(aUserDTO)));
        }
        // edycja istniejacego
        pUserOB.setName(aUserDTO.getName());
        pUserOB.setLastName(aUserDTO.getLastName());
        return UserConverter.userOBtoDTO(iUserRepository.save(pUserOB));
    }

    @Override
    public void deleteUser(Long aId) {
        iUserRepository.delete(aId);
    }
}
