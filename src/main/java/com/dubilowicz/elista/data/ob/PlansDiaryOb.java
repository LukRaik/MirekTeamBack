package com.dubilowicz.elista.data.ob;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by RaikPraca on 2016-03-22.
 */
@Entity
@Table(name = "plans_diary")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_DIARY_ID")
public class PlansDiaryOb implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserOB user;

    private String day;

    @Column(name = "begin_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date begin;

    @Column(name = "end_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date end;

    public PlansDiaryOb(){}

    public PlansDiaryOb(Long aId,UserOB aUser,String aDay,Date aBegin,Date aEnd){
        this.id=aId;
        this.user=aUser;
        this.day=aDay;
        this.begin=aBegin;
        this.end=aEnd;
    }

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
