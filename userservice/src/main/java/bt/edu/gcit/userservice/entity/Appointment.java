package bt.edu.gcit.userservice.entity;

import jakarta.persistence.*;
import java.sql.Time;
import java.sql.Date;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id", nullable = false)
    private Integer appointmentId;

    @Column(name = "student_id", nullable = false)
    private Integer studentId;

    @Column(name = "counselor_id", nullable = false)
    private Integer counselorId;

    @Column(name = "app_type", nullable = false, length = 50)
    private String appType;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "timeslot", nullable = false)
    private Time timeSlot;

    @Column(name = "location", nullable = false, length = 50)
    private String location;

    @Column(name = "reason", nullable = false, length = 50)
    private String reason;

    public Appointment() {
    }

    public Appointment(Integer studentId, Integer counselorId, String appType, Date date, Time timeSlot, String location, String reason) {
        this.studentId = studentId;
        this.counselorId = counselorId;
        this.appType = appType;
        this.date = date;
        this.timeSlot = timeSlot;
        this.location = location;
        this.reason = reason;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCounselorId() {
        return counselorId;
    }

    public void setCounselorId(Integer counselorId) {
        this.counselorId = counselorId;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(Time timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
