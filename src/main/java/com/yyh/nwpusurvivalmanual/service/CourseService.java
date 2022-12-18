package com.yyh.nwpusurvivalmanual.service;

import com.yyh.nwpusurvivalmanual.entity.CnameWithLabel;
import com.yyh.nwpusurvivalmanual.model.Course;
import com.yyh.nwpusurvivalmanual.model.Manager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 对课程进行数据操作的接口
 *
 * @author Yuanhong Yu
 * @version 1.0
 */
@Repository
public interface CourseService {

    List<Course> selectAll();

    Course selectByCno(String Cno);

    List<Course> selectByCname(String Cname);

    List<Course> selectByParams(String cno, String cname, String tname,
                                String dname, String cclf, String slimit);
    List<Course> selectByParamsRegional(String cno, String cname, String tname,
                                String dname, String cclf, String slimit, int start, int offset);
    int insertCourse(Course course);

    int updateByCno(Course course);

    int deleteByCno(String cno);

    int selectCourseNum();

    List<Course>selectRegional(int start, int offset);

    List<CnameWithLabel>selectCourseByLabel(String label);

    int getValueBetweenCourses(String first, String second);

    int getValueBetweenCoursesByName(String first, String second);
}
