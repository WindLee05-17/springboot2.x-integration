package com.wm.zgy.bootmybatismbplusshiroesquartz.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/6/14 22:50
 * @Modified by:
 */
@RequestMapping("/shiro")
@RestController
@Slf4j
public class ShiroController {

    @RequestMapping(value = {"/index","/test"})
    @ResponseBody
    public String shiroIndex(){
        return "hello shiro";
    }

    @RequestMapping("addmsg")
    public String add(){
        return "addmsg";
    }

    @RequestMapping("getmsg")
    public String getMsg(){
        return "getmsg";
    }

}
