package com.combination.user.param;

import lombok.Data;
import lombok.ToString;

/**
 * @author weiwanxi
 */
@Data
@ToString
public class UsAdminLoginParam {

    /**
     * 用户编号
     */
    private String userName;

    /**
     * 用户密码
     */
    private String passWord;
}
