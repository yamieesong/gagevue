package kr.happyjob.study.service.menu;

import kr.happyjob.study.repository.menu.MenuMapper;
import kr.happyjob.study.vo.menu.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MenuService {
    @Autowired
    private MenuMapper mapper;

    public List<MenuVo> menuList(Map<String, Object> param) throws Exception {
        return mapper.menuList(param);
    }

    public int menuListCnt() throws Exception {
        return mapper.menuListCnt();
    }

    public List<MenuVo> tnUsrMnuAtrt(Map<String, Object> param) throws Exception {
        return mapper.tnUsrMnuAtrt(param);
    }

    public int tnUsrMnuAtrtCnt() throws Exception {
        return mapper.tnUsrMnuAtrtCnt();
    }
}
