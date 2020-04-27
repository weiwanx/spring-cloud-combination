package com.combination.user.service;

import com.combination.user.model.UsAdmin;
import com.combination.user.model.UsPermission;

import java.util.List;

/**
 * @author weiwanxi
 */
public interface UsAdminService {

    /**
     * 根据用户名获取后台管理员
     *
     * @param username
     * @return
     */
    UsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     *
     * @param usAdminParam
     * @return
     */
    UsAdmin register(UsAdmin usAdminParam);

    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     *
     * @param adminId
     * @return
     */
    List<UsPermission> getPermissionList(Long adminId);
}
