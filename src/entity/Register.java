package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Register {

    @Id
    private String RegId;
    private LocalDate RegDate;

    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;

    public Register() {
    }

    public Register(String regId, LocalDate regDate, Student student, Course course) {
        setRegId(regId);
        setRegDate(regDate);
        this.setStudent(student);
        this.setCourse(course);
    }

    public String getRegId() {
        return RegId;
    }

    public void setRegId(String regId) {
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
}
