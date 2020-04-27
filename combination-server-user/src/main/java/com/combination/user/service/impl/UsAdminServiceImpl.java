package com.combination.user.service.impl;

import com.combination.user.config.shiro.jwt.JwtTokenUtil;
import com.combination.user.mapper.UsAdminMapper;
import com.combination.user.mapper.UsPermissionMapper;
import com.combination.user.model.UsAdmin;
import com.combination.user.model.UsPermission;
import com.combination.user.service.UsAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author weiwanxi
 */
@Service
public class UsAdminServiceImpl implements UsAdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsAdminServiceImpl.class);

    @Resource
    UsAdminMapper mapper;

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Resource
    private UsPermissionMapper usPermissionMapper;

    @Override
    public UsAdmin getAdminByUsername(String username) {
        return mapper.getAdminByUsername(username);
    }

    @Override
    public UsAdmin register(UsAdmin usAdminParam) {
        UsAdmin umsAdmin = new UsAdmin();
        BeanUtils.copyProperties(usAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassWord());
        umsAdmin.setPassWord(encodePassword);
        mapper.insert(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public List<UsPermission> getPermissionList(Long adminId) {
        return usPermissionMapper.getPermissionList(adminId);
    }
}
