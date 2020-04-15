package com.yiaxiong.treattracker.entity;

import com.yiaxiong.treattracker.util.TimestampAttributeConverter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name="UserRole")
@Table(name="user_role")
public class UserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    @JoinColumn(name="role")
    private Role role;

    @ManyToOne
    @JoinColumn(name="user_name")
    private User user;

    public UserRole () {}

    public UserRole(Role role, User user) {
        this.role = role;
        this.user = user;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }

    public User getUser() { return user; }

    public void setUserName(User user) { this.user = user; }
}