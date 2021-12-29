package dto;

import java.io.Serializable;

public class RegisterDetailDTO implements Serializable {
    private String RegId;
    private String CId;

    public RegisterDetailDTO() {
    }

    public RegisterDetailDTO(String regId, String CId) {
        setRegId(regId);
        this.setCId(CId);
    }

    public String getRegId() {
        return RegId;
    }

    public void setRegId(String regId) {
        RegId = regId;
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    @Override
    public String toString() {
        return "RegisterDetailDTO{" +
                "RegId='" + RegId + '\'' +
                ", CId='" + CId + '\'' +
                '}';
    }
}
