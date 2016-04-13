package com.dubilowicz.elista.core.dto;

import com.dubilowicz.elista.data.ob.UserOB;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by RaikPraca on 2016-03-22.
 */
@ApiModel
public class UserGroupDto implements Serializable{

    public UserGroupDto(Long aId,String aGroupName,UserOB aUser){
        this.id=aId;
        this.groupName=aGroupName;
        this.user=aUser;
    }

    private Long id;
    private String groupName;
    private UserOB user;

    public Long GetId(){return id;}
    public String GetGroupName() {return groupName;}
    public UserOB GetUser(){return user;}

    public void SetName(String value) {groupName=value;}
    public void UpdateUser(UserOB value){user=value;}
}
