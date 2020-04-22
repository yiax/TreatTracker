package com.yiaxiong.treattracker.entity;

import com.yiaxiong.treattracker.util.TimestampAttributeConverter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name="Incident")
@Table(name="incident")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Incident implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @CreationTimestamp
    @Convert(converter = TimestampAttributeConverter.class)
    @EqualsAndHashCode.Exclude
    private LocalDateTime incident_date;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Resolution resolution;

    @ManyToOne
    @JoinColumn(name="email", referencedColumnName = "email")
    private User user;

    private String description;

    public Incident() {}
/*
    public Incident(LocalDateTime incidentDate, String description) {
        this.incident_date = incidentDate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getIncident_date() {
        return incident_date;
    }

    public void setIncident_date(LocalDateTime incident_date) {
        this.incident_date = incident_date;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }*/

}
