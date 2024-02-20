package kr.happyjob.study.service.auth;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.repository.login.ListUsrMnuAtrtMapper;
import kr.happyjob.study.repository.login.LoginMapper;
import kr.happyjob.study.repository.login.LoginProcMapper;
import kr.happyjob.study.repository.auth.AuthMapper;
import kr.happyjob.study.repository.login.ListUsrChildMnuAtrtMapper;
import kr.happyjob.study.vo.auth.AuthModel;
import kr.happyjob.study.vo.login.LgnInfoModel;
import kr.happyjob.study.vo.login.LoginVO;
import kr.happyjob.study.vo.login.UserVO;
import kr.happyjob.study.vo.login.UsrMnuAtrtModel;
import kr.happyjob.study.vo.login.UsrMnuChildAtrtModel;

@Service
public class AuthService {
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	   
	
	@Autowired
	private AuthMapper authMapper;
	
	/** 회원가입 */
	public AuthModel registerMbr(Map<String, Object> paramMap) {
		//logger.info("   - loginProc service ParamMap : " + paramMap);
		AuthModel authModel = authMapper.registerMbr(paramMap);
		//logger.info("   - loginProc service lgnInfoModel : " + lgnInfoModel);
		
		return authModel;
	}
	
	/** 아이디 중복 확인 */
	public int checkId(Map<String, Object> paramMap) {
		int rst = 0;
		
		rst = authMapper.checkId(paramMap);
		return rst;
	}
	
	
	/** 회원관리번호 채번 */
	public int mbrMngNoSeq() {
		int rst = 0;
		
		rst = authMapper.mbrMngNoSeq();
		return rst;
	}
	/** 회원가입 - 회원정보 INSERT */
	public int insertRgstMbr(Map<String, Object> paramMap) {
		int rst = 0;
		
		rst = authMapper.insertRgstMbr(paramMap);
		return rst;
	}
	/** 회원관리번호 업데이트(SEQ) */
	public int mbrMngNoSeqAdd(int mbrMngNo) {
		int rst = 0;
		
		rst = authMapper.mbrMngNoSeqAdd(mbrMngNo);
		return rst;
	}

}
