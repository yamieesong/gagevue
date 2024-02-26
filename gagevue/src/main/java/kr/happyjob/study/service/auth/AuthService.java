package kr.happyjob.study.service.auth;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.happyjob.study.repository.auth.AuthMapper;
import kr.happyjob.study.vo.auth.AuthModel;

@Service
public class AuthService {
	@Autowired
	private AuthMapper authMapper;
	
	/** 회원가입 */
	public AuthModel registerMbr(Map<String, Object> paramMap) { return authMapper.registerMbr(paramMap); }
	
	/** ID중복확인 */
	public int checkId(Map<String, Object> paramMap) { return authMapper.checkId(paramMap); }
	
	/** 회원가입 - 회원관리번호 채번 */
	public int mbrMngNoSeq() { return authMapper.mbrMngNoSeq(); }
	
	/** 회원가입 */
	public int insertRgstMbr(Map<String, Object> paramMap) { return authMapper.insertRgstMbr(paramMap); }
	
	/** 회원가입 - 회원관리번호 업데이트 */
	public int mbrMngNoSeqAdd(int mbrMngNo) { return authMapper.mbrMngNoSeqAdd(mbrMngNo); }
	
	/** 토큰생성 - 토큰생성(C 발급완료, S 인증완료) */
	public int uuidMbrUpdate(Map<String, Object> paramMap) { return authMapper.uuidMbrUpdate(paramMap); }
	
	/** 회원조회 - 인증상태조회 */
	public Map<String, Object> checkMbrAuthRst(Map<String, Object> paramMap) { return authMapper.checkMbrAuthRst(paramMap); }

	/** 회원조회 */
	public Map<String, Object> selectMbrMail(Map<String, Object> paramMap) { return authMapper.selectMbrMail(paramMap); }
	
	/** 회원조회 - 인증완료 */
	public int updateToken(Map<String, Object> paramMap) { return authMapper.updateToken(paramMap); }
	
	/** 비밀번호 변경 */
	public int updatePW(Map<String, Object> paramMap) { return authMapper.updatePW(paramMap); }

}
