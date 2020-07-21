package com.lss.st.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lss.st.Service.EmpService;
import com.lss.st.model.Employee;
import com.lss.st.model.Msg;
import com.lss.st.Config.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/emps")
public class EmpsController {
    @Autowired
    private EmpService empService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/findall")
    @ResponseBody
    public Msg findAll(@RequestParam(defaultValue = "1")Integer pageIndex,@RequestParam(defaultValue = "5")Integer pageSize){
        Employee employee=new Employee();
        IPage<Employee> empPage=empService.FindAllByPage(pageIndex,pageSize,employee);
        empPage.getRecords().forEach(employ -> System.out.println(employ));
        List<Employee> emps=empPage.getRecords();
        Long total=empPage.getTotal();
        return Msg.success().add("emps",emps).add("total",total);
    }

}
