package com.dllyal.forum.controller;

import com.dllyal.forum.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping(value = "index/")
public class MyController {

    private static final Logger LOG = LoggerFactory.getLogger(MyController.class);

    @Resource(name = "userService")
    public UserService userService;

    @RequestMapping(value = "hello", produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String index() {
        return "hi , ご主人様";
    }

    // inject via application.yml
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "index";
    }

}
