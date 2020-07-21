package com.lss.st;

import com.lss.st.dao.MenuDao;
import com.lss.st.dao.UserDao;
import com.lss.st.model.Menu;
import com.lss.st.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestDao {
    @Autowired
    private UserDao userDao;
    @Autowired
    private MenuDao menuDao;
@Test
    public void test(){
        List<User> lis = userDao.selectList(null);
        lis.forEach(user -> System.out.println("user="+user));
        List<Menu> l = menuDao.selectList(null);
        l.forEach(u-> System.out.println(u));
    }
    @Test
    public  void test1(){
        menuDao.selectWithSubmenu().forEach(munu -> System.out.println(munu));
    }
}
