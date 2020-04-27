package com.combination.user.service.impl;

import com.combination.user.mapper.UsPermissionMapper;
import com.combination.user.model.UsPermission;
import com.combination.user.service.UsPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author weiwanxi
 */
@Service
public class UsPermissionServiceImpl implements UsPermissionService {

    @Resource
    UsPermissionMapper mapper;

    @Override
    public List<UsPermission> getPermissionList(Long id) {
        return mapper.getPermissionList(id);
    }
}
