package com.lss.st.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Menu {
    private Integer menuId;
    private String menuName;
    private String menuEnName;
    private Integer menuChildren;
}
