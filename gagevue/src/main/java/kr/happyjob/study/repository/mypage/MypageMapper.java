package kr.happyjob.study.repository.mypage;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.happyjob.study.vo.mypage.MypageModel;

@Mapper
public interface MypageMapper {

	// 공지사항 리스트 조회
	public List<MypageModel> expenditureList(Map<String, Object> paramMap)throws Exception ;
	
}

