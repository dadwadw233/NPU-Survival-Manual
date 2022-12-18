package com.yyh.nwpusurvivalmanual.controller;

import com.yyh.nwpusurvivalmanual.entity.CommentManager;
import com.yyh.nwpusurvivalmanual.entity.CommentUser;
import com.yyh.nwpusurvivalmanual.model.comment;
import com.yyh.nwpusurvivalmanual.model.Course;
import com.yyh.nwpusurvivalmanual.service.CommentService;
import com.yyh.nwpusurvivalmanual.utils.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;


    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @RequestMapping(value = "/comment/all", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllCommentInfo(){
        List<comment> data;
        data = commentService.selectAll();

        return Result.success(data);
    }

    @RequestMapping(value = "/comment/user", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllCommentInfoUser(){
        List<CommentUser> data;
        data = commentService.selectAllUser();

        return Result.success(data);
    }

    @RequestMapping(value = "/comment/manager", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllCommentInfoManager(){
        List<CommentManager> data;
        data = commentService.selectAllManager();

        return Result.success(data);
    }
}
