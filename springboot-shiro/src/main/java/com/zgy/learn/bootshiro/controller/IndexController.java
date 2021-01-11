package com.zgy.learn.bootshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author zuiguangyin
 * @Date 2020/11/5
 * @Description
 */
@Controller
public class IndexController {

    @RequestMapping({"", "/", "home", "index"})
    public String index(Model model) {
        model.addAttribute("message", "这是来自后端的测试消息!");
        return "index";
    }


    @RequestMapping("user/add")
    public String add(Model model) {
        model.addAttribute("message", "add页面!");
        return "user/add";
    }


    @RequestMapping("user/search")
    public String search(Model model) {
        model.addAttribute("message", "search页面!");
        return "user/search";
    }


    @RequestMapping("user/update")
    public String update(Model model) {
        model.addAttribute("message", "update页面!");
        return "user/update";
    }


    @RequestMapping("login")
    public String login() {
        return "login";
    }


    @PostMapping("login")
    public String login(String username, String password, Model model) {
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行登录方法
        try {
            subject.login(token);

            // 当前用户是否登录, 如果成功, 就不显示登录按钮了
            Subject currentSubject = SecurityUtils.getSubject();
            Session session = currentSubject.getSession();
            session.setAttribute("loginUser", username);

            return "index";

        } catch (UnknownAccountException e1) {
            model.addAttribute("message", "用户名错误");
            return "login";
        } catch (IncorrectCredentialsException e2) {
            model.addAttribute("message", "密码错误");
            return "login";
        }
    }


    @GetMapping("401")
    public String unauthorized() {
        return "401";
    }


    @GetMapping("logout")
    public String logout() {
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 执行退出方法
        subject.logout();

        return "index";
    }
}
