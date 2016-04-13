package com.dubilowicz.elista.data.ob;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by RaikPraca on 2016-03-22.
 */
@Entity
@Table(name = "work_time")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_WORK_ID")
public class WorkTimeOb implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserOB user;

    @Column(name = "day_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date day;

    @Column(name = "start_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date start;

    @Column(name = "end_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date end;
    private String jobInfo;

    public WorkTimeOb(){}

    public WorkTimeOb(Long aId,UserOB aUser,Date aDay,Date aStart,Date aEnd,String aJobInfo){
        this.id=aId;
        this.user=aUser;
        this.day=aDay;
        this.start=aStart;
        this.end=aEnd;
        this.jobInfo=aJobInfo;
    }


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
