package com.combination.user.mapper;

import com.combination.user.model.UsAdmin;
import com.combination.user.model.UsPermission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UsAdminMapper继承基类
 * @author weiwanxi
 */
@Repository
public interface UsAdminMapper extends MyBatisBaseDao<UsAdmin, Long> {

    /**
     * 根据username查询用户信息
     *
     * @param username
     * @return
     */
    UsAdmin getAdminByUsername(String username);
}