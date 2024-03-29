package kr.happyjob.study.repository.auth;

import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {
	
	/** ID중복확인 */
	public int checkId(Map<String, Object> paramMap);
	
	/** 회원가입 - 회원관리번호, 목표관리번호 채번 */
	public Map<String, Object> mbrMngNoSeq();
	
	/** 회원가입 - 회원정보 INSERT (회원정보 tb_userinfo) */
	public int insertRgstMbr(Map<String, Object> paramMap);
	
	/** 회원가입 - 회원정보 INSERT (목표관리 tb_goal) */
	public int insertGoal(Map<String, Object> paramMap);
	
	/** 회원가입 - 회원관리번호, 목표관리번호 업데이트 */
	public int mbrMngNoSeqAdd(Map<String, Object> paramMap);
	
	/** 토큰생성 - 토큰생성(C 발급완료, S 인증완료) */
	public int uuidMbrUpdate(Map<String, Object> paramMap);
	
	/** 회원조회 - 인증상태조회 */
	public Map<String, Object> checkMbrAuthRst(Map<String, Object> paramMap);

	/** 회원조회 */
	public Map<String, Object> selectMbrMail(Map<String, Object> paramMap);
	
	/** 회원조회 - 인증완료 */
	public int updateToken(Map<String, Object> paramMap);
	
	/** 비밀번호 변경 */
	public int updatePW(Map<String, Object> paramMap);
}

