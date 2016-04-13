package com.dubilowicz.elista.data.ob;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by RaikPraca on 2016-03-22.
 */
@Entity
@Table(name = "user_groups")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_GROUP_ID") // wraz z ponizszym wpisem zapewniaja automatyczne nadawanie kolejnych ID tworzonym rekordom
public class UserGroupOb implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Long id;

    private String groupName;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserOB user;

    public UserGroupOb(){}

    public UserGroupOb(Long aId,String aGroupName,UserOB aUser){
        this.id=aId;
        this.groupName=aGroupName;
        this.user=aUser;
    }

    public Long GetId(){return id;}

    public String GetGroupName() {return groupName;}

    public void SetName(String value) {groupName=value;}

    public UserOB GetUser(){return user;}

    public void UpdateUser(UserOB value){user=value;}
}
