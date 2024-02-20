package kr.happyjob.study.repository.auth;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import kr.happyjob.study.vo.auth.AuthModel;
import kr.happyjob.study.vo.auth.AuthVO;
import kr.happyjob.study.vo.login.LgnInfoModel;
import kr.happyjob.study.vo.login.UsrMnuAtrtModel;
import kr.happyjob.study.vo.login.UsrMnuChildAtrtModel;

@Mapper
public interface AuthMapper {
	
	AuthModel registerMbr(Map<String, Object> paramMap);
	
	/** 아이디 중복 확잊*/
	int checkId(Map<String, Object> paramMap);
	
	/** 회원관리번호 채번 */
	int mbrMngNoSeq();
	/** 회원가입 - 회원정보 INSERT */
	int insertRgstMbr(Map<String, Object> paramMap);
	/** 회원관리번호 업데이트(SEQ) */
	int mbrMngNoSeqAdd(int mbrMngNo);
}

