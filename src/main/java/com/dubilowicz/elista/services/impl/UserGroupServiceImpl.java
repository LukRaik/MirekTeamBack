package com.dubilowicz.elista.services.impl;

import com.dubilowicz.elista.core.dto.UserGroupDto;
import com.dubilowicz.elista.data.ob.UserGroupOb;
import com.dubilowicz.elista.data.repository.IUserGroupRepository;
import com.dubilowicz.elista.services.ISimpleService;
import com.dubilowicz.elista.utils.converters.UserGroupConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RaikPraca on 2016-03-23.
 */
@Service
@Transactional
public class UserGroupServiceImpl implements ISimpleService<UserGroupDto,Long> {

    @Autowired
    private IUserGroupRepository _db;

    private UserGroupConverter _cnv = new UserGroupConverter();

    @Override
    public UserGroupDto saveEntity(UserGroupDto entityDto) {
        if(entityDto==null)return null;
        if(entityDto.GetId()==null){
            return _cnv.ConvertToDto(_db.save((_cnv.ConvertToOb(entityDto))));
        }
        UserGroupOb ob = _db.findOne(entityDto.GetId());
        ob.UpdateUser(entityDto.GetUser());
        ob.SetName(entityDto.GetGroupName());
        return _cnv.ConvertToDto(ob);
    }

    @Override
    public void deleteEntity(Long aId) {
        _db.delete(aId);
    }

    @Override
    public List<UserGroupDto> getAll() {
        return _db.findAll().stream().map(x->_cnv.ConvertToDto(x)).collect(Collectors.toList());
    }
}
