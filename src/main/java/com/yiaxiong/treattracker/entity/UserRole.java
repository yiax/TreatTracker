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

    @OneToOne(mappedBy = "user_role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private String role;

    @CreationTimestamp
    @Convert(converter = TimestampAttributeConverter.class)
    private LocalDateTime createDate;

    @CreationTimestamp
    @Convert(converter = TimestampAttributeConverter.class)
    private LocalDateTime updateDate;

    @OneToOne(mappedBy = "user_role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private String userName;

    public UserRole () {}

    public UserRole(String role, String userName) {
        this.role = role;
        this.userName = userName;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public LocalDateTime getCreateDate() { return createDate; }

    public void setCreateDate(LocalDateTime createDate) { this.createDate = createDate; }

    public LocalDateTime getUpdateDate() { return updateDate; }

    public void setUpdateDate(LocalDateTime updateDate) { this.updateDate = updateDate; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }
}