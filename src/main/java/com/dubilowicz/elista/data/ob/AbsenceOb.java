package com.dubilowicz.elista.data.ob;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by RaikPraca on 2016-03-22.
 */
@Entity
@Table(name = "absences")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_ABSENCE_ID")
public class AbsenceOb implements Serializable{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserOB user;

    private String type;

    @Column(name = "date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    private Integer hours;

    public AbsenceOb(){}
    public AbsenceOb(Long aId,UserOB aUser,String aType,Date aDate,Integer aHours){
        this.id=aId;
        this.user=aUser;
        this.type=aType;
        this.date=aDate;
        this.hours=aHours;
    }

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
