package kr.happyjob.study.vo.login;

public class UserVO {
	private String mbr_no;
    private String loginId;
    private String userType;
    private String name;
    private String password;
    private String sex;
    private String hp;
    private String email;
    //	private String regdate
    private String addr;

    private String mbrYn; // 알림수신여부
    
    private String goal_yr; // 년도
    private String goal_m; // 월
    private String goal; // 알림수신여부에 따른 목표치 설정 동의:직접입력, 미동의: 0
    public String getGoal_yr() {
    	return goal_yr;
    }
    
    public void setGoal_yr(String goal_yr) {
    	this.goal_yr = goal_yr;
    }
    
    public String getGoal_m() {
    	return goal_m;
    }
    
    public void setGoal_m(String goal_m) {
    	this.goal_m = goal_m;
    }
    
    public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getMbrYn() {
    	return mbrYn;
    }
    
    public void setMbrYn(String mbrYn) {
    	this.mbrYn = mbrYn;
    }

    
    //	private String birthday
    public String getMbr_no() {
    	return mbr_no;
    }
    public void setMbr_no(String mbr_no) {
    	this.mbr_no = mbr_no;
    }
    
    public String getLoginId() {
        return loginId;
    }
	public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "loginId='" + loginId + '\'' +
                ", userType='" + userType + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", hp='" + hp + '\'' +
                ", email='" + email + '\'' +
                ", addr='" + addr + '\'' +
                ", mbrYn='" + mbrYn + '\'' +
                '}';
    }
}
