package com.combination.user.mapper;

import com.combination.user.model.UsRole;
import org.springframework.stereotype.Repository;

/**
 * UsRoleMapper继承基类
 * @author weiwanxi
 */
@Repository
public interface UsRoleMapper extends MyBatisBaseDao<UsRole, Long> {
}