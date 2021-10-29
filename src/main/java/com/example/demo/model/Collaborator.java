package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Entity
public @Data class Collaborator{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long number;
    private String firstName;
    private String lastName;
    @Transient
    private String abbrCollaborator;
    private Character sex;
    private String site;
    private String bu;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate hiringDate;
    @Transient
    private Month bapMonth;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate leavingDate;
    @Transient
    private Boolean oldCollaborator;
    @Transient
    private Boolean integrationSeminar;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate integrationSeminarDate;
    private String appPosition;
    private String currentPosition;
    private Double salary;

    @ManyToOne(cascade = CascadeType.MERGE)
    private HrManager hrManager;
    @Transient
    private Long hrManagerId;
//    @Transient
//    private Iterable skillsIds;

    @ManyToOne(cascade = CascadeType.MERGE)
    private HrManager oldHrManager;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Skill> skills;

//    public Iterable getSkillsIds() {
//        return skillsIds;
//    }

    public Long getHrManagerId() {
        return hrManagerId;
    }

    public boolean getIntegrationSeminar() {
        if(this.integrationSeminarDate == null){
            return false;
        } else{
            return true;
        }
    }

    public boolean getOldCollaborator() {
        if(this.leavingDate == null){
            return false;
        } else{
            return true;
        }
    }

    public Month getBapMonth() {
        return hiringDate.getMonth();
    }

    public void setSite(String site) {
        if(site.isBlank()){
            this.site = "RABAT";
        }else{
            this.site = site.toUpperCase();
        }
    }

    public String getAbbrCollaborator() {
        return firstName.substring(0,1).toUpperCase() + lastName.substring(0,2).toLowerCase();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.toUpperCase();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.toUpperCase();
    }

}
