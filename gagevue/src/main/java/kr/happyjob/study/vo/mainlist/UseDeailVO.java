package kr.happyjob.study.vo.mainlist;

public class UseDeailVO {
	
	private String mn_no;			/* 사용내역관리번호 */
	private String mbr_no;			/* 회원관리번호 */
	private String mn_dtm;			/* 날짜 */
	private String mn_use_dvs;		/* 사용구분코드 */
	private String mn_pay_dvs;		/* 결제구분 */
	private String mn_use_dvs_det;  /* 사용상세구분코드 */
	private String mn_amount;		/* 금액 */
	private String mn_use_memo;		/* 메모 */
	private String mn_rgst_dtm;		/* 등록날짜 */
	private String mn_rgst_id;		/* 등록ID */
	private String mn_upd_dtm;		/* 수정날짜 */
	private String mn_upd_id;		/* 수정ID */
	
	private String mn_use_dvs_name;		/* 사용구분명 */
	private String mn_use_dvs_det_name; /* 사용상세구분명 */
	
	private String sum_for_use_dvs_import_sum; 	/* 수입 TOTAL */
	private String sum_for_use_dvs_expense_sum;	/* 지출 TOTAL */
	
	
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





	public String getMn_amount() {
		return mn_amount;
	}





	public void setMn_amount(String mn_amount) {
		this.mn_amount = mn_amount;
	}





	public String getMn_use_dvs_name() {
		return mn_use_dvs_name;
	}





	public void setMn_use_dvs_name(String mn_use_dvs_name) {
		this.mn_use_dvs_name = mn_use_dvs_name;
	}





	public String getMn_use_dvs_det_name() {
		return mn_use_dvs_det_name;
	}





	public void setMn_use_dvs_det_name(String mn_use_dvs_det_name) {
		this.mn_use_dvs_det_name = mn_use_dvs_det_name;
	}

	




	public String getSum_for_use_dvs_expense_sum() {
		return sum_for_use_dvs_expense_sum;
	}





	public void setSum_for_use_dvs_expense_sum(String sum_for_use_dvs_expense_sum) {
		this.sum_for_use_dvs_expense_sum = sum_for_use_dvs_expense_sum;
	}





	public String getSum_for_use_dvs_import_sum() {
		return sum_for_use_dvs_import_sum;
	}





	public void setSum_for_use_dvs_import_sum(String sum_for_use_dvs_import_sum) {
		this.sum_for_use_dvs_import_sum = sum_for_use_dvs_import_sum;
	}





	@Override
	public String toString() {
		return "UseDeailVO [mn_no=" + mn_no + ", mbr_no=" + mbr_no + ", mn_dtm=" + mn_dtm + ", mn_use_dvs=" + mn_use_dvs
				+ ", mn_pay_dvs=" + mn_pay_dvs + ", mn_use_dvs_det=" + mn_use_dvs_det + ", mn_use_memo=" + mn_use_memo 
				+ ", mn_rgst_dtm=" + mn_rgst_dtm + ", mn_rgst_id=" + mn_rgst_id + ", mn_upd_dtm=" + mn_upd_dtm 
				+", mn_upd_id=" + mn_upd_id + ", mn_amount=" + mn_amount +", mn_use_dvs_name=" + mn_use_dvs_name +", mn_use_dvs_det_name=" + mn_use_dvs_det_name 
				+", sum_for_use_dvs_expense_sum=" + sum_for_use_dvs_expense_sum + ", sum_for_use_dvs_import_sum=" + sum_for_use_dvs_import_sum +"]";
	}
}
