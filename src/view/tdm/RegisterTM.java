package view.tdm;

import java.time.LocalDate;

public class RegisterTM implements Comparable<RegisterTM>{
    private String RegId;
    private String SId;
    private String CId;
    private LocalDate RegDate;

    public RegisterTM() {
    }

    public RegisterTM(String regId, String SId, String CId, LocalDate regDate) {
        setRegId(regId);
        this.setSId(SId);
        this.setCId(CId);
        setRegDate(regDate);
    }

    public String getRegId() {
        return RegId;
    }

    public void setRegId(String regId) {
        RegId = regId;
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
    public int compareTo(RegisterTM o) {
        return getRegId().compareTo(o.getRegId());
    }
}
