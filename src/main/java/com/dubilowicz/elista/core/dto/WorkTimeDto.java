package com.dubilowicz.elista.core.dto;

import com.dubilowicz.elista.data.ob.UserOB;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by RaikPraca on 2016-03-22.
 */
@ApiModel
public class WorkTimeDto implements Serializable {

    public WorkTimeDto(Long aId,UserOB aUser,Date aDay,Date aStart,Date aEnd,String aJobInfo){
        this.id=aId;
        this.user=aUser;
        this.day=aDay;
        this.start=aStart;
        this.end=aEnd;
        this.jobInfo=aJobInfo;
    }

    private Long id;
    private UserOB user;
    private Date day;
    private Date start;
    private Date end;
    private String jobInfo;

    public Long Id(){return id;}
    public UserOB User(){return user;}
    public Date Day(){return day;}
    public Date Start(){return start;}
    public Date End(){return end;}
    public String JobInfo(){return jobInfo;}

    public void UpdateUser(UserOB value){user=value;}
    public void UpdateDay(Date value){day=value;}
    public void UpdateStart(Date value){start=value;}
    public void UpdateEnd(Date value){end=value;}
    public void UpdateJobInfo(String value){jobInfo=value;}
}
