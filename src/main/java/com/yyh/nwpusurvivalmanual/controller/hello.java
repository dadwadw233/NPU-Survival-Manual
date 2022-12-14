package com.yyh.nwpusurvivalmanual.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class hello {
    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public String helloworld(){
        return "Hello world !";
    }
}
