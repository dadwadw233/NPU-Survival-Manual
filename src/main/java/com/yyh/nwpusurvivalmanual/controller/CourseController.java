package com.yyh.nwpusurvivalmanual.controller;

import com.yyh.nwpusurvivalmanual.entity.CnameWithLabel;
import com.yyh.nwpusurvivalmanual.model.Course;
import com.yyh.nwpusurvivalmanual.service.CourseService;
import com.yyh.nwpusurvivalmanual.utils.response.Result;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
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

    @RequestMapping(value = "course/search/limit", method = RequestMethod.GET)
    @ResponseBody
    public Result getCourseInfoByParamsRegional(@RequestParam(value = "cno", defaultValue = "")String cno,
                                        @RequestParam(value = "cname", defaultValue = "")String cname,
                                        @RequestParam(value = "tname", defaultValue = "")String tname,
                                        @RequestParam(value = "dname", defaultValue = "")String dname,
                                        @RequestParam(value = "cclf", defaultValue = "")String cclf,
                                        @RequestParam(value = "slimit", defaultValue = "")String slimit,
                                                @RequestParam(value = "start", defaultValue = "")String start,
                                                @RequestParam(value = "offset", defaultValue = "")String offset){
        List<Course>data;
        try{
            int a = Integer.parseInt(start);
            int b = Integer.parseInt(offset);
            data = courseService.selectByParamsRegional(cno, cname, tname, dname, cclf, slimit,a,b);
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
        try {
            courseService.insertCourse(course);
            System.out.println("good");
            return Result.success(null);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Result.fail(null, 114, e.getMessage());
        }
    }

    @RequestMapping(value = "course/update", method = RequestMethod.POST)
    @ResponseBody
    public Result updateByCno(@RequestBody Course course){
        try {
            this.courseService.updateByCno(course);
            return Result.success(null);
        }catch (Exception e){
            return  Result.fail(null, 115, e.getMessage());
        }
    }

    @RequestMapping(value = "course/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result deleteByCno(@RequestBody Course course){
        if (this.courseService.selectByCno(course.getCno()) == null){
            return Result.fail(null, 117, "has no course");
        }
        try {
            this.courseService.deleteByCno(course.getCno());
            return Result.success(null);
        }catch (Exception e){
            return Result.fail(null, 116, e.getMessage());
        }
    }

    @RequestMapping(value = "course/getnum", method = RequestMethod.GET)
    @ResponseBody
    public Result getCourseNum(){
        return Result.success(this.courseService.selectCourseNum());
    }

    @RequestMapping(value = "course/limit", method = RequestMethod.GET)
    @ResponseBody
    public Result selectRegional(@RequestParam(value = "start", defaultValue = "")String start,
                                 @RequestParam(value = "offset", defaultValue = "")String offset){
        List<Course> data;
        try {
            int a = Integer.parseInt(start);
            int b = Integer.parseInt(offset);
            data = this.courseService.selectRegional(a, b);
            return Result.success(data);
        }catch (Exception e){
            return Result.fail(e.getMessage(), 404, "select error");
        }
    }


    @RequestMapping(value = "course/get", method = RequestMethod.GET)
    @ResponseBody
    public Result selectCourseByLabel(@RequestParam(value = "label", defaultValue = "")String label){
        List<CnameWithLabel> data;
        try {
            data = this.courseService.selectCourseByLabel(label);
            return Result.success(data);
        }catch (Exception e){
            return Result.fail(e.getMessage(), 404, "select error");
        }
    }

    @RequestMapping(value = "course/relation", method = RequestMethod.GET)
    @ResponseBody
    public Result getValueBetweenCourses(@RequestParam(value = "first", defaultValue = "")String first,
                                         @RequestParam(value = "second", defaultValue = "")String second){
        int data;
        try {
            data = this.courseService.getValueBetweenCourses(first, second);
            return Result.success(data);
        }catch (Exception e){
            return Result.fail(e.getMessage(), 404, "select error");
        }
    }

    @RequestMapping(value = "course/relation/name", method = RequestMethod.GET)
    @ResponseBody
    public Result getValueBetweenCoursesByName(@RequestParam(value = "first", defaultValue = "")String first,
                                         @RequestParam(value = "second", defaultValue = "")String second){
        int data;
        try {
            data = this.courseService.getValueBetweenCoursesByName(first, second);
            return Result.success(data);
        }catch (Exception e){
            return Result.fail(e.getMessage(), 404, "select error");
        }
    }
}
