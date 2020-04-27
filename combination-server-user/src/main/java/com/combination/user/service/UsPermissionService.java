package com.combination.user.service;

import com.combination.user.model.UsPermission;

import java.util.List;

/**
 * @author weiwanxi
 */
public interface UsPermissionService {

    /**
     * 根据用户id查询权限
     *
     * @param id
     * @return
     */
    List<UsPermission> getPermissionList(Long id);
}
