package com.dubilowicz.elista.data.ob;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Pawel Dubilowicz on 2016-03-06.
 */
@Entity
@Table(name = "users")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_USER_ID") // wraz z ponizszym wpisem zapewniaja automatyczne nadawanie kolejnych ID tworzonym rekordom
public class UserOB implements Serializable { // interfejs wymagany dla obiektow ktore beda podlegac serializacji

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Long id;
    @Column(name = "techdate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date techDate;
    private String name;
    private String lastName;

    @OneToMany(targetEntity=UserGroupOb.class, mappedBy="user", fetch=FetchType.EAGER)
    private List<UserGroupOb> groups;

    @OneToMany(targetEntity = WorkTimeOb.class,mappedBy="user",fetch = FetchType.EAGER)
    private List<WorkTimeOb> workTimes;

    @OneToMany(targetEntity = PlansDiaryOb.class,mappedBy="user",fetch = FetchType.EAGER)
    private List<PlansDiaryOb> plansDiary;

    @OneToMany(targetEntity = AbsenceOb.class,mappedBy="user",fetch = FetchType.EAGER)
    private List<AbsenceOb> absences;

    public UserOB() {
    }

    public UserOB(String aName, String aLastName) {
        name = aName;
        lastName = aLastName;
    }

    public Long getId() {
        return id;
    }

    public List<UserGroupOb> Groups() {return groups;}

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

    @PrePersist
    @PreUpdate
    private void setCurrentDate() {
        // przy kazdym wpisie lub zmianie rekordu bedzie aktualizowana jego data, przydatne pole przy utrzymywaniu systemu
        techDate = new Date();
    }
}
