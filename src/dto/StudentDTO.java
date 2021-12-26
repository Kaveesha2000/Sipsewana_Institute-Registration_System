package dto;

public class StudentDTO {
    private String SId;
    private String SName;
    private String Address;
    private String DOB;
    private String NIC;
    private String TNo;
    private String Course;

    public StudentDTO() {
    }

    public StudentDTO(String SId, String SName, String address, String DOB, String NIC, String TNo, String course) {
        this.setSId(SId);
        this.setSName(SName);
        setAddress(address);
        this.setDOB(DOB);
        this.setNIC(NIC);
        this.setTNo(TNo);
        setCourse(course);
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

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "SId='" + SId + '\'' +
                ", SName='" + SName + '\'' +
                ", Address='" + Address + '\'' +
                ", DOB='" + DOB + '\'' +
                ", NIC='" + NIC + '\'' +
                ", TNo='" + TNo + '\'' +
                ", Course='" + Course + '\'' +
                '}';
    }
}
