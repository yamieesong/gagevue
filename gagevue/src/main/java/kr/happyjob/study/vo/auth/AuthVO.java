package kr.happyjob.study.vo.auth;

public class AuthVO {
	/** 이름 */
	private String name;
	/** 휴대폰번호 */
	private String mbr_hp;
	/** 메일주소 */
	private String mbr_mail;
	/** 아이디 */
	private String loginID;
	/** 패스워드 */
	private String password;
	/** 알림수신여부 */
	private String mbr_yn;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMbr_hp() {
		return mbr_hp;
	}

	public void setMbr_hp(String mbr_hp) {
		this.mbr_hp = mbr_hp;
	}

	public String getMbr_mail() {
		return mbr_mail;
	}

	public void setMbr_mail(String mbr_mail) {
		this.mbr_mail = mbr_mail;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMbr_yn() {
		return mbr_yn;
	}

	public void setMbr_yn(String mbr_yn) {
		this.mbr_yn = mbr_yn;
	}

	/** toString() */
	@Override
	public String toString() {
		return "AuthVO [name=" + name
					+ ", mbr_hp=" + mbr_hp
					+ ", mbr_mail=" + mbr_mail
					+ ", loginID=" + loginID
					+ ", mbr_yn=" + mbr_yn;
	}
}
