package com.lss.st.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lss.st.model.Menu;

import java.util.List;

public interface MenuDao extends BaseMapper<Menu> {
    List<Menu> selectWithSubmenu();
}
