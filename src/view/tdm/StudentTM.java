package view.tdm;

public class StudentTM implements Comparable<StudentTM>{
    private String SId;
    private String SName;
    private String Address;
    private String DOB;
    private String NIC;
    private String TNo;

    public StudentTM() {
    }

    public StudentTM(String SId, String SName, String address, String DOB, String NIC, String TNo) {
        this.setSId(SId);
        this.setSName(SName);
        setAddress(address);
        this.setDOB(DOB);
        this.setNIC(NIC);
        this.setTNo(TNo);
    }

    @Override
    public int compareTo(StudentTM o) {
        return getSId().compareTo(o.getSId());
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

    @Override
    public String toString() {
        return "StudentTM{" +
                "SId='" + SId + '\'' +
                ", SName='" + SName + '\'' +
                ", Address='" + Address + '\'' +
                ", DOB='" + DOB + '\'' +
                ", NIC='" + NIC + '\'' +
                ", TNo='" + TNo + '\'' +
                '}';
    }
}
