package com.combination.user.mapper;

import com.combination.user.model.UsPermission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UsPermissionMapper继承基类
 * @author weiwanxi
 */
@Repository
public interface UsPermissionMapper extends MyBatisBaseDao<UsPermission, Long> {

    /**
     * 根据用户id查询权限
     *
     * @param pid
     * @return
     */
    List<UsPermission> getPermissionList(Long pid);
}