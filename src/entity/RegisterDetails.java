package entity;

import java.time.LocalDate;

public class RegisterDetails {
    private String SId;
    private String CId;
    private LocalDate RegDate;

    public RegisterDetails() {
    }

    public RegisterDetails(String SId, String CId, LocalDate regDate) {
        this.setSId(SId);
        this.setCId(CId);
        setRegDate(regDate);
    }

    public String getSId() {
        return SId;
    }

    public void setSId(String SId) {
        this.SId = SId;
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
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
                "SId='" + SId + '\'' +
                ", CId='" + CId + '\'' +
                ", RegDate=" + RegDate +
                '}';
    }
}
