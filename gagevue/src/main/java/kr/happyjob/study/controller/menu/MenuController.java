package kr.happyjob.study.controller.menu;

import kr.happyjob.study.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MenuController {
    @Autowired
    private MenuService service;

    @GetMapping("/menuList")
    public Map<String, Object> menuList(@RequestParam Map<String, Object> paramMap) throws Exception {
        System.out.println(paramMap);
        int currentPage = Integer.parseInt((String) paramMap.get("currentPage"));    // 현재 페이지 번호
        int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));            // 페이지 사이즈
        int pageIndex = (currentPage - 1) * pageSize;                                                // 페이지 시작 row 번호
        paramMap.put("pageIndex", pageIndex);
        paramMap.put("pageSize", pageSize);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("menuList", service.menuList(paramMap));
        resultMap.put("menuListCnt", service.menuListCnt());
        return resultMap;
    }

    @GetMapping("/tnUsrMnuAtrt")
    public Map<String, Object> tnUsrMnuAtrt(@RequestParam Map<String, Object> paramMap) throws Exception {
        System.out.println(paramMap);
        int currentPage = Integer.parseInt((String) paramMap.get("currentPage"));    // 현재 페이지 번호
        int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));            // 페이지 사이즈
        int pageIndex = (currentPage - 1) * pageSize;                                                // 페이지 시작 row 번호
        paramMap.put("pageIndex", pageIndex);
        paramMap.put("pageSize", pageSize);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("tnUsrMnuAtrt", service.tnUsrMnuAtrt(paramMap));
        resultMap.put("tnUsrMnuAtrtCnt", service.tnUsrMnuAtrtCnt());
        return resultMap;
    }
}
