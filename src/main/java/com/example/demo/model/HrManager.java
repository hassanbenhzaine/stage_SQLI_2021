package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public @Data class HrManager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean status;
    private String firstName;
    private String lastName;
}
