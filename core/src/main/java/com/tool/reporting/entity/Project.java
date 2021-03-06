package com.tool.reporting.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Slf4j
@Entity
@Data
@SQLDelete(sql = " UPDATE Project SET is_deleted = true WHERE id = ? ")
@Where(clause = " is_deleted = false ")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    @OneToOne
    private Employee submitter;

    private String name;

    @OneToOne
    private Strategy strategicAlignment;
    private String description;

    @OneToOne
    private Groups functionalGroup;

    @OneToOne
    private Employee approver;

    @OneToOne
    private Status state;

    @OneToOne
    private Health health;

    private String summary;
    private Double budgetCost;
    private Double actualCost;
    private Double forecastedCost;
    private LocalDateTime implementationDate;
    private LocalDateTime milestoneDate;

    @OneToOne
    private Status milestoneStatus;

    private boolean isDeleted;

    @CreationTimestamp
    private LocalDateTime creationDate;
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;

    @PreRemove
    public void preRemove() {
        log.info("Entity Project: preRemove(): method called");
        this.isDeleted = true;
    }
}
