package com.yyh.nwpusurvivalmanual.controller;

import com.yyh.nwpusurvivalmanual.model.Course;
import com.yyh.nwpusurvivalmanual.service.CourseService;
import com.yyh.nwpusurvivalmanual.utils.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }


    @RequestMapping(value = "/course/all", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllCourseInfo(){
        List<Course> data;
        data = courseService.selectAll();

        return Result.success(data);
    }


    @RequestMapping(value = "course/search", method = RequestMethod.GET)
    @ResponseBody
    public Result getCourseInfoByParams(@RequestParam(value = "cno", defaultValue = "")String cno,
                                        @RequestParam(value = "cname", defaultValue = "")String cname,
                                        @RequestParam(value = "tname", defaultValue = "")String tname,
                                        @RequestParam(value = "dname", defaultValue = "")String dname,
                                        @RequestParam(value = "cclf", defaultValue = "")String cclf,
                                        @RequestParam(value = "slimit", defaultValue = "")String slimit){
        List<Course>data;
        try{
            data = courseService.selectByParams(cno, cname, tname, dname, cclf, slimit);
            return Result.success(data);

        }catch (Exception e){
            return Result.fail(e.getMessage(), 404, "course not found");
        }
    }
}
