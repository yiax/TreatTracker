package com.yiaxiong.treattracker.entity;


import com.yiaxiong.treattracker.util.TimestampAttributeConverter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.*;

/**
 * Create an instance of a Resolution
 * @author Yia Xiong
 */
@Entity(name="Resolution")
@Table(name="resolution")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Resolution implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    private User user;

    /*
    @OneToOne(mappedBy = "resolution", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Incident incidents;
    */

    @CreationTimestamp
    @Convert(converter = TimestampAttributeConverter.class)
    @EqualsAndHashCode.Exclude
    private LocalDateTime resolution_date;

    private String description;

    /**
     * The empty constructor.
     */
    public Resolution() {}

}
