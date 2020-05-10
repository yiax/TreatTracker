package com.yiaxiong.treattracker.entity;

import com.yiaxiong.treattracker.util.TimestampAttributeConverter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
    @JoinColumn(name="resolution_id")
    private Resolution resolution;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private String description;

    /**
     * The empty constructor
     */
    public Incident() {}

}
