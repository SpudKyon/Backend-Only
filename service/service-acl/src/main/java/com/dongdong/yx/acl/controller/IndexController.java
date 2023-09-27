package com.dongdong.yx.acl.controller;

import com.dongdong.yx.common.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/admin/acl/index")
@CrossOrigin
public class IndexController {

    @PostMapping("login")
    public Result login() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("token","admin-token");
        return Result.success(map);
    }

    @GetMapping("info")
    public Result info(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","atguigu");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return Result.success(map);
    }

    @PostMapping("logout")
    public Result logout(){
        return Result.success(null);
    }
}