package com.combination.user.config.shiro.sysUser;

import com.combination.user.model.UsAdmin;
import com.combination.user.model.UsPermission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author weiwanxi
 */
public class AdminUserDetails implements UserDetails {

    private UsAdmin usAdmin;

    private List<UsPermission> permissionList;

    public AdminUserDetails(UsAdmin usAdmin, List<UsPermission> permissionList) {
        this.usAdmin = usAdmin;
        this.permissionList = permissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return permissionList.stream()
                .filter(permission -> permission.getValue()!=null)
                .map(permission ->new SimpleGrantedAuthority(permission.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return usAdmin.getPassWord();
    }

    @Override
    public String getUsername() {
        return usAdmin.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return usAdmin.getStatus().equals(1);
    }
}
