package view.tdm;

public class CourseTM implements Comparable<CourseTM> {
    private String CId;
    private String CName;
    private String Duration;
    private double Fee;

    public CourseTM() {
    }

    public CourseTM(String CId, String CName, String duration, double fee) {
        this.setCId(CId);
        this.setCName(CName);
        setDuration(duration);
        setFee(fee);
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

    @Override
    public String toString() {
        return "Course{" +
                "CId='" + CId + '\'' +
                ", CName='" + CName + '\'' +
                ", Duration='" + Duration + '\'' +
                ", Fee=" + Fee +
                '}';
    }

    @Override
    public int compareTo(CourseTM o) {
        return CId.compareTo(o.getCId());
    }
}
