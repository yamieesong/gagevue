package kr.happyjob.study.service.comncod;

import java.util.List;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.repository.login.ListUsrMnuAtrtMapper;
import kr.happyjob.study.vo.comncod.ComnCodUtilModel;
import kr.happyjob.study.vo.comncod.ComnGrpCodModel;
import kr.happyjob.study.vo.comncod.ComnDtlCodModel;
import kr.happyjob.study.repository.comncod.ComnCodMapper;

@Service
public class ComnCodService {
	
	private ListUsrMnuAtrtMapper listUsrMnuAtrtMapper;
	
	@Autowired
	private ComnCodMapper comnCodMapper;
	
	// Set logger
		private final Logger logger = LogManager.getLogger(this.getClass());
		
		// Get class name for logger
		private final String className = this.getClass().toString();
		
		/** 그룹코드 목록 조회 */
		public List<ComnGrpCodModel> listComnGrpCod(Map<String, Object> paramMap) throws Exception {
			
			return comnCodMapper.listComnGrpCod(paramMap);
		}
		
		/** 그룹코드 목록 카운트 조회 */
		public int countListComnGrpCod(Map<String, Object> paramMap) throws Exception {
			
			return comnCodMapper.countListComnGrpCod(paramMap);
		}
		
		/** 그룹코드 단건 조회 */
		public ComnGrpCodModel selectComnGrpCod(Map<String, Object> paramMap) throws Exception {
			
			return comnCodMapper.selectComnGrpCod(paramMap);
		}
		
		/** 그룹코드 저장 */
		public int insertComnGrpCod(Map<String, Object> paramMap) throws Exception {
			
			return comnCodMapper.insertComnGrpCod(paramMap);
		}
		
		/** 그룹코드 수정 */
		public int updateComnGrpCod(Map<String, Object> paramMap) throws Exception {
			
			return comnCodMapper.updateComnGrpCod(paramMap);
		}
		
		/** 그룹코드 삭제 */
		public int deleteComnGrpCod(Map<String, Object> paramMap) throws Exception {
			
			return comnCodMapper.deleteComnGrpCod(paramMap);
		}
		
		/** 상세코드 목록 조회 */
		public List<ComnDtlCodModel> listComnDtlCod(Map<String, Object> paramMap) throws Exception {
			
			return comnCodMapper.listComnDtlCod(paramMap);
		}
		
		/** 그룹코드 목록 카운트 조회 */
		public int countListComnDtlCod(Map<String, Object> paramMap) throws Exception {
			
			return comnCodMapper.countListComnDtlCod(paramMap);
		}
		
		/** 상세코드 단건 조회 */
		public ComnDtlCodModel selectComnDtlCod(Map<String, Object> paramMap) throws Exception {
			
			return comnCodMapper.selectComnDtlCod(paramMap);
		}
		
		/** 상세코드 저장 */
		public int insertComnDtlCod(Map<String, Object> paramMap) throws Exception {
			
			return comnCodMapper.insertComnDtlCod(paramMap);
		}
		
		/** 상세코드 수정 */
		public int updateComnDtlCod(Map<String, Object> paramMap) throws Exception {
			
			return comnCodMapper.updateComnDtlCod(paramMap);
		}
		
		/** 상세코드 삭제 */
		public int deleteComnDtlCod(Map<String, Object> paramMap) throws Exception {
			
			return comnCodMapper.deleteComnDtlCod(paramMap);
		}
		
		/** 사용가능한 모든 공통코드 조회 */
		public List<ComnCodUtilModel> listAllComnCode(Map<String, Object> paramMap) throws Exception {
			
			return comnCodMapper.listAllComnCode(paramMap);
		}
	
}
