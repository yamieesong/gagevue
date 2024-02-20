package kr.happyjob.study.controller.comncod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import kr.happyjob.study.vo.comncod.ComnGrpCodModel;
import kr.happyjob.study.service.comncod.ComnCodService;


@Controller
@RequestMapping("/system/")
public class ComnCodController {
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();
	   
	@Autowired
	private ComnCodService comnCodService;


	/**
	 * 공통 그룹 코드 목록 조회
	 */
	@RequestMapping("vueListComnGrpCod.do")
	@ResponseBody
	public Map<String,Object> vuelistComnGrpCod(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".listComnGrpCod");
		logger.info("   - paramMap : " + paramMap);
		   
		
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));	// 현재 페이지 번호
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));			// 페이지 사이즈
		int pageIndex = (currentPage-1)*pageSize;												// 페이지 시작 row 번호
				
		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		
		Map<String,Object> resultMap= new HashMap<>();
		
		// 공통 그룹코드 목록 조회
		List<ComnGrpCodModel> listComnGrpCodModel = comnCodService.listComnGrpCod(paramMap);
		resultMap.put("listComnGrpCodModel", listComnGrpCodModel);
		
		// 공통 그룹코드 목록 카운트 조회
		int totalCount = comnCodService.countListComnGrpCod(paramMap);
		resultMap.put("totalCntComnGrpCod", totalCount);
		
		resultMap.put("pageSize", pageSize);
		resultMap.put("currentPageComnGrpCod",currentPage);
		
		logger.info("+ End " + className + ".listComnGrpCod");
		

		return resultMap;
	}
	
}