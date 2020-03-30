package com.yiaxiong.treattracker.entity;

import com.yiaxiong.treattracker.util.TimestampAttributeConverter;
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
    @Convert(converter = TimestampAttributeConverter.class)
    private LocalDateTime incidentDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Resolution resolution;

    @ManyToOne
    @JoinColumn(name="id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    private String description;

    public Incident() {}

    public Incident(LocalDateTime incidentDate, String description) {
        this.incidentDate = incidentDate;
        this.description = description;
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
    }

}
