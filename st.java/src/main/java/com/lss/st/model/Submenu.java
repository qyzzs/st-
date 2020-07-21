package com.lss.st.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Submenu {
    private UUID submenuId;
    private String submenuName;
    private String submenuEnName;
    private Integer submenuNo;
    private String submeid;
    private String path;
}
