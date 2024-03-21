package kr.happyjob.study.vo.menu;

public class MenuVo {
    private String MNU_ID;
    private String HIR_MNU_ID;
    private String MNU_NM;
    private String MNU_URL;
    private String MNU_DVS_COD;
    private String GRP_NUM;
    private String ODR;
    private String LVL;
    private String MNU_ICO_COD;
    private String USE_POA;
    private String DLT_POA;

    private String user_type;

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getMNU_ID() {
        return MNU_ID;
    }

    public void setMNU_ID(String MNU_ID) {
        this.MNU_ID = MNU_ID;
    }

    public String getHIR_MNU_ID() {
        return HIR_MNU_ID;
    }

    public void setHIR_MNU_ID(String HIR_MNU_ID) {
        this.HIR_MNU_ID = HIR_MNU_ID;
    }

    public String getMNU_NM() {
        return MNU_NM;
    }

    public void setMNU_NM(String MNU_NM) {
        this.MNU_NM = MNU_NM;
    }

    public String getMNU_URL() {
        return MNU_URL;
    }

    public void setMNU_URL(String MNU_URL) {
        this.MNU_URL = MNU_URL;
    }

    public String getMNU_DVS_COD() {
        return MNU_DVS_COD;
    }

    public void setMNU_DVS_COD(String MNU_DVS_COD) {
        this.MNU_DVS_COD = MNU_DVS_COD;
    }

    public String getGRP_NUM() {
        return GRP_NUM;
    }

    public void setGRP_NUM(String GRP_NUM) {
        this.GRP_NUM = GRP_NUM;
    }

    public String getODR() {
        return ODR;
    }

    public void setODR(String ODR) {
        this.ODR = ODR;
    }

    public String getLVL() {
        return LVL;
    }

    public void setLVL(String LVL) {
        this.LVL = LVL;
    }

    public String getMNU_ICO_COD() {
        return MNU_ICO_COD;
    }

    public void setMNU_ICO_COD(String MNU_ICO_COD) {
        this.MNU_ICO_COD = MNU_ICO_COD;
    }

    public String getUSE_POA() {
        return USE_POA;
    }

    public void setUSE_POA(String USE_POA) {
        this.USE_POA = USE_POA;
    }

    public String getDLT_POA() {
        return DLT_POA;
    }

    public void setDLT_POA(String DLT_POA) {
        this.DLT_POA = DLT_POA;
    }

    @Override
    public String toString() {
        return "MenuVo{" +
                "MNU_ID='" + MNU_ID + '\'' +
                ", HIR_MNU_ID='" + HIR_MNU_ID + '\'' +
                ", MNU_NM='" + MNU_NM + '\'' +
                ", MNU_URL='" + MNU_URL + '\'' +
                ", MNU_DVS_COD='" + MNU_DVS_COD + '\'' +
                ", GRP_NUM='" + GRP_NUM + '\'' +
                ", ODR='" + ODR + '\'' +
                ", LVL='" + LVL + '\'' +
                ", MNU_ICO_COD='" + MNU_ICO_COD + '\'' +
                ", USE_POA='" + USE_POA + '\'' +
                ", DLT_POA='" + DLT_POA + '\'' +
                '}';
    }
}
