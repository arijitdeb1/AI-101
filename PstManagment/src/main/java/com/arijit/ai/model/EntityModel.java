package com.arijit.ai.model;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "entity")
public class EntityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "name")
    private String name;

    @Column(name = "attributes")
    private String attributes;

    @Column(name = "created_dt")
    private Timestamp createdDt;
}