package kr.happyjob.study.repository.mypage;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.vo.login.UserVO;
import org.apache.ibatis.annotations.Mapper;

import kr.happyjob.study.vo.mypage.MypageModel;
import kr.happyjob.study.vo.mypage.MypageUserInfoModel;

@Mapper
public interface MypageMapper {

	/* React(리액트) */
	// 가계부 지출/수입 통계 page 조회
	public List<MypageModel> getgagevueListChart(Map<String, Object> paramMap);
	
	public List<MypageModel> getgagevueListPay(Map<String, Object> paramMap);
	
	// 가계뷰 지출/수입 총 합계
	public int getgagevueListChartTotal(Map<String, Object> paramMap);
	
    // =================================================================================================================== // 

	/* Vue(뷰) */
    // 가계뷰 지출입 내역 조회
    public List<MypageModel> expenditureList(Map<String, Object> paramMap) throws Exception;

    // 마이페이지 사용자 정보 조회
    public List<MypageUserInfoModel> getMypageUserInfo(Map<String, Object> paramMap) throws Exception;

    public List<MypageModel> cardCashStatisticsTest1(Map<String, Object> paramMap) throws Exception;

    public List<MypageModel> cardCashStatisticsTest2(Map<String, Object> paramMap) throws Exception;

    public void updateUser(UserVO vo) throws Exception;

    public void updateUserGoal(Map<String, Object> paramMap) throws Exception;

    public void updatePw(Map<String, Object> paramMap) throws Exception;


}

