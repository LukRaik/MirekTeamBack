package com.dubilowicz.elista.core.dto;

import com.dubilowicz.elista.data.ob.UserOB;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by RaikPraca on 2016-03-22.
 */
@ApiModel
public class PlansDiaryDto implements Serializable {

    public PlansDiaryDto(Long aId,UserOB aUser,String aDay,Date aBegin,Date aEnd){
        this.id=aId;
        this.user=aUser;
        this.day=aDay;
        this.begin=aBegin;
        this.end=aEnd;
    }

    private Long id;
    private UserOB user;
    private String day;
    private Date begin;
    private Date end;

    public Long GetId(){return id;}
    public UserOB GetUser(){return user;}
    public String GetDay(){return day;}
    public Date GetBeginDate(){return begin;}
    public Date GetEndDate(){return end;}

    public void SetUser(UserOB value){user=value;}
    public void SetDay(String value){day=value;}
    public void SetBeginDate(Date value){begin=value;}
    public void SetEndDate(Date value){end=value;}
}
