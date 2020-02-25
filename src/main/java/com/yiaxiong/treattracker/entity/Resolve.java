package com.yiaxiong.treattracker.entity;

import com.yiaxiong.treattracker.entity.Incident;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name="User")
@Table(name="user")
public class Resolve {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @OneToOne
    private Incident incident;

    @CreationTimestamp
    private LocalDateTime resolveDate;

    private String description;

    private boolean resolved;

    public Resolve() {}

    public Resolve(Incident incident, LocalDateTime resolveDate, String description, boolean resolved) {
        this.incident = incident;
        this.resolveDate = resolveDate;
        this.description = description;
        this.resolved = resolved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public LocalDateTime getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(LocalDateTime resolveDate) {
        this.resolveDate = resolveDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }
}
