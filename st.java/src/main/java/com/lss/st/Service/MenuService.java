package com.lss.st.Service;

import com.lss.st.model.Menu;

import java.util.List;

public interface MenuService {
    public List<Menu> FindAll();
    public List<Menu> selectWithSubmenu();
}
