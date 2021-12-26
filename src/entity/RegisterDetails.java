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
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;
    private LocalDate RegDate;

    public RegisterDetails() {
    }

    public RegisterDetails(int regId, Student student, Course course, LocalDate regDate) {
        setRegId(regId);
        this.setStudent(student);
        this.setCourse(course);
        setRegDate(regDate);
    }

    public int getRegId() {
        return RegId;
    }

    public void setRegId(int regId) {
        RegId = regId;
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

    public LocalDate getRegDate() {
        return RegDate;
    }

    public void setRegDate(LocalDate regDate) {
        RegDate = regDate;
    }

    @Override
    public String toString() {
        return "RegisterDetails{" +
                "RegId=" + RegId +
                ", student=" + student +
                ", course=" + course +
                ", RegDate=" + RegDate +
                '}';
    }
}
