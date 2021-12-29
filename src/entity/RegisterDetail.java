package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RegisterDetail {
    @Id
    @GeneratedValue
    private int RegDetailId;
    @ManyToOne
    private Register register;
    @ManyToOne
    private Course course;

    public RegisterDetail() {
    }

    public RegisterDetail(int regDetailId, Register register, Course course) {
        setRegDetailId(regDetailId);
        this.setRegister(register);
        this.setCourse(course);
    }

    public int getRegDetailId() {
        return RegDetailId;
    }

    public void setRegDetailId(int regDetailId) {
        RegDetailId = regDetailId;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "RegisterDetail{" +
                "RegDetailId=" + RegDetailId +
                ", register=" + register +
                ", course=" + course +
                '}';
    }
}
