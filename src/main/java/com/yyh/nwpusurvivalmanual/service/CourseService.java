package com.yyh.nwpusurvivalmanual.service;

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
}