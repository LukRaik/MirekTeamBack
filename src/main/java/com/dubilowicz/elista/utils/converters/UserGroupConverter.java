package com.dubilowicz.elista.utils.converters;

import com.dubilowicz.elista.core.dto.UserGroupDto;
import com.dubilowicz.elista.data.ob.UserGroupOb;

/**
 * Created by RaikPraca on 2016-03-23.
 */
public class UserGroupConverter implements IConverter<UserGroupOb,UserGroupDto> {
    @Override
    public UserGroupOb ConvertToOb(UserGroupDto obj) {
        return new UserGroupOb(obj.GetId(),obj.GetGroupName(),obj.GetUser());
    }

    @Override
    public UserGroupDto ConvertToDto(UserGroupOb obj) {
        return new UserGroupDto(obj.GetId(),obj.GetGroupName(),obj.GetUser());
    }
}
