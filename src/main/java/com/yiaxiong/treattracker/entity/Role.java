package com.yiaxiong.treattracker.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import lombok.*;

/**
 * Creates an instance of a Role
 * @author Yia Xiong
 */
@Entity(name="Role")
@Table(name="role")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @OneToOne
    @JoinColumn(name="user_name", referencedColumnName = "user_name")
    private User user;

    private String role;

    /**
     * The empty constructor
     */
    public Role(){}

    /**
     * The argument constructor
     */
    public Role(User user, String role){this.user = user; this.role = role;}
}
