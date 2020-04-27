package com.combination.user.controller;

import com.combination.user.common.CommonResult;
import com.combination.user.model.UsAdmin;
import com.combination.user.model.UsPermission;
import com.combination.user.param.UsAdminLoginParam;
import com.combination.user.service.UsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weiwanxi
 */
@RestController
@RequestMapping("/admin")
public class UsAdminController {

    @Resource
    private UsAdminService adminService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * 登录用户注册
     *
     * @param usAdminParam
     * @param result
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UsAdmin> register(@RequestBody UsAdmin usAdminParam, BindingResult result) {
        UsAdmin usAdmin = adminService.register(usAdminParam);
        if (usAdmin == null) {
            CommonResult.failed();
        }
        return CommonResult.success(usAdmin);
    }

    /**
     * 登录以后返回token
     *
     * @param usAdminLoginParam
     * @param result
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UsAdminLoginParam usAdminLoginParam, BindingResult result) {
        String token = adminService.login(usAdminLoginParam.getUserName(), usAdminLoginParam.getPassWord());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    /**
     * 获取用户所有权限（包括+-权限）
     *
     * @param adminId
     * @return
     */
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UsPermission>> getPermissionList(@PathVariable Long adminId) {
        List<UsPermission> permissionList = adminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }
}
