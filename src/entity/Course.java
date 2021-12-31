package entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Course {
    @Id
    private String CId;
    private String CName;
    private String Duration;
    private double Fee;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER , cascade = CascadeType.REMOVE)
    private List<Register> courseDetails=new ArrayList<>();

    public Course() {
    }

    public Course(String CId, String CName, String duration, double fee) {
        this.setCId(CId);
        this.setCName(CName);
        this.setDuration(duration);
        this.setFee(fee);
    }

    public Course(String CId, String CName, String duration, double fee, List<Register> courseDetails) {
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

    public List<Register> getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(List<Register> courseDetails) {
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
