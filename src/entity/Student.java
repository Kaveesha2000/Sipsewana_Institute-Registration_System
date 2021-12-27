package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private String SId;
    private String SName;
    private String Address;
    private String DOB;
    private String NIC;
    private String TNo;

    @OneToMany(mappedBy = "student")
    private
    List<RegisterDetails> registerDetails=new ArrayList<>();

    public Student() {
    }

    public Student(String SId, String SName, String address, String DOB, String NIC, String TNo) {
        this.setSId(SId);
        this.setSName(SName);
        setAddress(address);
        this.setDOB(DOB);
        this.setNIC(NIC);
        this.setTNo(TNo);
    }

    public Student(String SId, String SName, String address, String DOB, String NIC, String TNo, List<RegisterDetails> registerDetails) {
        this.setSId(SId);
        this.setSName(SName);
        setAddress(address);
        this.setDOB(DOB);
        this.setNIC(NIC);
        this.setTNo(TNo);
        this.setRegisterDetails(registerDetails);
    }

    public String getSId() {
        return SId;
    }

    public void setSId(String SId) {
        this.SId = SId;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getTNo() {
        return TNo;
    }

    public void setTNo(String TNo) {
        this.TNo = TNo;
    }

    public List<RegisterDetails> getRegisterDetails() {
        return registerDetails;
    }

    public void setRegisterDetails(List<RegisterDetails> registerDetails) {
        this.registerDetails = registerDetails;
    }

    @Override
    public String toString() {
        return "Student{" +
                "SId='" + SId + '\'' +
                ", SName='" + SName + '\'' +
                ", Address='" + Address + '\'' +
                ", DOB='" + DOB + '\'' +
                ", NIC='" + NIC + '\'' +
                ", TNo='" + TNo + '\'' +
                ", registerDetails=" + registerDetails +
                '}';
    }
}
