package com.yiaxiong.treattracker.entity;

import com.yiaxiong.treattracker.util.TimestampAttributeConverter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name="UserRole")
@Table(name="user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Role role;

    @CreationTimestamp
    @Convert(converter = TimestampAttributeConverter.class)
    private LocalDateTime createDate;

    @CreationTimestamp
    @Convert(converter = TimestampAttributeConverter.class)
    private LocalDateTime updateDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userName")
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

    public LocalDateTime getCreateDate() { return createDate; }

    public void setCreateDate(LocalDateTime createDate) { this.createDate = createDate; }

    public LocalDateTime getUpdateDate() { return updateDate; }

    public void setUpdateDate(LocalDateTime updateDate) { this.updateDate = updateDate; }

    public User getUser() { return user; }

    public void setUserName(User user) { this.user = user; }
}