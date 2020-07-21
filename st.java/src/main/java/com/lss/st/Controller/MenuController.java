package com.lss.st.Controller;

//import com.baomidou.dynamic.datasource.annotation.DS;
import com.lss.st.Service.MenuService;
import com.lss.st.model.Menu;
import com.lss.st.model.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;
    @ResponseBody
    @RequestMapping("/menus")
    public Msg findAllMenu(){
        List<Menu> menus=menuService.FindAll();
        return Msg.success().add("menus",menus);
    }
}
