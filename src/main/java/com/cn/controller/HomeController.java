package com.cn.controller;

import com.cn.common.annotation.MyLog;
import com.cn.entity.User;
import com.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author chenyun
 * @projectName springboot
 * @description: 主页加载类
 * @date 2019/8/30 13:52
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    @ResponseBody
    public String getHome() {
        return "hello,spring-boot!!!";
    }

    @RequestMapping("/getUserList")
    public String getUsers(Model model) {
        List<User> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "user/userList";
    }

    @MyLog(value = "通过id获取用户信息")  //这里添加了AOP的自定义注解
    @RequestMapping("/getUserById")
    @ResponseBody
    public Object getUserById(Long id) {
        User user = userService.getUserById(id);
        JSONObject object = new JSONObject();
        if(user!=null){
            object.put("status","SUCCESS");
            object.put("msg",user);
        }else{
            object.put("status","FALSE");
            object.put("msg","未查询到用户信息");
        }
        return object;
    }

    @MyLog(value = "更新用户信息")  //这里添加了AOP的自定义注解
    @RequestMapping("/updateUser")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Object updateUser(Long id,String nickname)  throws Exception{
        JSONObject object = new JSONObject();
        User user = new User();
        user.setId(id);
        user.setNickname(nickname);
        int i = userService.updateUser(user);
        if(i>0){
            object.put("status","SUCCESS");
            object.put("msg",user);
        }else{
            //手动事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            object.put("status","FALSE");
            object.put("msg","更新失败");
        }
        try {
            int value = 5/0;
        }catch (Exception e){
            e.printStackTrace();
            //异常抛出，自动回滚
            throw new Exception("抛异常了");
        }
        return object;
    }
}

