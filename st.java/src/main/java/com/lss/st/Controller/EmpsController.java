package com.lss.st.Controller;

import com.lss.st.Service.EmpService;
import com.lss.st.model.Employee;
import com.lss.st.model.Msg;
import com.lss.st.Config.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/emps")
public class EmpsController {
    @Autowired
    private EmpService empService;
    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping("/findall")
    public Msg findAll(HttpRequest request){
        List<Employee> emps=empService.findAll();
        return Msg.success().add("emps",emps);
    }
}
