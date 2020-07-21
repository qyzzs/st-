package com.lss.st.Service.Impl;

import com.lss.st.Service.MenuService;
import com.lss.st.dao.MenuDao;
import com.lss.st.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Menu> FindAll() {
        return menuDao.selectList(null);
    }

    @Override
    public List<Menu> selectWithSubmenu() {
        return menuDao.selectWithSubmenu();
    }
}
