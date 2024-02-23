package kr.happyjob.study.vo.mypage;

public class MypageModel {
	// 게시판 글 번호
	private String mn_no;
	private String mbr_no;
	private String mn_dtm;
	private String mn_use_dvs;
	private String mn_pay_dvs;
	private int mn_amount;
	private int sum_amount;
	private String mn_use_dvs_det;
	private String mn_use_memo;
	private String mn_rgst_dtm;
	private String mn_rgst_id;
	private String mn_upd_dtm;
	private String mn_upd_id;
	private String detail_name;

	public String getDetail_name() {
		return detail_name;
	}
	public void setDetail_name(String detail_name) {
		this.detail_name = detail_name;
	}
	public int getSum_amount() {
		return sum_amount;
	}
	public void setSum_amount(int sum_amount) {
		this.sum_amount = sum_amount;
	}
	public int getMn_amount() {
		return mn_amount;
	}
	public void setMn_amount(int mn_amount) {
		this.mn_amount = mn_amount;
	}
	public String getMn_no() {
		return mn_no;
	}
	public void setMn_no(String mn_no) {
		this.mn_no = mn_no;
	}
	public String getMbr_no() {
		return mbr_no;
	}
	public void setMbr_no(String mbr_no) {
		this.mbr_no = mbr_no;
	}
	public String getMn_dtm() {
		return mn_dtm;
	}
	public void setMn_dtm(String mn_dtm) {
		this.mn_dtm = mn_dtm;
	}
	public String getMn_use_dvs() {
		return mn_use_dvs;
	}
	public void setMn_use_dvs(String mn_use_dvs) {
		this.mn_use_dvs = mn_use_dvs;
	}
	public String getMn_pay_dvs() {
		return mn_pay_dvs;
	}
	public void setMn_pay_dvs(String mn_pay_dvs) {
		this.mn_pay_dvs = mn_pay_dvs;
	}
	public String getMn_use_dvs_det() {
		return mn_use_dvs_det;
	}
	public void setMn_use_dvs_det(String mn_use_dvs_det) {
		this.mn_use_dvs_det = mn_use_dvs_det;
	}
	public String getMn_use_memo() {
		return mn_use_memo;
	}
	public void setMn_use_memo(String mn_use_memo) {
		this.mn_use_memo = mn_use_memo;
	}
	public String getMn_rgst_dtm() {
		return mn_rgst_dtm;
	}
	public void setMn_rgst_dtm(String mn_rgst_dtm) {
		this.mn_rgst_dtm = mn_rgst_dtm;
	}
	public String getMn_rgst_id() {
		return mn_rgst_id;
	}
	public void setMn_rgst_id(String mn_rgst_id) {
		this.mn_rgst_id = mn_rgst_id;
	}
	public String getMn_upd_dtm() {
		return mn_upd_dtm;
	}
	public void setMn_upd_dtm(String mn_upd_dtm) {
		this.mn_upd_dtm = mn_upd_dtm;
	}
	public String getMn_upd_id() {
		return mn_upd_id;
	}
	public void setMn_upd_id(String mn_upd_id) {
		this.mn_upd_id = mn_upd_id;
	}
}
