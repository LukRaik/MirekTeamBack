package com.dubilowicz.elista.core.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Pawel Dubilowicz on 2016-03-06.
 */
@ApiModel
public class UserDTO implements Serializable {

    private Long id;
    private Date techDate;
    private String name;
    private String lastName;

    public UserDTO() {
    }

    public UserDTO(Long aId, Date aTechDate, String aName, String aLastName) {
        id = aId;
        techDate = aTechDate;
        name = aName;
        lastName = aLastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public Date getTechDate() {
        return techDate;
    }

    public void setTechDate(Date aTechDate) {
        techDate = aTechDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String aLastName) {
        lastName = aLastName;
    }
}
