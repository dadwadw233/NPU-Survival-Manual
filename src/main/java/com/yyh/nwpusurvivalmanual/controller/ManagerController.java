package com.yyh.nwpusurvivalmanual.controller;
import com.yyh.nwpusurvivalmanual.utils.response.Result;

import com.yyh.nwpusurvivalmanual.model.Manager;
import com.yyh.nwpusurvivalmanual.service.ManagerService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerController {
    private final ManagerService managerService;


    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @RequestMapping(value = "/manager/manager_info", method = RequestMethod.GET)
    @ResponseBody
    public Result postManagerInfo(){
        List<Manager> managers;
        managers = managerService.selectAll();

        return new Result(managers, 200, "success");
    }
}
