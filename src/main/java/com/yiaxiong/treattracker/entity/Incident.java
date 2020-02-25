package com.yiaxiong.treattracker.entity;

import com.yiaxiong.treattracker.entity.User;
import com.yiaxiong.treattracker.entity.Resolve;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name="Incident")
@Table(name="incident")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @CreationTimestamp
    private LocalDateTime incidentDate;

    @OneToOne
    private User user;

    private String description;

    @OneToOne
    private Resolve resolve;

    public Incident() {}

    public Incident(LocalDateTime incidentDate, User user, String description, Resolve resolve) {
        this.incidentDate = incidentDate;
        this.user = user;
        this.description = description;
        this.resolve = resolve;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDateTime incidentDate) {
        this.incidentDate = incidentDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Resolve getResolve() {
        return resolve;
    }

    public void setResolve(Resolve resolve) {
        this.resolve = resolve;
    }
}
