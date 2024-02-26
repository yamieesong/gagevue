package kr.happyjob.study.repository.mypage;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.vo.login.UserVO;
import org.apache.ibatis.annotations.Mapper;

import kr.happyjob.study.vo.mypage.MypageModel;

@Mapper
public interface MypageMapper {

    // 공지사항 리스트 조회
    public List<MypageModel> expenditureList(Map<String, Object> paramMap) throws Exception;

    public List<MypageModel> cardCashStatisticsTest1(Map<String, Object> paramMap) throws Exception;

    public List<MypageModel> cardCashStatisticsTest2(Map<String, Object> paramMap) throws Exception;

    public void updateUser(UserVO vo) throws Exception;
}

