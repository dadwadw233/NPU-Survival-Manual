package com.yyh.nwpusurvivalmanual.controller;

import com.yyh.nwpusurvivalmanual.model.Course;
import com.yyh.nwpusurvivalmanual.service.CourseService;
import com.yyh.nwpusurvivalmanual.utils.response.Result;
import org.apache.ibatis.jdbc.Null;
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

    @RequestMapping(value = "course/new", method = RequestMethod.POST)
    @ResponseBody
    public Result insertCourse(@RequestBody Course course
                               ){
        //主键必填交由前端处理，这里默认主键全部非空

        //Course newCourse = new Course(course.getCno(), course.getCname(), tname, dname, cclf, credit, csche, exam, length, slimit, campus, description);
        //return Result.success(course);/*
        try {
            courseService.insertCourse(course);
            System.out.println("good");
            return Result.success(null);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Result.fail(null, 114, e.getMessage());
        }

    }
}
