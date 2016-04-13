package com.dubilowicz.elista.utils.converters;

import com.dubilowicz.elista.core.dto.UserDTO;
import com.dubilowicz.elista.data.ob.UserOB;

/**
 * Created by Pawel Dubilowicz on 2016-03-06.
 */
public class UserConverter {

    public static UserOB userDTOtoOB(UserDTO aUserDTO) {
        if (aUserDTO == null) {
            return null;
        }
        return new UserOB(aUserDTO.getName(), aUserDTO.getLastName());
    }

    public static UserDTO userOBtoDTO(UserOB aUserOB) {
        if (aUserOB == null) {
            return null;
        }
        return new UserDTO(aUserOB.getId(), aUserOB.getTechDate(), aUserOB.getName(), aUserOB.getLastName());
    }
}
