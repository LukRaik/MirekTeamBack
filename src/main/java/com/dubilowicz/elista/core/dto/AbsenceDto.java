package com.dubilowicz.elista.core.dto;

import com.dubilowicz.elista.data.ob.UserOB;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by RaikPraca on 2016-03-22.
 */
@ApiModel
public class AbsenceDto implements Serializable{
    public AbsenceDto(Long aId,UserOB aUser,String aType,Date aDate,Integer aHours){
        this.id=aId;
        this.user=aUser;
        this.type=aType;
        this.date=aDate;
        this.hours=aHours;
    }
    private Long id;
    private UserOB user;
    private String type;
    private Date date;
    private Integer hours;

    public Long GetId(){return id;}
    public UserOB GetUser(){return user;}
    public String GetType(){return type;}
    public Date GetDate(){return date;}
    public Integer GetHours(){return hours;}

    public void SetUser(UserOB value){user=value;}
    public void SetType(String value){type=value;}
    public void SetDate(Date value){date=value;}
    public void SetHours(Integer value){hours=value;}
}
