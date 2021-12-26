package dto;

public class StudentDTO {
    private String SId;
    private String SName;
    private String DOB;
    private String NIC;
    private int TNo;
    private String Course;

    public StudentDTO() {
    }

    public StudentDTO(String SId, String SName, String DOB, String NIC, int TNo, String course) {
        this.setSId(SId);
        this.setSName(SName);
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

    public int getTNo() {
        return TNo;
    }

    public void setTNo(int TNo) {
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
        return "Student{" +
                "SId='" + SId + '\'' +
                ", SName='" + SName + '\'' +
                ", DOB='" + DOB + '\'' +
                ", NIC='" + NIC + '\'' +
                ", TNo=" + TNo +
                ", Course='" + Course + '\'' +
                '}';
    }
}
