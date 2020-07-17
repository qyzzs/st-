package com.lss.st.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class User {
    private String userId;
    private String userName;
    private String userPwd;
    private String Gender;
    private String Mobile;
    private String Adress;
    private String University;
    private Date Birthday;
    private Date Created;
    private String rightId;

}
