package bt.edu.gcit.userservice.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "counselors")
public class Counselor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "counselor_id")
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phoneno", nullable = false)
    private Long phoneNo;

    @Column(name = "location", length = 50, nullable = false)
    private String location;

    @Column(name = "licence_id", nullable = false)
    private Integer licenceId;

    @Column(name = "specialization", length = 50, nullable = false)
    private String specialization;

    @Column(name = "qualification", length = 50, nullable = false)
    private String qualification;

    @Column(name = "year_of_experience", nullable = false)
    private Integer yearOfExperience;

    @Column(name = "languages", length = 50, nullable = false)
    private String languages;

    @Column(name = "photo", length = 255, nullable = false)
    private String photo;

    @Column(name = "description", length = 255, nullable = false)
    private String description;

    @Column(name = "q_details", length = 255, nullable = false)
    private String qDetails;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    // Constructors
    public Counselor() {}

    public Counselor(String name, String email, String password, Long phoneNo, String location,
                     Integer licenceId, String specialization, String qualification,
                     Integer yearOfExperience, String languages, String photo, String description,
                     String qDetails, boolean status, boolean isActive) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.location = location;
        this.licenceId = licenceId;
        this.specialization = specialization;
        this.qualification = qualification;
        this.yearOfExperience = yearOfExperience;
        this.languages = languages;
        this.photo = photo;
        this.description = description;
        this.qDetails = qDetails;
        this.status = status;
        this.isActive = isActive;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getLicenceId() {
        return licenceId;
    }

    public void setLicenceId(Integer licenceId) {
        this.licenceId = licenceId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Integer getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(Integer yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQDetails() {
        return qDetails;
    }

    public void setQDetails(String qDetails) {
        this.qDetails = qDetails;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
