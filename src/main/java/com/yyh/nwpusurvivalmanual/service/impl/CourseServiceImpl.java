package com.yyh.nwpusurvivalmanual.service.impl;


import com.yyh.nwpusurvivalmanual.entity.CnameWithLabel;
import com.yyh.nwpusurvivalmanual.mapper.CourseMapper;
import com.yyh.nwpusurvivalmanual.model.Course;
import com.yyh.nwpusurvivalmanual.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseMapper courseMapper;

    @Autowired
    public CourseServiceImpl(CourseMapper courseMapper){
        this.courseMapper = courseMapper;
    }

    @Override
    public List<Course>selectAll(){
        return this.courseMapper.selectAll();
    }

    @Override
    public Course selectByCno(String Cno) {
        return this.courseMapper.selectByCno(Cno);
    }

    @Override
    public List<Course> selectByCname(String Cname){
        return this.courseMapper.selectByCname(Cname);
    }

    @Override
    public List<Course> selectByParams(String cno, String cname, String tname, String dname, String cclf, String slimit) {
        return this.courseMapper.selectByParams(cno, cname, tname, dname, cclf, slimit);
    }

    @Override
    public List<Course> selectByParamsRegional(String cno, String cname, String tname,
                                        String dname, String cclf, String slimit, int start, int offset){
        return this.courseMapper.selectByParamsRegional(cno, cname, tname, dname, cclf, slimit, start, offset);
    }

    @Override
    public int insertCourse(Course course){
        return this.courseMapper.insertCourse(course);
    }

    @Override
    public int updateByCno(Course course){return this.courseMapper.updateByCno(course);}

    @Override
    public int deleteByCno(String cno){return this.courseMapper.deleteByCno(cno);}

    @Override
    public int selectCourseNum(){return this.courseMapper.selectCouseNum();}

    @Override
    public List<Course>selectRegional(int start, int offset){return this.courseMapper.selectRegional(start, offset);}

    @Override
    public List<CnameWithLabel>selectCourseByLabel(String label){return this.courseMapper.selectCourseByLabel(label);}

    @Override
    public int getValueBetweenCourses(String first, String second){return this.courseMapper.getValueBetweenCourses(first, second);}

    @Override
    public int getValueBetweenCoursesByName(String first, String second){return this.courseMapper.getValueBetweenCoursesByName(first, second);}
}
