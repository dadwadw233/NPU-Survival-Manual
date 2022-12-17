package com.yyh.nwpusurvivalmanual.mapper;
import com.yyh.nwpusurvivalmanual.model.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 实现数据库中activity表与Activity类的映射
 *
 * @author Yuanhong YU
 * @see Course
 * @version 1.0
 */

@Mapper
public interface CourseMapper {
    /**
     * 读取course表中的所有行，并映射为Course对象
     * @param
     * @return 包含所有Course的Course列表
     */
    @Select("SELECT * FROM course")
    List<Course>selectAll();


    @Select("SELECT * FROM course WHERE cno=#{cno}")
    Course selectByCno(@Param("cno")String cno);

    @Select("SELECT * FROM course WHERE cname like CONCAT('%',#{cname},'%')")
    List<Course>selectByCname(@Param("cname")String cname);

    @Select("SELECT * FROM course WHERE cno like CONCAT('%',#{cno},'%')" +
            "AND cname like CONCAT('%',#{cname},'%') AND tname like CONCAT('%',#{tname},'%')" +
            "AND dname like CONCAT('%',#{dname},'%') AND cclf like CONCAT('%',#{cclf},'%')" +
            "AND slimit like CONCAT('%',#{slimit},'%')")
    List<Course>selectByParams(@Param("cno")String cno, @Param("cname")String cname, @Param("tname")String tname,
                               @Param("dname")String dname, @Param("cclf")String cclf, @Param("slimit")String slimit);


    @Insert("INSERT INTO course VALUES(#{cno},#{cname},#{tname},#{dname},#{cclf},#{credit},#{csche}," +
            "#{exam},#{length},#{slimit},#{campus},#{description})")
    int insertCourse(Course course);

    @Update("UPDATE course SET cname=#{cname},tname=#{tname},dname=#{dname},cclf=#{cclf},credit=#{credit}," +
            "csche=#{csche},exam=#{exam},length=#{length},slimit=#{slimit},campus=#{campus},description=#{description} where" +
            " cno=#{cno}")
    int updateByCno(Course course);
    @Delete("DELETE FROM course WHERE cno=#{cno}")
    int deleteByCno(@Param("cno")String cno);
}
