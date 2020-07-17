package com.lss.st.Controller;

import com.lss.st.Service.UserService;
import com.lss.st.model.Msg;
import com.lss.st.model.User;
import com.lss.st.Config.redis.RedisUtil;
import com.lss.st.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;

    TokenUtils tokenUtils=new TokenUtils();
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Msg checklogin(String username,String password){
        User user=new User();
        user.setUserName(username);
        user.setUserPwd(password);
        User user1=userService.selectOne(user);
        String token=tokenUtils.getToken(password);
        redisUtil.set("token",token);
        System.out.println(token);
        return Msg.success().add("user",userService.selectOne(user)).add("token",token);

    }
}
