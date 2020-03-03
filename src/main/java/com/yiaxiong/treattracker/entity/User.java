package com.yiaxiong.treattracker.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name="User")
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Incident> incidents = new HashSet<>();

    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;

    /**
     * Instantiate a new User; the empty constructor
     */
    public User() {}

    /**
     * Instantiate a new User; the argument constructor
     * @param firstName the first name
     * @param lastName the last name
     * @param email the email
     * @param userName the user name
     * @param password the password
     */
    public User(String firstName, String lastName, String email, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
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
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set firstName
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get lastName
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set lastName
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public String getUserName() {
        return userName;
    }

    /**
     * Set userName
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
     * @param incidents the incidents
     */
    public void setIncidents(Set<Incident> incidents) {
        this.incidents = incidents;
    }

    /**
     * Display the user in a String
     * @return String
     */
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
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
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(incidents, user.incidents);
    }

    /**
     * Override hashCode
     * @return hash object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, userName, password, incidents);
    }
}
