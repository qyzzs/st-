package com.lss.st.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Menu implements Serializable {
    private Integer menuId;
    private String menuName;
    private String menuEnName;
    private UUID submenuId;
    @TableField(exist = false)
    private List<Submenu> submenuList;
}
