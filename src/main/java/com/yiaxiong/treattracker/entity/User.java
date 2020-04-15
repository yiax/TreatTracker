package com.yiaxiong.treattracker.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name="User")
@Table(name="user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Incident> incidents = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>();

    private String first_name;
    private String last_name;
    private String email;
    private String user_name;
    private String password;

    /**
     * Instantiate a new User; the empty constructor
     */
    public User() {setIncidents();}

    /**
     * Instantiate a new User; the argument constructor
     * @param first_name the first name
     * @param last_name the last name
     * @param email the email
     * @param user_name the user name
     * @param password the password
     */
    public User(String first_name, String last_name, String email, String user_name, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.user_name = user_name;
        this.password = password;
        setIncidents();
    }

    /**
     * Get id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Get firstName
     * @return firstName
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Set firstName
     * @param first_name the first name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Get lastName
     * @return lastName
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * Set lastName
     * @param last_name the last name
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Get email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get userName
     * @return userName
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * Set userName
     * @param user_name the user name
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * Get password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get incidents
     * @return incidents
     */
    public Set<Incident> getIncidents() {
        return incidents;
    }

    /**
     * Set incidents
     */
    private void setIncidents() {
        //TODO
        //retrieve incidents for a user in the db
        //add each incident to the set
    }

    /**
     * Get role
     * @return roles
     */
    public Set<UserRole> getRoles() {
        return roles;
    }

    /**
     * Set roles
     */
    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    /**
     * Display the user in a String
     * @return String
     */
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + first_name + '\'' +
                ", lastName='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + user_name + '\'' +
                '}';
    }

    /**
     * Check if two users are the same
     * @param o the user object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(first_name, user.first_name) &&
                Objects.equals(last_name, user.last_name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(user_name, user.user_name) &&
                Objects.equals(password, user.password);
    }

    /**
     * Override hashCode
     * @return hash object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, email, user_name, password);
    }
}
