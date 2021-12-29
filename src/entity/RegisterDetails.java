package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class RegisterDetails {

    @Id
    @GeneratedValue
    private int RegId;
    private LocalDate RegDate;

    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;

    public RegisterDetails() {
    }

    public RegisterDetails(int regId, LocalDate regDate, Student student, Course course) {
        setRegId(regId);
        setRegDate(regDate);
        this.setStudent(student);
        this.setCourse(course);
    }

    public int getRegId() {
        return RegId;
    }

    public void setRegId(int regId) {
        RegId = regId;
    }

    public LocalDate getRegDate() {
        return RegDate;
    }

    public void setRegDate(LocalDate regDate) {
        RegDate = regDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "RegisterDetails{" +
                "RegId=" + RegId +
                ", RegDate=" + RegDate +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
