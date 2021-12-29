package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    private String CId;
    private String CName;
    private String Duration;
    private double Fee;


    @OneToMany(mappedBy = "course")
    private List<RegisterDetails> courseDetails=new ArrayList<>();

    public Course() {
    }

    public Course(String CId, String CName, String duration, double fee) {
        this.setCId(CId);
        this.setCName(CName);
        this.setDuration(duration);
        this.setFee(fee);
    }

    public Course(String CId, String CName, String duration, double fee, List<RegisterDetails> courseDetails) {
        this.CId = CId;
        this.CName = CName;
        Duration = duration;
        Fee = fee;
        this.courseDetails = courseDetails;
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public double getFee() {
        return Fee;
    }

    public void setFee(double fee) {
        Fee = fee;
    }

    public List<RegisterDetails> getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(List<RegisterDetails> courseDetails) {
        this.courseDetails = courseDetails;
    }

    @Override
    public String toString() {
        return "Course{" +
                "CId='" + CId + '\'' +
                ", CName='" + CName + '\'' +
                ", Duration='" + Duration + '\'' +
                ", Fee=" + Fee +
                '}';
    }
}
